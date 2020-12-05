package store.model;

public class Product {
    String type;
    String name;
    double price;
    int quantity;

    public Product(String type, String name, double price, int quantity) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

