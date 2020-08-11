package by.bryl.reststudenttracker.exception;

import by.bryl.reststudenttracker.service.implementation.StudentService;

/**
 * Exception for {@link StudentService} class
 *
 * @author Andrew Bryl
 */

public class ServiceException extends Exception {
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
