package mapper;

import modelos.Producto;
import modelos.ProductoDuplicado;

import java.util.List;

/**
 * Created by sonia on 27/04/16.
 */
public interface ProductoDuplicadoMapper {
    public void agregarListaDeProductos(List<Producto> productos);
    public void agregarProductoDuplicado(Producto producto);
    public ProductoDuplicado buscarProductoDuplicadoPorProducto(Producto producto);
    public void upDate(ProductoDuplicado productoDuplicado);
    public void guardarProductoDuplicado(ProductoDuplicado productoDuplicado);

}
