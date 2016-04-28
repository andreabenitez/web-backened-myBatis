package rest;

import excepciones.NoExisteProveedorException;
import modelos.Proveedor;
import servicios.ProveedorServicioMapperImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Created by andrea on 29/02/16.
 */
@Path("/proveedores")
public class ProveedorRest {

    @Inject
    private ProveedorServicioMapperImpl proveedorServicioMapper;

    /**
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object listarProveedores() throws IOException {
        try {
            return proveedorServicioMapper.getProveedores();
        }catch(Exception e){
            return Response.status(500).entity("Error al retornar la lista de proveedores. " + e.getMessage()).build();
        }
    }

    /**
     *
     * @param proveedor
     * @return
     */

    @POST
    @Consumes("application/json")
    public void crearProveedor(Proveedor proveedor) throws IOException{
        proveedorServicioMapper.agregarProveedor(proveedor);
    }


    /**
     *
     * @param id
     * @return
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Proveedor buscarProveedor(@PathParam("id") int id) throws NoExisteProveedorException, IOException {
        return proveedorServicioMapper.getProveedor(id);
    }

    /**
     *
     * @param proveedorModificado
     * @return
     */

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void modificarProveedor(Proveedor proveedorModificado) throws IOException {
        proveedorServicioMapper.modificarProveedor(proveedorModificado);

    }


    /**
     *
     * @param id
     * @return
     */

    @DELETE
    @Path("{id}")
    public void eliminarProveedor(@PathParam("id") Integer id) throws IOException{
        proveedorServicioMapper.eliminarProveedor(id);
    }


}