package mapper;

import modelos.Cliente;

import java.util.List;

/**
 * Created by sonia on 16/04/16.
 */
public interface ClienteMapper {
    public Cliente selectClienteById(int id);
    public List<Cliente> getCliente();
    public void modificarCliente(Cliente cliente);
    public void agregarCliente(Cliente cliente);
}
