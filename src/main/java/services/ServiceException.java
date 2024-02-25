package services;

/*
 * Have a service level exception to abstract away exceptions thrown in lower layers (i.e. api, network layer)
 */
public class ServiceException extends Exception {
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
