package mapper;

import modelos.Venta;

/**
 * Created by andrea on 26/04/16.
 */
public interface VentaMapper {

    int agregarVenta(Venta venta);

    int modificarVenta(Venta venta);

    Venta getVenta(Integer id);

    int countVentaById(Integer id);
}
