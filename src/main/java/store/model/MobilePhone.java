package store.model;

public class MobilePhone extends Product {
    int batterySize;
    int megaPixels;

    public MobilePhone(Product product, int batterySize, int megaPixels) {
        super(product.type, product.manufacturer, product.price, product.stock);
        this.batterySize = batterySize;
        this.megaPixels = megaPixels;
    }

    @Override
    public String toString() {
        return "Mobile Phone {" +
                "manufacturer = " + manufacturer +
                ", megaPixels = " + megaPixels +
                ", battery size = " + batterySize +
                ", price = " + price +
                ", stock = " + stock +
                '}';
    }
}
