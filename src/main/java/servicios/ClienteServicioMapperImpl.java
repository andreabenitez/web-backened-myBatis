package servicios;

import mapper.ClienteMapper;
import modelos.Cliente;
import org.mybatis.cdi.Mapper;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by andrea on 24/04/16.
 */
public class ClienteServicioMapperImpl implements ClienteServicio {

    @Inject
    @Mapper
    ClienteMapper clienteMapper;

    @Override
    public List<Cliente> getClientes(){
        return this.clienteMapper.getClientes();
    }

    @Override
    public Cliente getCliente(Integer id){
        return this.clienteMapper.getCliente(id);
    }

    @Override
    public int agregarCliente(Cliente cliente){
        return this.clienteMapper.agregarCliente(cliente);
    }

    @Override
    public int modificarCliente(Cliente cliente) {
        return this.clienteMapper.modificarCliente(cliente);
    }

    @Override
    public int eliminarCliente(Integer id) {
        return this.clienteMapper.eliminarCliente(id);
    }

}
