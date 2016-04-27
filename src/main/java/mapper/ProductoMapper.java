package mapper;

import modelos.Producto;

import java.util.List;

/*
 * Created by sonia on 25/04/16.
 */

public interface ProductoMapper {

    List<Producto> getProductos();

    void agregarProducto(Producto producto);

    Producto eliminarProducto(Integer productoId);

    Producto buscarProducto(Integer productoId);

    Producto buscarProductoPorNombre(String nombre);

    void modificarProducto(Producto producto);
}
