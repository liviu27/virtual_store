package store.model;

public class Television extends Product {
    int screenSize;
    boolean isSmart;


    public Television(Product product, int screenSize, boolean isSmart) {
        super(product.type, product.name, product.price, product.quantity);
        this.screenSize = screenSize;
        this.isSmart = isSmart;
    }

    @Override
    public String toString() {
        return "Television {" +
                "name/model = " + name +
                ", screenSize = " + screenSize +
                ", isSmart = " + isSmart +
                ", price = " + price +
                ", stock = " + quantity +
                '}';
    }
}
