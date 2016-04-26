package servicios;

import excepciones.CompraException;
import mapper.CompraDetalleMapper;
import mapper.CompraMapper;
import mapper.ProveedorMapper;
import modelos.Compra;
import modelos.CompraDetalle;
import org.mybatis.cdi.Mapper;
import utils.Validation;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by andrea on 25/04/16.
 */
public class CompraServicioMapperImpl implements CompraServicio {

    @Inject
    @Mapper
    ProveedorMapper proveedorMapper;

    @Inject
    @Mapper
    CompraMapper compraMapper;

    @Inject
    @Mapper
    CompraDetalleMapper compraDetalleMapper;



    @Override
    public int agregarCompra(Compra compra) throws CompraException {
        try {
            return crearCompra(compra);
        } catch (Exception e) {
            throw new CompraException("Ha ocurrido un error durante el proceso de compra: " + e.getMessage());
        }

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public int crearCompra(Compra compra) throws  CompraException {


        String dateString = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        compra.setDate(dateString);
        Float total = new Float(0.0);

        Validation validation = validarCompra(compra);
        if(!(validation.getIsError())) {



            /*for (CompraDetalle compraDetalle : compra.getCompraDetalles()) {
                compraDetalle.setCompra(compra);
                Producto producto = productoServicios.buscarProducto(compraDetalle.getProducto().getIdProducto());
                producto.setCantidad(producto.getCantidad() + compraDetalle.getCantidad());
                entityManager.merge(producto);
                total = total + ((producto.getPrecioUnitario() * compraDetalle.getCantidad()));
                entityManager.persist(compraDetalle);
            }*/

            compra.setTotal(total);
            compraMapper.agregarCompra(compra);
            for (CompraDetalle compraDetalle : compra.getCompraDetalles()) {
                compraDetalle.setId_compra(compra.getId_compra());
            }
            return compraDetalleMapper.insertCompraDetalle(compra.getCompraDetalles());

        }else{
            throw new CompraException(validation.getMessage());
        }

    }

    public Validation validarCompra(Compra compra){
        String errorMessagge="";
        Boolean isError = false;
       /* if (compra.getCompraDetalles().isEmpty()) {
            errorMessagge += "No hay ningun detalle en la compra. ";
            isError = true;
        }*/
        if(!(proveedorMapper.countProveedor(compra.getId_proveedor()) > 0)){
            errorMessagge += "No hay ningun proveedor con id: "+ compra.getId_proveedor();
            isError = true;
        }
        return new Validation(isError, errorMessagge);


        /* TODO: continuar cuando haya mapper de producto
        for (CompraDetalle compraDetalle : compra.getCompraDetalles()) {
            Producto producto = productoServicios.buscarProducto(compraDetalle.getProducto().getIdProducto());
            if (!(producto.getProveedor().getIdProveedor().equals(proveedor.getIdProveedor()))) {
                return 2;
                //return Response.status(500).entity("El producto" + producto.toString() + "no pertenece al proveedor seleccionado: " + compra.getProveedor().toString() + "\nNo se pudo realizar la compra").build() ;
            }
        }*/
    }
}