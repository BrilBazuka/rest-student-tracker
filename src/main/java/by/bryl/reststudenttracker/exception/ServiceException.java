package by.bryl.reststudenttracker.exception;

import by.bryl.reststudenttracker.service.implementation.StudentServiceImpl;

/**
 * Exception for {@link StudentServiceImpl} class
 *
 * @author Andrew Bryl
 */

public class ServiceException extends RuntimeException {
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
