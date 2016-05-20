package servicios;

import config.SqlSessionFactoryProvider;
import mapper.ProveedorMapper;
import modelos.Proveedor;
import org.apache.ibatis.session.SqlSession;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.List;

/**
 * Created by andrea on 25/04/16.
 */
@Stateless
public class ProveedorServicioMapperImpl {

    @EJB
    private SqlSessionFactoryProvider sqlSessionFactoryProvider;


    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Proveedor> getProveedores() {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            return sqlSession.selectList("getProveedores");
        } finally {
            sqlSession.close();
        }
    }

    public Proveedor getProveedor(Integer id) {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            ProveedorMapper proveedorMapper  = sqlSession.getMapper(ProveedorMapper.class);
            return proveedorMapper.getProveedor(id);
        }finally {
            sqlSession.close();
        }
    }


    public int agregarProveedor(Proveedor proveedor)  {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            return sqlSession.insert("agregarProveedor", proveedor);
        } finally {
            sqlSession.close();
        }
        //return proveedorMapper.agregarProveedor(proveedor);
    }


    public int modificarProveedor(Proveedor proveedor)  {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            return sqlSession.update("modificarProveedor", proveedor);
        } finally {
            sqlSession.close();
        }
        //return proveedorMapper.modificarProveedor(proveedor);
    }


    public int eliminarProveedor(Integer id)  {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            return sqlSession.delete("eliminarProveedor", id);
        } finally {
            sqlSession.close();
        }
        //return proveedorMapper.eliminarProveedor(id);
    }

    public Integer countProveedor(Integer id)  {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            ProveedorMapper proveedorMapper  = sqlSession.getMapper(ProveedorMapper.class);
            return proveedorMapper.countProveedor(id);
        }finally {
            sqlSession.close();
        }
    }



}
