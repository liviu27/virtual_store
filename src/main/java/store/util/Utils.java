package store.util;

import store.model.Product;

import java.util.Scanner;

public interface Utils {
    static Product addProduct(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Manufacturer: ");
        String manufacturer = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        System.out.print("No. of products: ");
        int stock = scanner.nextInt();

        return new Product(manufacturer, price, stock);
    }
}
