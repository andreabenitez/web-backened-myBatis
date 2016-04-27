/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 * Created by andrea on 27/02/16.
 */

public class Proveedor  {

    private Integer id_proveedor;

    private String nombre;

    private String telefono;

    private String direccion;


    public Proveedor() {
    }

    public Proveedor(Integer id_proveedor, String nombre, String telefono, String direccion){
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Proveedor(Integer id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public Proveedor(Integer id_proveedor, String nombre) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
    }

    public Integer getIdProveedor() {
        return id_proveedor;
    }

    public void setIdProveedor(Integer id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


}
