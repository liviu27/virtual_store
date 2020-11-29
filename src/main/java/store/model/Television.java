package store.model;

public class Television extends Product {
    int screenSize;
    boolean isSmart;


    public Television(Product product, int screenSize, boolean isSmart) {
        super(product.manufacturer, product.price, product.stock );
        this.screenSize = screenSize;
        this.isSmart = isSmart;
    }

    @Override
    public String toString() {
        return "Television {" +
                "manufacturer = " + manufacturer +
                ", screenSize = " + screenSize +
                ", isSmart = " + isSmart +
                ", price = " + price +
                ", stock = " + stock +
                '}';
    }
}
