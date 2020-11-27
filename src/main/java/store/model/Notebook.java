package store.model;

public class Notebook extends Product {
    int processors;
    boolean hasTouchScreen;


    public Notebook(double price, int stock, String manufacturer, int processors, boolean hasTouchScreen) {
        super(price, stock, manufacturer);
        this.processors = processors;
        this.hasTouchScreen = hasTouchScreen;
    }
}
