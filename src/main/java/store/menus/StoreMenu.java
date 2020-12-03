package store.menus;

import store.exceptions.InsufficientStockException;
import store.exceptions.NoSuchClientException;
import store.model.*;
import store.service.ClientService;
import store.util.Utils;

import java.time.LocalDate;
import java.util.*;

import static store.service.ClientService.CLIENT_SERVICE;

public class StoreMenu implements IMenu {

    private static final String STORE_MENU = "\r\n=== Store Menu ==="
            + "\r\n*** choose option by number ***\r\n"
            + "\r\n0. Register new Client"
            + "\r\n1. Add product in stock"
            + "\r\n2. Update stock"
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


    private List<Product> laptopStock = new ArrayList<>();
    private List<Product> televisionStock = new ArrayList<>();
    private List<Product> mobileStock = new ArrayList<>();


    @Override
    public void displayMenu(Scanner scanner) {
        int option;
        do {
            System.out.println(STORE_MENU);
            option = scanner.nextInt();

            switch (option) {
                case INT_0 -> addNewClient(scanner);
                case INT_1 -> addProductToStock(scanner);
//                case INT_2 -> updateStock(scanner);
                case INT_3 -> addProductToBasket(scanner);
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
        System.out.println("Add Client information:");
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

        Client client = new Client(customerName, customerAddress, customerBirthday, LocalDate.now().getYear());
        CLIENT_SERVICE.addNewClient(client);
        System.out.println(client);
    }

    private void addProductToStock(Scanner scanner) {
        Product product;

        System.out.println("Insert product specifications for laptop, television, mobile phone: ");
        product = Utils.addProduct(scanner);

        switch (product.getType()) {
            case "laptop" -> {
                Product laptop;
                System.out.print("No. of processors: ");
                int processors = scanner.nextInt();
                System.out.print("Has touch screen: [true/false] ");
                boolean hasTouchScreen = scanner.nextBoolean();
                laptop = new Notebook(product, processors, hasTouchScreen);
                laptopStock.add(laptop);
            }
            case "television" -> {
                Product television;
                System.out.print("Screen size in inches: ");
                int screenSize = scanner.nextInt();
                System.out.print("Has Smart capabilities: [true/false] ");
                boolean isSmart = scanner.nextBoolean();
                television = new Television(product, screenSize, isSmart);
                televisionStock.add(television);
            }
            case "mobile phone" -> {
                Product phone;
                System.out.print("Battery size in mAh: ");
                int batterySize = scanner.nextInt();
                System.out.print("No. of mega pixels for main camera: ");
                int megaPixels = scanner.nextInt();
                phone = new MobilePhone(product, batterySize, megaPixels);
                mobileStock.add(phone);
            }
        }
    }

    private void addProductToBasket(Scanner scanner) {
        // Client verification
        Client client = verifyClient(scanner);

        Basket basket = new Basket();

        final String ADD_TO_BASKET_MENU = "\r\nHello " + client.getName() + ", choose item to add to your basket:"
                + "\r\n1) Laptop"
                + "\r\n2) Television"
                + "\r\n3) Mobile phone\n"
                + "\r\n9) Return to Store";
        int option;
        do {
            System.out.println(ADD_TO_BASKET_MENU);
            option = scanner.nextInt();
            switch (option) {
                case INT_1 -> {
                    System.out.println(laptopStock);
                    System.out.println("Select item to add to your basket");
                    int itemToAdd = scanner.nextInt();
                    basket.getBasket().add(laptopStock.get(itemToAdd));
                    // Update stock.
                    if(laptopStock.get(itemToAdd).getStock() == 0) {
                        try {
                            throw  new InsufficientStockException();
                        } catch (InsufficientStockException e) {
                            e.printStackTrace();
                        }
                    } else {
                        int initialStockForSelectedItem = laptopStock.get(itemToAdd).getStock();
                        laptopStock.get(itemToAdd).setStock(initialStockForSelectedItem - 1);
                    }
                    mapCustomerBasket.put(client, basket);

                }
//                case INT_2 -> addTvToBasket(scanner); //TODO
//                case INT_3 -> addPhoneToBasket(scanner); //TODO
                case INT_9 -> System.out.println("...returning to Store Menu.");
                default -> System.out.println(INVALID_OPTION);
            }
        } while (option != 9);
    }

    private Client verifyClient(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter Client name: ");
        Client client = null;
        do {
            String clientName = scanner.nextLine();
            try {
                client = CLIENT_SERVICE.getClientByName(clientName);
            } catch (NoSuchClientException e) {
                System.err.println("Please try again, the username doesn't exist");
            }
        } while (client == null);
        return client;
    }

}




