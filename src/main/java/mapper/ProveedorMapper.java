package mapper;

import modelos.Proveedor;

import java.util.List;

/**
 * Created by sonia on 18/04/16.
 */
public interface ProveedorMapper {
    public List<Proveedor> getProveedores();
    public Proveedor agregarProveedor(Proveedor proveedor);
    public Proveedor buscarProveedor(int proveedorId);
    public Proveedor modificarProveedor(Proveedor proveedor);
    public String eliminarProveedor(int proveedorId);
}
