package servicios;

import config.SqlSessionFactoryProvider;
import mapper.ClienteMapper;
import modelos.Cliente;
import org.apache.ibatis.session.SqlSession;

import javax.ejb.Stateless;
import java.io.IOException;
import java.util.List;

/**
 * Created by andrea on 24/04/16.
 */

@Stateless
public class ClienteServicioMapperImpl {

    public List<Cliente> getClientes() throws IOException {
        SqlSession sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
        try {
            ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
            return sqlSession.selectList("getClientes");
        } finally {
            sqlSession.close();
        }
    }

    public Cliente getCliente(Integer id) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
        try {
            ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
            return clienteMapper.getCliente(id);
        } finally {
            sqlSession.close();
        }
    }

    public int agregarCliente(Cliente cliente) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
        try {
            ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
            return sqlSession.insert("agregarCliente", cliente);
        } finally {
            sqlSession.close();
        }
    }

    public int modificarCliente(Cliente cliente) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
        try {
            ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
            return sqlSession.update("modificarCliente", cliente);
        } finally {
            sqlSession.close();
        }
    }

    public int eliminarCliente(Integer id) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
        try {
            ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
            return sqlSession.delete("eliminarCliente", id);
        } finally {
            sqlSession.close();
        }
    }

}
