package store.menus;

import store.model.*;
import store.util.Utils;

import java.time.LocalDate;
import java.util.*;

public class StoreMenu implements IMenu {

    private static final String STORE_MENU = "\r\n=== Store Menu ==="
            + "\r\n*** choose option by number...\r\n"
            + "\r\n1. Register new customer"
            + "\r\n2. Add product in stock"
            + "\r\n3. Add product in basket"
            + "\r\n4. List basket content"
            + "\r\n5. Remove product from basket"
            + "\r\n6. Remove all products from basket"
            + "\r\n7. List all customers"
            + "\r\n8. List all customers with their basket"
            + "\r\n9. Return to main menu";
    private static StoreMenu instance = null;

    public static StoreMenu getInstance() {
        if (instance == null) {
            instance = new StoreMenu();
        }
        return instance;
    }

    private Map<Customer, Basket> mapCustomerBasket = new HashMap<>();
    private Map<String, Product> storeStock = new HashMap<>();


    @Override
    public void displayMenu(Scanner scanner) {
        int option;
        do {
            System.out.println(STORE_MENU);
            option = scanner.nextInt();

            switch (option) {
                case INT_1 -> addNewClient(scanner);
                case INT_2 -> addNewProduct(scanner);
                case INT_3 -> AddProductInBasketMenu.getInstance().displayMenu(scanner);
//                case INT_4 -> listBasketContent(scanner);
//                case INT_5 -> removeProduct(scanner);
//                case INT_6 -> removeAllProducts(scanner);
                case INT_7 -> System.out.println(mapCustomerBasket.keySet());
                case INT_8 -> System.out.println(mapCustomerBasket);
                case INT_9 -> System.out.print("Returning to main menu...");
                default -> System.out.println(INVALID_OPTION);
            }
        } while (option != 9);
    }

    private void addNewClient(Scanner scanner) {
        System.out.println("Add customer information:");
        scanner.nextLine();
        System.out.print("Name: ");
        String customerName = scanner.next();

        System.out.print("Adress: ");
        String customerAddress = scanner.next();

        System.out.print("Birthday [mm/day/year]: ");
        String[] birthday = scanner.next().split("/");
        int month = Integer.parseInt(birthday[0]);
        int day = Integer.parseInt(birthday[1]);
        int year = Integer.parseInt(birthday[2]);
        Birthday customerBirthday = new Birthday(month, day, year);

        Customer customer = new Customer(customerName, customerAddress, customerBirthday, LocalDate.now().getYear());
        Basket customerBasket = new Basket();
        mapCustomerBasket.put(customer, customerBasket);
        System.out.println(customer);
    }

    private void addNewProduct(Scanner scanner) {
        int option;
        do {
            System.out.println("\r\nChoose type of product: ... "
                    + "\r\n1) laptop"
                    + "\r\n2) television"
                    + "\r\n3) phone"
                    + "\n"
                    + "\r\n9) Return to previous menu.");

            option = scanner.nextInt();
            switch (option) {
                case INT_1 -> addLaptopToStock(scanner);
                case INT_2 -> addTvToStock(scanner);
                case INT_3 -> addPhoneToStock(scanner);
                default -> System.out.println("No such option...");
            }
        } while (option != 9);

    }

    private void addLaptopToStock(Scanner scanner) {
        String key = "laptop";
        Product product;
        Product laptop;

        System.out.println("Input product specifications: ");
        product = Utils.addProduct(scanner);

        System.out.print("No. of processors: ");
        int processors = scanner.nextInt();

        System.out.print("Has touch screen: [true/false] ");
        boolean hasTouchScreen = scanner.nextBoolean();

        laptop = new Notebook(product, processors, hasTouchScreen);
        storeStock.put(key, laptop);
    }

    private void addTvToStock(Scanner scanner) {
        String key = "television";
        Product product;
        Product television;

        System.out.println("Input product specifications: ");
        product = Utils.addProduct(scanner);

        System.out.print("Screen size in inches: ");
        int screedSize = scanner.nextInt();

        System.out.print("Has touch screen: [true/false] ");
        boolean isSmart = scanner.nextBoolean();

        television = new Television(product, screedSize, isSmart);
        storeStock.put(key, television);
    }

    private void addPhoneToStock(Scanner scanner) {
        String key = "phone";
        Product product;
        Product phone;

        System.out.println("Input product specifications: ");
        product = Utils.addProduct(scanner);

        System.out.print("Battery size in mAh: ");
        int batterySize = scanner.nextInt();

        System.out.print("No. of mega pixels for main camera: ");
        int megaPixels = scanner.nextInt();

        phone = new MobilePhone(product, batterySize, megaPixels);
        storeStock.put(key, phone);
        System.out.println(phone);
    }

//    private Product addProduct(Scanner scanner) {
//        scanner.nextLine();
//        System.out.print("Manufacturer: ");
//        String manufacturer = scanner.nextLine();
//
//        System.out.print("Price: ");
//        double price = scanner.nextDouble();
//
//        System.out.print("No. of products: ");
//        int stock = scanner.nextInt();
//
//        return new Product(manufacturer, price, stock);
//    }
}
