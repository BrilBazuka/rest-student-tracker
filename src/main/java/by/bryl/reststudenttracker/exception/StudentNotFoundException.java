package by.bryl.reststudenttracker.exception;

import by.bryl.reststudenttracker.model.Student;

/**
 * Not found exception for {@link Student} class.
 *
 * @author Andrew Bryl
 */

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
