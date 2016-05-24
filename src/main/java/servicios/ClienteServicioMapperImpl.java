package servicios;


import config.SqlSessionFactoryProvider;
import mapper.ClienteMapper;
import modelos.Cliente;
import org.apache.ibatis.session.SqlSession;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.IOException;
import java.util.List;

/**
 * Created by andrea on 24/04/16.
 */

@Stateless
public class ClienteServicioMapperImpl {

    @EJB
    private SqlSessionFactoryProvider sqlSessionFactoryProvider;

    public List<Cliente> getClientes() throws IOException {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            return sqlSession.selectList("getClientes");
        } finally {
            sqlSession.close();
        }
    }

    public Cliente getCliente(Integer id) throws IOException {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
            return clienteMapper.getCliente(id);
        } finally {
            sqlSession.close();
        }
    }

    public int agregarCliente(Cliente cliente) throws IOException {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            return sqlSession.insert("agregarCliente", cliente);
        } finally {
            sqlSession.close();
        }
    }

    public int modificarCliente(Cliente cliente) throws IOException {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            return sqlSession.update("modificarCliente", cliente);
        } finally {
            sqlSession.close();
        }
    }

    public int eliminarCliente(Integer id) throws IOException {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            return sqlSession.delete("eliminarCliente", id);
        } finally {
            sqlSession.close();
        }
    }

}
