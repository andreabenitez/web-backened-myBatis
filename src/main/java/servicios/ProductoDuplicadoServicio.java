package servicios;

import modelos.Producto;
import modelos.ProductoDuplicado;

import java.util.List;

/**
 * Created by sonia on 27/04/16.
 */
public interface ProductoDuplicadoServicio {

    void agregarListaDeProductos(List<Producto> productos) throws Exception;

    void agregarProductoDuplicado(Producto producto)throws Exception;

    ProductoDuplicado buscarProductoDuplicadoPorProducto(Producto producto)throws Exception;
    
    void upDate(ProductoDuplicado productoDuplicado);
}
