package servicios;

import mapper.ProveedorMapper;
import modelos.Proveedor;
import org.mybatis.cdi.Mapper;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by andrea on 25/04/16.
 */
public class ProveedorServicioMapperImpl implements ProveedorServicio {

    @Inject
    @Mapper
    ProveedorMapper proveedorMapper;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Proveedor> getProveedores(){
        return this.proveedorMapper.getProveedores();
    }

    @Override
    public Proveedor getProveedor(Integer id){
        return this.proveedorMapper.getProveedor(id);
    }

    @Override
    public int agregarProveedor(Proveedor proveedor){
        return this.proveedorMapper.agregarProveedor(proveedor);
    }

    @Override
    public int modificarProveedor(Proveedor proveedor) {
        return this.proveedorMapper.modificarProveedor(proveedor);
    }

    @Override
    public int eliminarProveedor(Integer id) {
        return this.proveedorMapper.eliminarProveedor(id);
    }
}
