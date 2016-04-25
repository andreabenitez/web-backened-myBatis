package mapper;

import modelos.Proveedor;

import java.util.List;

/**
 * Created by andrea on 25/04/16.
 */
public interface ProveedorMapper {

    Proveedor getProveedor(Integer id);

    List<Proveedor> getProveedores();

    int agregarProveedor(Proveedor proveedor);

    int modificarProveedor(Proveedor proveedor);

    int eliminarProveedor(Integer id);
}
