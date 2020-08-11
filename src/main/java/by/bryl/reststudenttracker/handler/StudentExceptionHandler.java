package by.bryl.reststudenttracker.handler;

import by.bryl.reststudenttracker.error.StudentErrorResponse;
import by.bryl.reststudenttracker.exception.ServiceException;
import by.bryl.reststudenttracker.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;

/**
 * Application exception handler
 *
 * @author Andrew Bryl
 */

@ControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(ServiceException exc) {
        StudentErrorResponse response = new StudentErrorResponse();

        response.setError(HttpStatus.NOT_FOUND);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(exc.getMessage());
        response.setTimestamp(new Timestamp(System.currentTimeMillis()));

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
