package servicios;

import modelos.Producto;
import modelos.ProductoDuplicado;

import java.util.List;

/**
 * Created by sonia on 27/04/16.
 */
public interface ProductoDuplicadoServicio {
    public void agregarListaDeProductos(List<Producto> productos) throws Exception;
    public void agregarProductoDuplicado(Producto producto)throws Exception;
    public ProductoDuplicado buscarProductoDuplicadoPorProducto(Producto producto)throws Exception;
    public void upDate(ProductoDuplicado productoDuplicado);
}
