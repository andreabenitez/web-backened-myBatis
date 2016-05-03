
package modelos;

import java.io.Serializable;

/*
  Created by sonia on 13/03/16.*/



public class ProductoDuplicado implements Serializable{
    private static final long serialVersionUID = 5165621093422381650L;


    private Integer id_producto_duplicado;

    private Producto cod_producto;

    private Integer cantidad;

    public ProductoDuplicado(Producto codProducto, Integer cantidad) {
        this.cod_producto = codProducto;
        this.cantidad = cantidad;
    }

    public ProductoDuplicado() {
    }

    public Integer getId_producto_duplicado() {
        return id_producto_duplicado;
    }

    public void setId_producto_duplicado(Integer id_producto_duplicado) {
        this.id_producto_duplicado = id_producto_duplicado;
    }

    public Producto getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(Producto cod_producto) {
        this.cod_producto = cod_producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}

