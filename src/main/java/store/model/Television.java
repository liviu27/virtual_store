package store.model;

public class Television extends Product {
    int screenSize;
    boolean isSmart;


    public Television(double price, int stock, String manufacturer, int screenSize, boolean isSmart) {
        super(price, stock, manufacturer);
        this.screenSize = screenSize;
        this.isSmart = isSmart;
    }
}
