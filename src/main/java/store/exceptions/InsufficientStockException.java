package store.exceptions;

public class InsufficientStockException extends Exception {
    public InsufficientStockException() {
        super("Insuficient stock, choose a small quantity!");
    }
}
