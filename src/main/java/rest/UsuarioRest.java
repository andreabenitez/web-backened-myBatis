package rest;

import excepciones.NotAuthorizedException;
import servicios.UsuarioServicioMapperImpl;
import utils.UsuarioUtil;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by andrea on 19/05/16.
 */

@Path("/usuarios")
public class UsuarioRest {

    @Inject
    private UsuarioServicioMapperImpl usuarioServicioMapper;

    @PermitAll
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response login(UsuarioUtil usuarioUtil) {
        try {
            String authToken = usuarioServicioMapper.authorization(usuarioUtil);
            return Response.status(200).entity(authToken).build();
        }catch(Exception e){
            if (e instanceof NotAuthorizedException){
                return Response.status(403).entity(e.getMessage()).build();
            }else {
                return Response.status(500).entity("Ha ocurrido un error durante el proceso de compra: " + e.getMessage()).build();
            }
        }
    }

}
