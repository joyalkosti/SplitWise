package Exception;

public class User_Invalid_Data_Exception extends RuntimeException{
    public User_Invalid_Data_Exception() {
    }

    public User_Invalid_Data_Exception(String message) {
        super(message);
    }

    public User_Invalid_Data_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public User_Invalid_Data_Exception(Throwable cause) {
        super(cause);
    }

    public User_Invalid_Data_Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
