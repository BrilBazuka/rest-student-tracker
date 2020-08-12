package by.bryl.reststudenttracker.handler;

import by.bryl.reststudenttracker.error.StudentErrorResponse;
import by.bryl.reststudenttracker.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Application exception handler
 *
 * @author Andrew Bryl
 */

@ControllerAdvice
public class StudentExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentExceptionHandler.class);

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(ServiceException exc) {
        LOGGER.warn("Exception occurred " + exc);
        StudentErrorResponse response = buildResponse(exc, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(MethodArgumentNotValidException exc) {
        LOGGER.warn("Exception occurred " + exc);
        StudentErrorResponse response = new StudentErrorResponse();

        List<String> message = exc.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        response.setError(HttpStatus.BAD_REQUEST);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(message);
        response.setTimestamp(new Timestamp(System.currentTimeMillis()));

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(MethodArgumentTypeMismatchException exc) {
        LOGGER.warn("Exception occurred " + exc);

        StudentErrorResponse response = buildResponse(exc, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(HttpRequestMethodNotSupportedException exc) {
        LOGGER.warn("Exception occurred " + exc);

        StudentErrorResponse response = buildResponse(exc, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private StudentErrorResponse buildResponse(Exception exc, HttpStatus status) {
        StudentErrorResponse response = new StudentErrorResponse();

        ArrayList<String> message = new ArrayList<>(Arrays.asList(exc.getMessage()));

        response.setError(status);
        response.setStatus(status.value());
        response.setMessage(message);
        response.setTimestamp(new Timestamp(System.currentTimeMillis()));

        return response;
    }


}
