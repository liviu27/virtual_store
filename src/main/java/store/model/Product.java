package store.model;

public class Product {
    double price;
    int stock;
    String manufacturer;

    public Product(double price, int stock, String manufacturer) {
        this.price = price;
        this.stock = stock;
        this.manufacturer = manufacturer;
    }

}
