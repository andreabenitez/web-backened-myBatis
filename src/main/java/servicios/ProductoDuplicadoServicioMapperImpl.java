
package servicios;

import mapper.ProductoDuplicadoMapper;
import modelos.Producto;
import modelos.ProductoDuplicado;
import org.mybatis.cdi.Mapper;

import javax.ejb.*;
import javax.inject.Inject;
import java.util.List;


/*
*
 * Created by sonia on 14/03/16.
*/



@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ProductoDuplicadoServicioMapperImpl implements ProductoDuplicadoServicio{

    @Inject
    private ProductoServicioMapperImpl productoServicioMapper;

    @EJB
    private ProductoDuplicadoServicioMapperImpl productoDuplicadoServicios;

    @Inject
    @Mapper
    ProductoDuplicadoMapper productoDuplicadoMapper;

    public void agregarListaDeProductos(List<Producto> productos)throws Exception{
        for (Producto producto : productos){
            productoServicioMapper.agregarProducto(producto);
        }
    }


    //}

/*    public List<ProductoDuplicado> getProductosDuplicados() {
        Query query = entityManager.createNamedQuery("ProductoDuplicado.findAll");
        return query.getResultList();

    }*/



   @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void agregarProductoDuplicado(Producto producto) throws Exception {

        ProductoDuplicado duplicado = productoDuplicadoServicios.buscarProductoDuplicadoPorProducto(producto);
        if (duplicado == null) {
            duplicado = new ProductoDuplicado();
            duplicado.setCodProducto(producto);
            duplicado.setCantidad(1);
            this.productoDuplicadoMapper.guardarProductoDuplicado(duplicado);
        } else {
            duplicado.setCantidad(duplicado.getCantidad() + 1);
            this.productoDuplicadoMapper.upDate(duplicado);
        }
    }



    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public ProductoDuplicado  buscarProductoDuplicadoPorProducto(Producto producto) {

        return this.productoDuplicadoMapper.buscarProductoDuplicadoPorProducto(producto);
        //if (pro.size() > 0)
          //  return pro.get(0);
        //else
          //  return null;
    }
    public void upDate(ProductoDuplicado productoDuplicado)
    {
        this.productoDuplicadoMapper.upDate(productoDuplicado);
    }

    public void guardarProductoDuplicado(ProductoDuplicado productoDuplicado)
    {
        this.productoDuplicadoMapper.guardarProductoDuplicado(productoDuplicado);
    }


}

