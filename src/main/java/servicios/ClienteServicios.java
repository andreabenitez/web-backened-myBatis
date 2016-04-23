package servicios;

import config.SqlSessionFactoryProvider;
import mapper.ClienteMapper;
import modelos.Cliente;
import org.apache.ibatis.session.SqlSession;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by andrea on 29/02/16.
 */


@Stateless
public class ClienteServicios {

    public static Cliente selectClienteById(int id)throws IOException
    {
        SqlSession sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
        try {
            ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
            return clienteMapper.selectClienteById(id);
        } finally {
            sqlSession.close();
        }
    }

    public  List<Cliente> getClientes() throws IOException{

        List<Cliente> listaC = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
            listaC = sqlSession.selectList("getClientes");
        } finally {
            sqlSession.close();
        }
        return listaC;
    }

    public  void agregarCliente(Cliente cliente) throws IOException{
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
            sqlSession.insert("agregarCliente", cliente);
        } finally {
            sqlSession.close();
        }
    }

    public String eliminarCliente(int id_cliente) throws IOException{
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
            sqlSession.delete("eliminarCliente", id_cliente);
            //no hace falta hacer commit si se tiene JDBC o JTA
        } finally {
            sqlSession.close();
        }
        return "Cliente eliminado exitosamente";
    }

    public void modificarCliente(Cliente cliente) throws IOException{
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
            sqlSession.update("modificarCliente", cliente );
            //no hace falta hacer commit si se tiene JDBC o JTA
        } finally {
            sqlSession.close();
        }
    }
}
