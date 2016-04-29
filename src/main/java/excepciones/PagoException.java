package excepciones;

/**
 * Created by andrea on 29/04/16.
 */
public class PagoException extends RuntimeException {

    public PagoException(String message) {
        super(message);
    }
}
