package rest;

import modelos.Cliente;
import servicios.ClienteServicioMapperImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;


/**
 * Created by andrea on 27/02/16.
 */
@Path("/clientes")
public class ClienteRest {

    @Inject
    private ClienteServicioMapperImpl clienteServicioMapper;

    /**
     * Retorna un cliente de acuerdo al id recibido como parametro
     * @param id
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Cliente buscarCliente(@PathParam("id") Integer id) throws Exception{
        return clienteServicioMapper.getCliente(id);
    }

    /**
     * Lista todos los clientes
     * @return List<Cliente>
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> listarClientes() throws IOException {
         return clienteServicioMapper.getClientes();
    }


    /**
     * Crea un cliente
     * @param cliente
     * @return
     */

    @POST
    @Consumes("application/json")
    public void crearCliente(Cliente cliente) throws IOException{
        clienteServicioMapper.agregarCliente(cliente);
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
        clienteServicioMapper.modificarCliente(clienteModificado);
    }

    /**
     * Eliminar cliente
     * @param id
     * @return
     */

    @DELETE
    @Path("{id}")
    public void eliminarCliente(@PathParam("id") int id) throws IOException{
        clienteServicioMapper.eliminarCliente(id);
    }

}
