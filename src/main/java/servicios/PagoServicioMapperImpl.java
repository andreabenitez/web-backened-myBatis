package servicios;

import excepciones.PagoException;
import mapper.PagoMapper;
import modelos.Pago;
import modelos.Venta;
import org.mybatis.cdi.Mapper;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by andrea on 29/04/16.
 */
public class PagoServicioMapperImpl implements PagoServicio {

    @Inject
    @Mapper
    private PagoMapper pagoMapper;

    @Inject
    private VentaServicioMapperImpl ventaServicioMapper;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String agregarPago(Pago pago) throws PagoException{
        try {
            String mensajeRespuesta;
            Venta venta = ventaServicioMapper.buscarVentaPorId(pago.getId_venta());
            if (venta.getSaldo_deuda() > 0) {


                String dateString = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                pago.setFecha(dateString);
                if (venta.getSaldo_deuda() > pago.getMonto_pagado()) {
                    venta.setSaldo_deuda(venta.getSaldo_deuda() - pago.getMonto_pagado());
                    mensajeRespuesta = "El cliente aun debe abonar " + (venta.getTotal() - pago.getMonto_pagado()) + "para pagar completar el pago de la venta: \n" + venta.toString();
                } else {
                    if (pago.getMonto_pagado() > venta.getSaldo_deuda()) {
                        pago.setMonto_pagado(venta.getSaldo_deuda());
                    }
                    mensajeRespuesta = "La deuda por la Venta:" + venta.toString() + "ha sido totalmente pagada";
                    venta.setSaldo_deuda((float) 0);

                }
                ventaServicioMapper.modificarVenta(venta);

                pagoMapper.agregarPago(pago);
                return mensajeRespuesta;
                //return Response.status(200).entity(pago.toString() + mensajeRespuesta).build();
            } else {
                return "El pago de esta venta ya se pagado anteriormente";

                //return Response.status(200).entity(pago.toString() + "El pago de esta venta ya se pagado anteriormente" + pago.toString()).build();
            }
        }catch(Exception e){
            throw new PagoException("Ha ocurrido un error en el pago: " + e.getMessage());
            //return Response.status(500).entity("Ha ocurrido un error en el pago: " + e.getMessage()).build();
        }
    }
}
