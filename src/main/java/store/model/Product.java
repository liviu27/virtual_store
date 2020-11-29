package store.model;

public class Product {
    String manufacturer;
    double price;
    int stock;

    public Product(String manufacturer, double price, int stock) {
        this.manufacturer = manufacturer;
        this.price = price;
        this.stock = stock;
    }

}
