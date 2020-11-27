package store.model;

public class MobilePhone extends Product {
    int batterySize;
    int megaPixels;

    public MobilePhone(double price, int stock, String manufacturer, int batterySize, int megaPixels) {
        super(price, stock, manufacturer);
        this.batterySize = batterySize;
        this.megaPixels = megaPixels;
    }
}
