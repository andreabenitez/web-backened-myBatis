/*package servicios;


import config.SqlSessionFactoryProvider;
import modelos.Proveedor;
import org.apache.ibatis.session.SqlSession;

import javax.ejb.Stateless;
import java.io.IOException;
import java.util.List;*/

/**
 * Created by andrea on 29/02/16.
 */
/*@Stateless
public class ProveedorServicios {

    public List<Proveedor> getProveedores() throws IOException{
        List<Proveedor> proveedores = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
            proveedores = sqlSession.selectList("getProveedores");
        } finally {
            sqlSession.close();}
        return proveedores;
    }


    public Proveedor agregarProveedor(Proveedor proveedor) throws IOException{
        SqlSession sqlSession = null;
        try
        {
            sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
            sqlSession.insert("agregarProveedor", proveedor);
        }finally {
            sqlSession.close();
        }
        return proveedor;
    }

    public String eliminarProveedor(int proveedorId) throws IOException {
        //Proveedor proveedor = entityManager.find(Proveedor.class, proveedorId);
        int proveedor = 0;
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
            proveedor = sqlSession.delete("eliminarProveedor", proveedorId);
        }finally
        {
            sqlSession.close();
        }
        if(proveedor != 0){
            return "Proveedor eliminado exitosamente.";
        }else {
            return "El proveedor que intenta eliminar no existe";
        }
    }

   // @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public static Proveedor buscarProveedor(int proveedorId)throws IOException
    {
        SqlSession sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
        try {
            ProveedorMapper proveedorMapper = sqlSession.getMapper(ProveedorMapper.class);
            return proveedorMapper.buscarProveedor(proveedorId);
        } finally {
            sqlSession.close();
        }
    }



    public Proveedor modificarProveedor(Proveedor proveedor) throws IOException
    {
        SqlSession sqlSession = null;
        try
        {
            sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
            sqlSession.update("modificarProveedor", proveedor);
        }finally
        {
            sqlSession.close();
        }
        return proveedor;
    }

}*/
