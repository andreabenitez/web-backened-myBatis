

package modelos;


/*
 * Created by andrea on 27/02/16.
 */


public class Producto  {


    private Integer id_producto;
    //nombre debe ser unico
    private String nombre;

    private Integer cantidad;

    private Float precio_unitario;

    private String descripcion;

    private Proveedor proveedor;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.id_producto = idProducto;
    }

    public Producto(Integer idProducto, String nombre, Integer cantidad, Float precioUnitario, String descripcion, Proveedor proveedor) {
        this.id_producto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio_unitario = precioUnitario;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
    }

    public Producto(Integer idProducto, String nombre, Float precioUnitario) {
        this.id_producto = idProducto;
        this.nombre = nombre;
        this.precio_unitario = precioUnitario;
    }

    public Integer getIdProducto() {
        return id_producto;
    }

    public void setIdProducto(Integer id) {
        this.id_producto = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
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
