package rest;

import excepciones.PagoException;
import modelos.Pago;
import servicios.PagoServicioMapperImpl;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.IOException;


@Path("/pagos")
public class PagoRest {

    @Inject
    private PagoServicioMapperImpl pagoServicioMapper;


    @POST
    @Consumes("application/json")
    public Response crearPago(Pago pago) throws IOException {
        try {
            String message = pagoServicioMapper.agregarPago(pago);
            return Response.status(200).entity(message).build();

        }catch (PagoException e){
            return Response.status(500).entity("Ha ocurrido un error durante el proceso de pago: " + e.getMessage()).build();

        }
    }

}
