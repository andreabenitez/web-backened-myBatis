package servicios;

import excepciones.CompraException;
import modelos.Compra;

/**
 * Created by andrea on 25/04/16.
 */
public interface CompraServicio {

    int agregarCompra(Compra compra) throws CompraException;

}
