package mapper;

import modelos.Producto;

import java.util.List;

/**
 * Created by sonia on 25/04/16.
 */
public interface ProductoMapper {

    public List<Producto> getProductos();
    public void agregarProducto(Producto producto);
    public Producto eliminarProducto(Integer productoId);
    public Producto buscarProducto(Integer productoId);
    public Producto buscarProductoPorNombre(String nombre);
    public void modificarProducto(Producto producto);

}
