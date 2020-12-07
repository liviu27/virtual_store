package store.model;

public class MobilePhone extends Product {
    int batterySize;
    int megaPixels;

    public MobilePhone(Product product, int batterySize, int megaPixels) {
        super(product.type, product.name, product.price, product.quantity);
        this.batterySize = batterySize;
        this.megaPixels = megaPixels;
    }

    public MobilePhone(MobilePhone mobilePhone, int quantity) {
        this.type = mobilePhone.type;
        this.name = mobilePhone.name;
        this.price = mobilePhone.price;
        this.batterySize = mobilePhone.batterySize;
        this.megaPixels = mobilePhone.megaPixels;
        this.quantity = quantity;
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
