package servicios;

import excepciones.VentaException;
import mapper.VentaDetalleMapper;
import mapper.VentaMapper;
import modelos.Producto;
import modelos.Venta;
import modelos.VentaDetalle;
import org.mybatis.cdi.Mapper;
import utils.Validation;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Date;


/*
 * Created by andrea on 29/02/16.
 */


@TransactionManagement(TransactionManagementType.CONTAINER)
public class VentaServicioMapperImpl implements VentaServicio {

    /*@Resource
    private SessionContext sessionContext;*/

    @Inject
    private ProductoServicioMapperImpl productoServicioMapper;

    @Inject
    private ClienteServicioMapperImpl clienteServicioMapper;

    @Inject
    @Mapper
    VentaMapper ventaMapper;

    @Inject
    @Mapper
    VentaDetalleMapper ventaDetalleMapper;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public int agregarVenta(Venta venta) {
        try {

            String dateString = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            venta.setDate(dateString);
            Float total = new Float(0.0);
            venta.setTotal(total);
            venta.setSaldo_deuda(total);
            Validation validation = validarVenta(venta);
            ventaMapper.agregarVenta(venta);
            if(!(validation.getIsError())) {

                for (VentaDetalle ventaDetalle : venta.getVentaDetalles()) {
                    ventaDetalle.setId_venta(venta.getId_venta());
                    Producto producto = productoServicioMapper.buscarProducto(ventaDetalle.getId_producto());
                    producto.setCantidad(producto.getCantidad() - ventaDetalle.getCantidad());
                    productoServicioMapper.modificarProducto(producto);
                    total = total + (producto.getPrecioUnitario() * ventaDetalle.getCantidad()) * new Float(1.1);
                }
                ventaDetalleMapper.insertVentaDetalles(venta);

                venta.setTotal(total);
                venta.setSaldo_deuda(total);
                return ventaMapper.modificarVenta(venta);

            }else{
                throw new VentaException(validation.getMessage());
            }

        }catch (VentaException e){
            throw e;
        }
        catch (Exception e) {
            /*if (e.getCause() instanceof ConstraintViolationException){
                sessionContext.setRollbackOnly();
            }*/
            throw new VentaException("La venta no se pudo realizar " + e.getMessage());
        }
    }

    public int modificarVenta(Venta venta) {
        return ventaMapper.modificarVenta(venta);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Venta buscarVentaPorId(Integer id) {
        return ventaMapper.getVenta(id);
    }

    private Validation validarVenta(Venta venta){
        Validation validation = new Validation(false, "");

        if(!(ventaMapper.countVentaById(venta.getId_cliente()) > 0)){
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

    }
}
