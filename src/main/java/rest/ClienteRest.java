package rest;

import modelos.Cliente;
import servicios.ClienteServicios;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

/**
 * Created by andrea on 27/02/16.
 */
@Path("/clientes")
public class ClienteRest {

    @Inject
    private ClienteServicios clienteServicios;

/**
     * Lista todos los clientes
     * @return List<Cliente>
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> listarClientes() throws IOException{
         return clienteServicios.getClientes();
    }


/**
     * Crea un cliente
     * @param cliente
     * @return
     */

    @POST
    @Consumes("application/json")
    public void crearCliente(Cliente cliente) throws IOException{
        clienteServicios.agregarCliente(cliente);
    }


    /**
     * Retorna un cliente de acuerdo al id recibido como parametro
     * @param id
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Cliente buscarCliente(@PathParam("id") Integer id) throws IOException{
        return clienteServicios.selectClienteById(id);
    }

    /**
     * Modifica un cliente
     * @param clienteModificado
     * @return
     */

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void modificarCliente(Cliente clienteModificado) throws IOException {
        clienteServicios.modificarCliente(clienteModificado);
    }

/**
     * Eliminar cliente
     * @param id
     * @return
     */

    @DELETE
    @Path("{id}")
    public String eliminarCliente(@PathParam("id") int id) throws IOException{
        return clienteServicios.eliminarCliente(id);
    }

}
