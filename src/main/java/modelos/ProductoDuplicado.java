
package modelos;

import java.io.Serializable;

/*
  Created by sonia on 13/03/16.*/



public class ProductoDuplicado implements Serializable{
    private static final long serialVersionUID = 5165621093422381650L;


    private Integer id_producto_duplicado;

    private Producto cod_Producto;

    private Integer cantidad;

    public ProductoDuplicado(Producto codProducto, Integer cantidad) {
        this.cod_Producto = codProducto;
        this.cantidad = cantidad;
    }

    public ProductoDuplicado() {
    }


    public Integer getIdProductoDuplicado() {
        return id_producto_duplicado;
    }

    public void setIdProductoDuplicado(Integer idProductoDuplicado) {
        this.id_producto_duplicado = idProductoDuplicado;
    }

    public Producto getCodProducto() {
        return cod_Producto;
    }

    public void setCodProducto(Producto codProducto) {
        this.cod_Producto = codProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}

