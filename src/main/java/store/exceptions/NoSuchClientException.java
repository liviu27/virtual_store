package store.exceptions;

public class NoSuchClientException extends Exception{
    public NoSuchClientException() {
        super("Client does not exist!"
        + "\nRe-enter client name or register a new one.");
    }
}
