package rest;

import excepciones.VentaException;
import modelos.Venta;
import servicios.VentaServicioMapperImpl;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

 /*
 * Created by andrea on 29/02/16.
 */


@Path("/ventas")
public class VentaRest {

    @Inject
    private VentaServicioMapperImpl ventaServicioMapper;



    @RolesAllowed("venta")
    @POST
    @Consumes("application/json")
    public Object crearVenta(Venta venta) throws Exception {
        try {
            return ventaServicioMapper.agregarVenta(venta);
        }catch (VentaException e){
            return Response.status(500).entity("Error al agregar la venta. " + e.getMessage()).build();
        }
    }
}
