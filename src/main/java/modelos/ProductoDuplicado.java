
package modelos;

/*
  Created by sonia on 13/03/16.*/



public class ProductoDuplicado {

    private Integer id_producto_duplicado;

    private Integer cod_producto;

    private Integer cantidad;

    public ProductoDuplicado(){

    }

    public ProductoDuplicado(Integer cod_producto, Integer cantidad) {
        this.cod_producto = cod_producto;
        this.cantidad = cantidad;
    }

    public Integer getId_producto_duplicado() {
        return id_producto_duplicado;
    }

    public void setId_producto_duplicado(Integer id_producto_duplicado) {
        this.id_producto_duplicado = id_producto_duplicado;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(Integer cod_producto) {
        this.cod_producto = cod_producto;
    }
}

