package store.model;

public class Notebook extends Product {
    int processors;
    boolean hasTouchScreen;


    public Notebook(Product product, int processors, boolean hasTouchScreen) {
        super(product.type ,product.name, product.price, product.quantity);
        this.processors = processors;
        this.hasTouchScreen = hasTouchScreen;
    }

    @Override
    public String toString() {
        return "Notebook {" +
                "name/model = " + name +
                ", processors = " + processors +
                ", hasTouchScreen = " + hasTouchScreen +
                ", price = " + price +
                ", stock = " + quantity +
                '}';
    }
}
