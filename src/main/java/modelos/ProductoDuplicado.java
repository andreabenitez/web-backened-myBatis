/*

package modelos;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

*/
/**
 * Created by sonia on 13/03/16.
 *//*


public class ProductoDuplicado implements Serializable{
    private static final long serialVersionUID = 5165621093422381650L;


    private Integer idProductoDuplicado;

    @NotNull
    @OneToOne
    @JoinColumn(name = "cod_producto", referencedColumnName = "id_producto", unique = true)
    private Producto codProducto;

    @NotNull
    @Column(name = "cantidad")
    private Integer cantidad;

    public ProductoDuplicado(Producto codProducto, Integer cantidad) {
        this.codProducto = codProducto;
        this.cantidad = cantidad;
    }

    public ProductoDuplicado() {
    }


    public Integer getIdProductoDuplicado() {
        return idProductoDuplicado;
    }

    public void setIdProductoDuplicado(Integer idProductoDuplicado) {
        this.idProductoDuplicado = idProductoDuplicado;
    }

    public Producto getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Producto codProducto) {
        this.codProducto = codProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}

*/
