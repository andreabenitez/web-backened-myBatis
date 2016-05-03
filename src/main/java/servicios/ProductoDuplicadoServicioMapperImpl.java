
package servicios;

import config.SqlSessionFactoryProvider;
import mapper.ProductoDuplicadoMapper;
import modelos.Producto;
import modelos.ProductoDuplicado;
import org.apache.ibatis.session.SqlSession;

import javax.ejb.*;
import java.io.IOException;
import java.util.List;

/*
 * Created by sonia on 14/03/16.
 */





@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ProductoDuplicadoServicioMapperImpl
{

    @EJB
    private ProductoServicioMapperImpl productoServicioMapper;

    @EJB
    private ProductoDuplicadoServicioMapperImpl productoDuplicadoServicioMapper;


    public void agregarListaDeProductos(List<Producto> productos)throws Exception{
        for (Producto producto : productos){
            productoServicioMapper.agregarProducto(producto);
        }
    }


    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void agregarProductoDuplicado(Producto producto) throws Exception {

        SqlSession sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
        try {

            ProductoDuplicado duplicado = productoDuplicadoServicioMapper.buscarProductoDuplicadoPorProducto(producto);
            if (duplicado == null) {
                duplicado = new ProductoDuplicado();
                duplicado.setCod_producto(producto);
                duplicado.setCantidad(1);
                sqlSession.insert("guardarProductoDuplicado", duplicado);
                //this.productoDuplicadoMapper.guardarProductoDuplicado(duplicado);
            } else {
                duplicado.setCantidad(duplicado.getCantidad() + 1);
                sqlSession.update("upDate", duplicado);
                //this.productoDuplicadoMapper.upDate(duplicado);
            }
        } finally {
            sqlSession.close();
        }
    }



    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public ProductoDuplicado  buscarProductoDuplicadoPorProducto(Producto producto) throws IOException {

        SqlSession sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
        try {
            ProductoDuplicadoMapper productoDuplicadoMapper = sqlSession.getMapper(ProductoDuplicadoMapper.class);
            return productoDuplicadoMapper.buscarProductoDuplicadoPorProducto(producto);
        } finally {
            sqlSession.close();
        }
        //return this.productoDuplicadoMapper.buscarProductoDuplicadoPorProducto(producto);

    }
    public int upDate(ProductoDuplicado productoDuplicado) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
        try {
            return sqlSession.update("upDate", productoDuplicado);
        } finally {
            sqlSession.close();
        }
        //this.productoDuplicadoMapper.upDate(productoDuplicado);
    }

    public int guardarProductoDuplicado(ProductoDuplicado productoDuplicado) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
        try {
            return sqlSession.insert("guardarProductoDuplicado", productoDuplicado);
        } finally {
            sqlSession.close();
        }
        //this.productoDuplicadoMapper.guardarProductoDuplicado(productoDuplicado);
    }


}

