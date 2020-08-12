package by.bryl.reststudenttracker.error;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.util.List;

/**
 * Error response for user requests
 *
 * @author Andrew Bryl
 */

public class StudentErrorResponse {
    private Timestamp timestamp;
    private int status;
    private HttpStatus error;
    private List<String> messages;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(Timestamp timestamp, int status, HttpStatus error, List<String> messages) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.messages = messages;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public HttpStatus getError() {
        return error;
    }

    public void setError(HttpStatus error) {
        this.error = error;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
