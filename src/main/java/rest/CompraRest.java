
package rest;


/*
 * Created by andrea on 29/02/16.
 */


import modelos.Compra;
import servicios.CompraServicioMapperImpl;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/compras")
public class CompraRest {

    @Inject
    private CompraServicioMapperImpl compraServicios;


    @RolesAllowed("compra")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
    public Response crearCompra(Compra compra) {
        try {
            compraServicios.agregarCompra(compra);
            return Response.status(200).entity("Se ha creado correctamete la compra").build();
        }catch(Exception e){
            return Response.status(500).entity("Ha ocurrido un error durante el proceso de compra: " + e.getMessage()).build();
        }
    }
}
