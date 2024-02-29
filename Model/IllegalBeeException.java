package Model;

public class IllegalBeeException extends Exception {
    public IllegalBeeException(String message) {
        super(message);
    }

    public IllegalBeeException() {
        super();
    }
}
