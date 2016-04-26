package servicios;

import excepciones.NoExisteProveedorException;
import mapper.ProductoMapper;
import mapper.ProveedorMapper;
import modelos.Producto;
import modelos.Proveedor;
import org.mybatis.cdi.Mapper;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by sonia on 25/04/16.
 */
public class ProductoServicioMapperImpl implements ProductoSerivicio {

    @Inject
    @Mapper
    ProductoMapper productoMapper;

    @Inject
    @Mapper
    ProveedorMapper proveedorMapper;

    public Producto buscarProducto(Integer productoId)
    {
        return this.productoMapper.buscarProducto(productoId);
    }

    public List<Producto> getProductos()
    {
        return this.productoMapper.getProductos();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void agregarProducto(Producto producto)
    {

       // try {
            Proveedor proveedor = proveedorMapper.getProveedor(producto.getProveedor().getIdProveedor());
            producto.setProveedor(proveedor);
            this.productoMapper.agregarProducto(producto);
  //          entityManager.persist(producto);
//            return Response.status(200).entity("La insercion fue realizada exitosamente").build();

       /* } catch (Exception e) {
            String errorMessage = "Ha ocurrido un error durante el proceso: ";
            if (e instanceof NoExisteProveedorException){
                errorMessage += e.getMessage();
            }
            else if (e.getCause() instanceof ConstraintViolationException) {
                Producto p = productoServicios.buscarProductoPorNombre(producto);
                productoDuplicadoServicios.agregarProductoDuplicado(p);
                errorMessage += e.getCause().getMessage();
            }
            return Response.status(500).entity(errorMessage).build();

        }*/




    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Producto buscarProductoPorNombre(String nombre)
    {
        return  this.productoMapper.buscarProductoPorNombre(nombre);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void modificarProducto(Producto producto) {
        Proveedor proveedor = proveedorMapper.getProveedor(producto.getProveedor().getIdProveedor());
        producto.setProveedor(proveedor);
        this.productoMapper.modificarProducto(producto);
    }

    public Producto eliminarProducto(Integer productoId){

        return this.productoMapper.eliminarProducto(productoId);
    }

}
