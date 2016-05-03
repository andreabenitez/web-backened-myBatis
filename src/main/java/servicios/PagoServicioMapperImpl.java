package servicios;

/*
 * Created by andrea on 29/04/16.
 */

import config.SqlSessionFactoryProvider;
import excepciones.PagoException;
import modelos.Pago;
import modelos.Venta;
import org.apache.ibatis.session.SqlSession;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Stateless
public class PagoServicioMapperImpl {


    @Inject
    private VentaServicioMapperImpl ventaServicioMapper;


    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String agregarPago(Pago pago) throws PagoException, IOException {
        SqlSession sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
        try {
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
                    sqlSession.insert("agregarPago", pago);
                    //pagoMapper.agregarPago(pago);
                    return mensajeRespuesta;
                    //return Response.status(200).entity(pago.toString() + mensajeRespuesta).build();
                } else {
                    return "El pago de esta venta ya se pagado anteriormente";

                    //return Response.status(200).entity(pago.toString() + "El pago de esta venta ya se pagado anteriormente" + pago.toString()).build();
                }
            } catch (Exception e) {
                throw new PagoException("Ha ocurrido un error en el pago: " + e.getMessage());
                //return Response.status(500).entity("Ha ocurrido un error en el pago: " + e.getMessage()).build();
            }
        } finally {
            sqlSession.close();
        }
    }
}
