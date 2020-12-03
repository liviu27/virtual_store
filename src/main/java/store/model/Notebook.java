package store.model;

public class Notebook extends Product {
    int processors;
    boolean hasTouchScreen;


    public Notebook(Product product, int processors, boolean hasTouchScreen) {
        super(product.type ,product.manufacturer, product.price, product.stock);
        this.processors = processors;
        this.hasTouchScreen = hasTouchScreen;
    }

    @Override
    public String toString() {
        return "Notebook {" +
                "manufacturer = " + manufacturer +
                ", processors = " + processors +
                ", hasTouchScreen = " + hasTouchScreen +
                ", price = " + price +
                ", stock = " + stock +
                '}';
    }
}
