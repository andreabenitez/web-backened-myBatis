
package modelos;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by andrea on 29/02/16.
 */



public class Venta implements Serializable {

    private static final long serialVersionUID = 5956326146728513395L;


    private Integer id_venta;

    private String date;


    private Float total;

    private Cliente id_cliente;

     List<VentaDetalle> ventaDetalles;

   private Float saldo_deuda;

    public Integer getIdVenta() {
        return id_venta;
    }

    public void setIdVenta(Integer idVenta) {
        this.id_venta = idVenta;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return id_cliente;
    }

    public void setCliente(Cliente cliente) {
        this.id_cliente = cliente;
    }

    public List<VentaDetalle> getVentaDetalles() {
        return ventaDetalles;
    }

    public void setVentaDetalles(List<VentaDetalle> ventaDetalles) {
        this.ventaDetalles = ventaDetalles;
    }

    public Float getSaldoDeuda() {
        return saldo_deuda;
    }

    public void setSaldoDeuda(Float saldoDeuda) {
        this.saldo_deuda = saldoDeuda;
    }


}

