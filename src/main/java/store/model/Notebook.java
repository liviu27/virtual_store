package store.model;

public class Notebook extends Product {
    int processors;
    boolean hasTouchScreen;

    // Constructor fot product in stock
    public Notebook(Product product, int processors, boolean hasTouchScreen) {
        super(product.type, product.name, product.price, product.quantity);
        this.processors = processors;
        this.hasTouchScreen = hasTouchScreen;
    }

    // Constructor for product in basket
    public Notebook(Notebook notebook, int quantity) {
        this.type = notebook.type;
        this.name = notebook.name;
        this.price = notebook.price;
        this.processors = notebook.processors;
        this.hasTouchScreen = notebook.hasTouchScreen;
        this.quantity = quantity;
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
