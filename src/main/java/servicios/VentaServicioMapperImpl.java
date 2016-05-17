package servicios;

import config.SqlSessionFactoryProvider;
import excepciones.VentaException;
import mapper.ClienteMapper;
import mapper.VentaMapper;
import modelos.Producto;
import modelos.Venta;
import modelos.VentaDetalle;
import org.apache.ibatis.session.SqlSession;
import utils.Validation;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.inject.Inject;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Created by andrea on 29/02/16.
 */

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class VentaServicioMapperImpl  {

    @Resource
    private SessionContext context;


    @Inject
    private ProductoServicioMapperImpl productoServicioMapper;

    @EJB
    private SqlSessionFactoryProvider sqlSessionFactoryProvider;



    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public int agregarVenta(Venta venta) throws IOException, VentaException {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            try {

                String dateString = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                venta.setDate(dateString);
                Float total = new Float(0.0);
                venta.setTotal(total);
                venta.setSaldo_deuda(total);
                Validation validation = validarVenta(venta);
                sqlSession.insert("agregarVenta", venta);
                //ventaMapper.agregarVenta(venta);
                if (!(validation.getIsError())) {

                    for (VentaDetalle ventaDetalle : venta.getVentaDetalles()) {
                        ventaDetalle.setId_venta(venta.getId_venta());
                        Producto producto = productoServicioMapper.buscarProducto(ventaDetalle.getId_producto());
                        producto.setCantidad(producto.getCantidad() - ventaDetalle.getCantidad());
                        productoServicioMapper.modificarProducto(producto);
                        total = total + (producto.getPrecioUnitario() * ventaDetalle.getCantidad()) * new Float(1.1);
                    }
                    sqlSession.insert("insertVentaDetalles", venta);
                    //ventaDetalleMapper.insertVentaDetalles(venta);

                    venta.setTotal(total);
                    venta.setSaldo_deuda(total);
                    return sqlSession.update("modificarVenta", venta);
                    //return ventaMapper.modificarVenta(venta);

                } else {
                    throw new VentaException(validation.getMessage());
                }

            } catch (VentaException e) {
                throw e;
            } catch (Exception e) {
                /*if (e instanceof PersistenceException) {
                    context.setRollbackOnly();
                }*/

                throw new VentaException("La venta no se pudo realizar " + e.getMessage());
            }
        } finally {
            sqlSession.close();
        }
    }

    public int modificarVenta(Venta venta) throws IOException {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            return sqlSession.update("modificarVenta", venta);
            //return ventaMapper.modificarVenta(venta);
        } finally {
            sqlSession.close();
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Venta buscarVentaPorId(Integer id) throws IOException {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            VentaMapper ventaMapper = sqlSession.getMapper(VentaMapper.class);
            return ventaMapper.getVenta(id);
        } finally {
            sqlSession.close();
        }
        //return ventaMapper.getVenta(id);
    }

    private Validation validarVenta(Venta venta) throws IOException {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
            Validation validation = new Validation(false, "");

            if (!(clienteMapper.countCliente(venta.getId_cliente()) > 0)) {
                validation.setIsError(true);
                validation.setMessage(validation.getMessage() + "El id del cliente no es valido. ");
            }
            for (VentaDetalle ventaDetalle : venta.getVentaDetalles()) {
                Producto producto = productoServicioMapper.buscarProducto(ventaDetalle.getId_producto());
                if (!(producto.getCantidad() >= ventaDetalle.getCantidad())) {
                    validation.setIsError(true);
                    validation.setMessage(validation.getMessage() + "El producto: " + producto.getNombre() + "no cuenta con suficiente stock. ");
                }
            }
            if (!(venta.getVentaDetalles().size() > 0)) {
                validation.setIsError(true);
                validation.setMessage(validation.getMessage() + "La venta no posee detalles. Intente de vuelta. ");
            }
            return validation;
        } finally {
            sqlSession.close();
        }

    }
}
