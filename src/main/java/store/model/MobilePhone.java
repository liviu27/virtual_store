package store.model;

public class MobilePhone extends Product {
    int batterySize;
    int megaPixels;

    public MobilePhone(Product product, int batterySize, int megaPixels) {
        super(product.type, product.name, product.price, product.quantity);
        this.batterySize = batterySize;
        this.megaPixels = megaPixels;
    }

    @Override
    public String toString() {
        return "Mobile Phone {" +
                "name/model = " + name +
                ", megaPixels = " + megaPixels +
                ", battery size = " + batterySize +
                ", price = " + price +
                ", stock = " + quantity +
                '}';
    }
}
