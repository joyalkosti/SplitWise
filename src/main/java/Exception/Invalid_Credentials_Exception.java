package Exception;

public class Invalid_Credentials_Exception extends RuntimeException{
    public Invalid_Credentials_Exception() {
    }

    public Invalid_Credentials_Exception(String message) {
        super(message);
    }

    public Invalid_Credentials_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Invalid_Credentials_Exception(Throwable cause) {
        super(cause);
    }

    public Invalid_Credentials_Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
