package modelos;

/**
 * Created by andrea on 29/02/16.
 */


/*@NamedQueries({
        @NamedQuery(name = "CompraDetalle.findAll", query = "SELECT cd FROM CompraDetalle cd"),
        @NamedQuery(name = "CompraDetalle.findById", query = "SELECT cd FROM CompraDetalle cd WHERE cd.idCompraDetalle = :id")
})*/
public class CompraDetalle {

    private Integer id_integer_detalle;
    private Integer id_producto;
    private Integer cantidad;
    private Integer id_compra;

    public java.lang.Integer getId_integer_detalle() {
        return id_integer_detalle;
    }

    public void setId_integer_detalle(java.lang.Integer id_integer_detalle) {
        this.id_integer_detalle = id_integer_detalle;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public java.lang.Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(java.lang.Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getId_compra() {
        return id_compra;
    }

    public void setId_compra(Integer id_compra) {
        this.id_compra = id_compra;
    }
}
