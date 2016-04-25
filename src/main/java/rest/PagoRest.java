
package rest;

import modelos.Pago;
import servicios.PagoServicios;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("/pagos")
public class PagoRest {

    @Inject
    private PagoServicios pagoServicios;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pago> listarPagos() throws IOException{
        return pagoServicios.getPagos();
    }

    @POST
    @Consumes("application/json")
    public String crearPago(Pago pago) throws IOException
    {
        return pagoServicios.agregarPago(pago);
    }

}

