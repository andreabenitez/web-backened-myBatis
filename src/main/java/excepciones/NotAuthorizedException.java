package excepciones;

/**
 * Created by andrea on 19/05/16.
 */
public class NotAuthorizedException extends RuntimeException {

    public NotAuthorizedException(String message) {
        super(message);
    }
}
