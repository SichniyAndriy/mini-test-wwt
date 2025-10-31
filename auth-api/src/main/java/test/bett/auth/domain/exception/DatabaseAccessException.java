package test.bett.auth.domain.exception;

public class DatabaseAccessException extends RuntimeException {

    public DatabaseAccessException(String message) {
        super(message);
    }

}
