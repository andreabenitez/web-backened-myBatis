package servicios;

import modelos.CompraDetalle;

import java.util.List;

/**
 * Created by andrea on 26/04/16.
 */
public interface DetalleCompraServicio {

    int insertarCompraDetalles(List<CompraDetalle> compraDetalles);
}
