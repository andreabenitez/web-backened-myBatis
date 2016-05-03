package servicios;

import config.SqlSessionFactoryProvider;
import excepciones.CompraException;
import modelos.Compra;
import modelos.CompraDetalle;
import modelos.Producto;
import org.apache.ibatis.session.SqlSession;
import utils.Validation;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Created by andrea on 25/04/16.
 */
@Stateless
public class CompraServicioMapperImpl {


    @Inject
    ProductoServicioMapperImpl productoServicioMapper;

    @Inject
    ProveedorServicioMapperImpl proveedorServicioMapper;


    public int agregarCompra(Compra compra) throws CompraException {
        try {
            return crearCompra(compra);
        } catch (Exception e) {
            throw new CompraException("Ha ocurrido un error durante el proceso de compra: " + e.getMessage());
        }

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public int crearCompra(Compra compra) throws CompraException, IOException {
        SqlSession sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
        try {

            String dateString = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            compra.setDate(dateString);
            Float total = new Float(0.0);
            compra.setTotal(total);
            Validation validation = validarCompra(compra);
            if (!(validation.getIsError())) {
                sqlSession.insert("agregarCompra", compra);
                //compraMapper.agregarCompra(compra);
                for (CompraDetalle compraDetalle : compra.getCompraDetalles()) {
                    compraDetalle.setId_compra(compra.getId_compra());
                    Producto producto = productoServicioMapper.buscarProducto(compraDetalle.getId_producto());
                    producto.setCantidad(producto.getCantidad() + compraDetalle.getCantidad());
                    productoServicioMapper.modificarProducto(producto);
                    total = total + ((producto.getPrecioUnitario() * compraDetalle.getCantidad()));
                }
                sqlSession.insert("insertCompraDetalles", compra);
                //compraDetalleMapper.insertCompraDetalles(compra);
                compra.setTotal(total);
                return sqlSession.update("modificarCompra", compra);
                //return compraMapper.modificarCompra(compra);

            } else {
                throw new CompraException(validation.getMessage());
            }
        } finally {
            sqlSession.close();
        }

    }

    public Validation validarCompra(Compra compra) throws IOException {
        String errorMessagge = "";
        Boolean isError = false;

        if (compra.getCompraDetalles().isEmpty()) {
            errorMessagge += "No hay ningun detalle en la compra. ";
            isError = true;
        }

        if (!(proveedorServicioMapper.countProveedor(compra.getId_proveedor()) > 0)) {
            errorMessagge += "No hay ningun proveedor con id: " + compra.getId_proveedor();
            isError = true;
        }

        for (CompraDetalle compraDetalle : compra.getCompraDetalles()) {
            Producto producto = productoServicioMapper.buscarProducto(compraDetalle.getId_producto());
            if (!(producto.getProveedor().getId_proveedor().equals(compra.getId_proveedor()))) {
                errorMessagge += "El producto" + producto.toString() + "no pertenece al proveedor seleccionado: " + compra.getId_proveedor();
            }
        }
        return new Validation(isError, errorMessagge);
    }
}
