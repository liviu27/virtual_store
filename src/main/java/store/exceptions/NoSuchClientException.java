package store.exceptions;

public class NoSuchClientException extends Exception{
    public NoSuchClientException() {
        super("Client inexitent!");
    }
}
