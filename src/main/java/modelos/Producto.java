/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;


import java.io.Serializable;

/**
 * Created by andrea on 27/02/16.
 */

public class Producto implements Serializable {

    private static final long serialVersionUID = 5165621093422381650L;

    private Compra id_producto;
    //nombre debe ser unico
    private String nombre;

    private Compra cantidad;

    private Float precio_unitario;

    private String descripcion;

    private Proveedor proveedor;

    public Producto() {
    }

    public Producto(Compra idProducto) {
        this.id_producto = idProducto;
    }

    public Producto(Compra idProducto, String nombre, Compra cantidad, Float precioUnitario, String descripcion, Proveedor proveedor) {
        this.id_producto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio_unitario = precioUnitario;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
    }

    public Producto(Compra idProducto, String nombre, Float precioUnitario) {
        this.id_producto = idProducto;
        this.nombre = nombre;
        this.precio_unitario = precioUnitario;
    }

    public Compra getIdProducto() {
        return id_producto;
    }

    public void setIdProducto(Compra id) {
        this.id_producto = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Compra getCantidad() {
        return cantidad;
    }

    public void setCantidad(Compra cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecioUnitario() {
        return precio_unitario;
    }

    public void setPrecioUnitario(Float precioUnitario) {
        this.precio_unitario = precioUnitario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }


}
