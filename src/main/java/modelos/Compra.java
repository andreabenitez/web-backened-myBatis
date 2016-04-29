package modelos;

import java.util.List;

/**
 * Created by andrea on 29/02/16.
 */

/*@NamedQueries({
        @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
        @NamedQuery(name = "Compra.findById", query = "SELECT c FROM Compra c WHERE c.idCompra = :id")
})*/
public class Compra {

    private Integer id_compra;

    private String date;

    private Float total;

    private Integer id_proveedor;

    private List<CompraDetalle> compraDetalles;

    public Integer getId_compra() {
        return id_compra;
    }

    public void setId_compra(Integer id_compra) {
        this.id_compra = id_compra;
    }

    public void setIdCompra(Integer id) {
        this.id_compra = id;
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

    public Integer getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Integer id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public List<CompraDetalle> getCompraDetalles() {
        return compraDetalles;
    }

    public void setCompraDetalles(List<CompraDetalle> compraDetalles) {
        this.compraDetalles = compraDetalles;
    }
}
