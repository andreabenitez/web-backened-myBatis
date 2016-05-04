package mapper;

import modelos.Cliente;

import java.util.List;

/**
 * Created by sonia on 16/04/16.
 */

public interface ClienteMapper {

    Cliente getCliente(Integer id);

    int countCliente(Integer id);

    List<Cliente> getClientes();

    int agregarCliente(Cliente cliente);

    int modificarCliente(Cliente cliente);

    int eliminarCliente(Integer id);
}
