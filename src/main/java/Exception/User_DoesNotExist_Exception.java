package Exception;

public class User_DoesNotExist_Exception extends RuntimeException{

    public User_DoesNotExist_Exception() {
    }

    public User_DoesNotExist_Exception(String message) {
        super(message);
    }

    public User_DoesNotExist_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public User_DoesNotExist_Exception(Throwable cause) {
        super(cause);
    }

    public User_DoesNotExist_Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
