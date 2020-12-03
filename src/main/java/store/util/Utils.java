package store.util;

import store.menus.StoreMenu;
import store.model.Product;

import java.util.Scanner;

public class Utils {
    public static Product addProduct(Scanner scanner) {
        System.out.println("Choose type of product:" +
                "\n1) Laptop" +
                "\n2) Television" +
                "\n3) Mobile phone");

        scanner.nextLine();
        String typeOfProduct = null;

        int option = scanner.nextInt();
        switch (option) {
            case 1:
                typeOfProduct = "laptop";
                break;
            case 2:
                typeOfProduct = "television";
                break;
            case 3:
                typeOfProduct = "mobile phone";
                break;
            default:
                System.out.println("No such option");
                StoreMenu.getInstance().displayMenu(scanner);
        }
        scanner.nextLine();
        System.out.print("Manufacturer: ");
        String manufacturer = scanner.nextLine();

        System.out.print("Price in Euro: ");
        double price = scanner.nextDouble();

        System.out.print("No. of products: ");
        int stock = scanner.nextInt();

        return new Product(typeOfProduct, manufacturer, price, stock);
    }
}
