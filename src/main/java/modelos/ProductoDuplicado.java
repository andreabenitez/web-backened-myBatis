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

@Entity
@Table(name = "productoduplicado")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ProductoDuplicado.findAll", query = "SELECT pd FROM ProductoDuplicado pd"),
        @NamedQuery(name = "ProductoDuplicado.findByCodProducto", query = "SELECT pd FROM ProductoDuplicado pd WHERE pd.codProducto = :codProducto"),
        @NamedQuery(name = "ProductoDuplicado.findById", query = "SELECT pd FROM ProductoDuplicado pd WHERE pd.idProductoDuplicado = :id")
})
public class ProductoDuplicado implements Serializable{
    private static final long serialVersionUID = 5165621093422381650L;

    @Id
    @Column(name = "id_producto_duplicado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Compra idProductoDuplicado;

    @NotNull
    @OneToOne
    @JoinColumn(name = "cod_producto", referencedColumnName = "id_producto", unique = true)
    private Producto codProducto;

    @NotNull
    @Column(name = "cantidad")
    private Compra cantidad;

    public ProductoDuplicado(Producto codProducto, Compra cantidad) {
        this.codProducto = codProducto;
        this.cantidad = cantidad;
    }

    public ProductoDuplicado() {
    }


    public Compra getIdProductoDuplicado() {
        return idProductoDuplicado;
    }

    public void setIdProductoDuplicado(Compra idProductoDuplicado) {
        this.idProductoDuplicado = idProductoDuplicado;
    }

    public Producto getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Producto codProducto) {
        this.codProducto = codProducto;
    }

    public Compra getCantidad() {
        return cantidad;
    }

    public void setCantidad(Compra cantidad) {
        this.cantidad = cantidad;
    }
}
*/
