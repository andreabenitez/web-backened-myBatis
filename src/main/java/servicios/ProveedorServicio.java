package servicios;

import modelos.Proveedor;

import java.util.List;

/**
 * Created by andrea on 25/04/16.
 */
public interface ProveedorServicio {

    List<Proveedor> getProveedores();

    Proveedor getProveedor(Integer id);

    int agregarProveedor(Proveedor proveedor);

    int modificarProveedor(Proveedor proveedor);

    int eliminarProveedor(Integer id);
}
