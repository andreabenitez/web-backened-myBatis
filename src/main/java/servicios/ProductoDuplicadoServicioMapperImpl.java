
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
    private SqlSessionFactoryProvider sqlSessionFactoryProvider;

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

        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {

            ProductoDuplicado productoDuplicado = productoDuplicadoServicioMapper.buscarProductoDuplicadoPorProducto(producto.getIdProducto());
            if (productoDuplicado == null) {
                productoDuplicado = new ProductoDuplicado();
                productoDuplicado.setCod_producto(producto.getIdProducto());
                productoDuplicado.setCantidad(1);
                sqlSession.insert("agregarProductoDuplicado", productoDuplicado);
            } else {
                productoDuplicado.setCantidad(productoDuplicado.getCantidad() + 1);
                sqlSession.update("modificarProductoDuplicado", productoDuplicado);
            }
        } finally {
            sqlSession.close();
        }
    }



    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public ProductoDuplicado  buscarProductoDuplicadoPorProducto(Integer codProducto) throws IOException {

        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            ProductoDuplicadoMapper productoDuplicadoMapper = sqlSession.getMapper(ProductoDuplicadoMapper.class);
            return productoDuplicadoMapper.buscarProductoDuplicadoPorCodProducto(codProducto);
        } finally {
            sqlSession.close();
        }


    }
    public int upDate(ProductoDuplicado productoDuplicado) throws IOException {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            return sqlSession.update("upDate", productoDuplicado);
        } finally {
            sqlSession.close();
        }

    }

    public int guardarProductoDuplicado(ProductoDuplicado productoDuplicado) throws IOException {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            return sqlSession.insert("guardarProductoDuplicado", productoDuplicado);
        } finally {
            sqlSession.close();
        }
        //this.productoDuplicadoMapper.guardarProductoDuplicado(productoDuplicado);
    }


}

