
package servicios;

import config.SqlSessionFactoryProvider;
import mapper.PagoMapper;
import modelos.Pago;
import modelos.Venta;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import javax.ejb.*;
import javax.inject.Inject;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PagoServicios {

 /*   @Inject
    private VentaServicios ventaServicios;
*/


    public List<Pago> getPagos() throws IOException{
        List<Pago> pagos = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
            pagos = sqlSession.selectList("getPagos");
           // Venta venta = buscarVentaPorId(1);
           // System.out.println("el valor de venta..."+venta.getIdVenta()+ "total"+venta.getTotal());
        } finally {
            sqlSession.close();
        }
        return pagos;
    }

    public Venta buscarVentaPorId(int ventaId) throws IOException
    {
        SqlSession sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
        try {
            PagoMapper pagoMapper = sqlSession.getMapper(PagoMapper.class);
            return pagoMapper.buscarVentaPorId(ventaId);
        } finally {
            sqlSession.close();
        }
    }
/*
    public void modificarVenta(Venta venta) throws IOException {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
            sqlSession.update("modificarVenta", venta);
            //no hace falta hacer commit si se tiene JDBC o JTA
        } finally {
            sqlSession.close();
        }
    }
*/


    public String agregarPago(Pago pago) throws IOException {
        Venta venta = null;
        SqlSession sqlSession = null;
            venta = buscarVentaPorId(pago.getVenta().getIdVenta());
            if (venta.getSaldoDeuda() > 0) {
                String mensajeRespuesta;

                String dateString = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                pago.setFecha(dateString);
                if (venta.getSaldoDeuda() > pago.getMontoPagado()) {
                    venta.setSaldoDeuda(venta.getSaldoDeuda() - pago.getMontoPagado());
                    mensajeRespuesta = "El cliente aun debe abonar " + (venta.getTotal() - pago.getMontoPagado()) + "para pagar completar el pago de la venta: \n" + venta.toString();
                    //entityManager.merge(venta);
     //               modificarVenta(venta);
                    try {
                        sqlSession = SqlSessionFactoryProvider.produceFactory().openSession();
                        int p = sqlSession.insert("agregarPago", pago);
                    }finally {
                        sqlSession.close();
                    }
                } else {
                    if (pago.getMontoPagado() > venta.getSaldoDeuda()) {
                        pago.setMontoPagado(venta.getSaldoDeuda());
                    }
                    mensajeRespuesta = "La deuda por la Venta:" + venta.toString() + "ha sido totalmente pagada";
                    venta.setSaldoDeuda((float) 0);
       //             modificarVenta(venta);
                }




               // entityManager.persist(pago);

                return pago.toString() + mensajeRespuesta;
            }
            return pago.toString() + "El pago de esta venta ya se pagado anteriormente" + pago.toString();


    }
}
