package mapper;

import modelos.ProductoDuplicado;

/**
 * Created by sonia on 27/04/16.
 */
public interface ProductoDuplicadoMapper {

    void agregarProductoDuplicado(ProductoDuplicado productoDuplicado);
    void modificarProductoDuplicado(ProductoDuplicado productoDuplicado);
    ProductoDuplicado buscarProductoDuplicadoPorCodProducto(Integer codProducto);
}
