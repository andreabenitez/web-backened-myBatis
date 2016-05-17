package servicios;

import config.SqlSessionFactoryProvider;
import excepciones.NoExisteProveedorException;
import mapper.ProductoMapper;
import mapper.ProveedorMapper;
import modelos.Producto;
import modelos.Proveedor;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.io.IOException;
import java.util.List;

/**
 * Created by sonia on 25/04/16.
 */
@Stateless
public class ProductoServicioMapperImpl  {

    @EJB
    private SqlSessionFactoryProvider sqlSessionFactoryProvider;

    @EJB
    private ProductoDuplicadoServicioMapperImpl productoDuplicadoServicioMapper;

    @EJB
    private ProductoServicioMapperImpl productoServicioMapper;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Producto buscarProducto(Integer productoId) throws IOException {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
            return productoMapper.buscarProducto(productoId);
        } finally {
            sqlSession.close();
        }
    }

    public List<Producto> getProductos() throws IOException {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            return sqlSession.selectList("getProductos");
            //return productoMapper.getProductos();
        } finally {
            sqlSession.close();
        }
    }



    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void agregarProducto(Producto producto) throws Exception {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            ProveedorMapper proveedorMapper = sqlSession.getMapper(ProveedorMapper.class);
            ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
            try {

                Proveedor proveedor = proveedorMapper.getProveedor(producto.getProveedor().getId_proveedor());
                producto.setProveedor(proveedor);
                sqlSession.insert("agregarProducto", producto);
                //productoMapper.agregarProducto(producto);

            } catch (Exception e) {
                String errorMessage = "Ha ocurrido un error durante el proceso: ";
                if (e instanceof NoExisteProveedorException) {
                    errorMessage += e.getMessage();
                } else if (e instanceof PersistenceException) {
                    Producto p = productoServicioMapper.buscarProductoPorNombre(producto.getNombre());
                    productoDuplicadoServicioMapper.agregarProductoDuplicado(p);
                    sqlSession.insert("agregarProductoDuplicado", producto);
                    //productoDuplicadoMapper.agregarProductoDuplicado(p);
                    errorMessage += e.getCause().getMessage();
                }
            }
        }finally {
            sqlSession.close();
        }
    }



    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Producto buscarProductoPorNombre(String nombre) throws IOException {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
            return productoMapper.buscarProductoPorNombre(nombre);
        } finally {
            sqlSession.close();
        }
        //return  this.productoMapper.buscarProductoPorNombre(nombre);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void modificarProducto(Producto producto) throws IOException {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            ProveedorMapper proveedorMapper = sqlSession.getMapper(ProveedorMapper.class);
            Proveedor proveedor = proveedorMapper.getProveedor(producto.getProveedor().getId_proveedor());
            producto.setProveedor(proveedor);
            sqlSession.update("modificarProducto", producto);
        } finally {
            sqlSession.close();
        }
       // this.productoMapper.modificarProducto(producto);
    }

    public Integer eliminarProducto(Integer productoId) throws IOException {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            return sqlSession.delete("eliminarProducto", productoId);
        } finally {
            sqlSession.close();
        }
       // return this.productoMapper.eliminarProducto(productoId);
    }

}
