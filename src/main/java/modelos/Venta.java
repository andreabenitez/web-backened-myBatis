package modelos;

import java.util.List;

/**
 * Created by andrea on 29/02/16.
 */


public class Venta {

    private Integer id_venta;
    private String date;
    private Float total;
    private Integer id_cliente;
    private Float saldo_deuda;
    private List<VentaDetalle> ventaDetalles;


    public Integer getId_venta() {
        return id_venta;
    }

    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
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

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Float getSaldo_deuda() {
        return saldo_deuda;
    }

    public void setSaldo_deuda(Float saldo_deuda) {
        this.saldo_deuda = saldo_deuda;
    }

    public List<VentaDetalle> getVentaDetalles() {
        return ventaDetalles;
    }

    public void setVentaDetalles(List<VentaDetalle> ventaDetalles) {
        this.ventaDetalles = ventaDetalles;
    }

}
