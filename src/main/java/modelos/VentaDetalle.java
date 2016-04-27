package modelos;

/**
 * Created by andrea on 29/02/16.
 */


public class VentaDetalle{

    private Integer id_venta_detalle;
    private Integer id_producto;
    private Integer cantidad;
    private Integer id_venta;

    public Integer getId_venta_detalle() {
        return id_venta_detalle;
    }

    public void setId_venta_detalle(Integer id_venta_detalle) {
        this.id_venta_detalle = id_venta_detalle;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getId_venta() {
        return id_venta;
    }

    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
    }
}
