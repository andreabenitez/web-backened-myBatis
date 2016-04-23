package mapper;

import modelos.Cliente;
import modelos.Proveedor;

import java.util.List;

/**
 * Created by sonia on 16/04/16.
 */
public interface ClienteMapper {
    public Cliente selectClienteById(int id);
    public List<Cliente> getClientes();
    public void modificarCliente(Cliente cliente);
    public void agregarCliente(Cliente cliente);
    public String eliminarCliente(int id_cliente);
}
