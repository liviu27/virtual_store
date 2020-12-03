package store.model;

public class Product {
    String type;
    String manufacturer;
    double price;
    int stock;

    public Product(String type, String manufacturer, double price, int stock) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.price = price;
        this.stock = stock;
    }

    public String getType() {
        return type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
