package utils;

/**
 * Created by andrea on 25/04/16.
 */
public class Validation {

    Boolean isError;
    String message;

    public Validation(Boolean isError, String message) {
        this.isError = isError;
        this.message = message;
    }

    public Boolean getIsError() {
        return isError;
    }

    public void setIsError(Boolean isError) {
        this.isError = isError;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
