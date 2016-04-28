package servicios;

import modelos.Cliente;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by andrea on 24/04/16.
 */
@Stateless
public interface ClienteServicio {

    List<Cliente> getClientes();

    Cliente getCliente(Integer id);

    int agregarCliente(Cliente cliente);

    int modificarCliente(Cliente cliente);

    int eliminarCliente(Integer id);
}
