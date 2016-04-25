package mapper;

import modelos.Pago;
import modelos.Venta;

import java.util.List;

/**
 * Created by sonia on 23/04/16.
 */
public interface PagoMapper {
    public List<Pago> getPagos();
    public Venta buscarVentaPorId(int ventaId);
    public void modificarVenta(Venta venta);
}
