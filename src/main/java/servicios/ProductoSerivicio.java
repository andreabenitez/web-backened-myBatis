package servicios;

import modelos.Producto;

import java.util.List;

/*
 * Created by sonia on 25/04/16.
 */

public interface ProductoSerivicio {


    public List<Producto> getProductos();
    public void agregarProducto(Producto producto);
    public Producto buscarProductoPorNombre(String nombre);
    public Producto eliminarProducto(Integer productoId);
    public Producto buscarProducto(Integer productoId);
    public void modificarProducto(Producto producto);

}
