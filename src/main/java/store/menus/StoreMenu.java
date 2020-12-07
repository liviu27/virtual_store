package store.menus;

import store.exceptions.NoSuchClientException;
import store.model.*;
import store.util.Utils;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static store.service.ClientService.CLIENT_SERVICE;
import static store.service.StockService.STOCK_SERVICE;

public class StoreMenu implements IMenu {

    private static final String STORE_MENU = "\r\n=== Store Menu ==="
            + "\r\n*** choose option by number ***\r\n"
            + "\r\n1. Register new Client"
            + "\r\n2. Add product in stock"
            + "\r\n3. Update stock"
            + "\r\n4. Add product in basket"
            + "\r\n5. List basket content"
            + "\r\n6. Remove product from basket"
            + "\r\n7. Remove all products from basket"
            + "\r\n8. List all customers"
            + "\r\n9. List all customers with their basket"
            + "\r\n0. Return to main menu";
    private static StoreMenu instance = null;

    public static StoreMenu getInstance() {
        if (instance == null) {
            instance = new StoreMenu();
        }
        return instance;
    }

    @Override
    public void displayMenu(Scanner scanner) {
        int option;
        do {
            System.out.println(STORE_MENU);
            option = scanner.nextInt();

            switch (option) {
                case INT_1 -> addNewClient(scanner);
                case INT_2 -> addProductToStock(scanner);
                case INT_3 -> updateStock(scanner);
                case INT_4 -> addProductToBasket(scanner);
                case INT_5 -> listBasketContent(scanner);
                case INT_6 -> removeProduct(scanner);
                case INT_7 -> removeAllProducts(scanner);
                case INT_8 -> System.out.println(CLIENT_SERVICE.getRegisteredClients());
                case INT_9 -> System.out.println(CLIENT_SERVICE.getAllClientsWithBasket());
                case INT_0 -> System.out.print("Returning to main menu...");
                default -> System.out.println(INVALID_OPTION);
            }
        } while (option != 0);
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
        System.out.println("Insert product specifications for laptop, television, mobile phone: ");
        Product product = Utils.addProduct(scanner);

        switch (product.getType()) {
            case "notebook" -> {
                System.out.print("No. of processors: ");
                int processors = scanner.nextInt();
                System.out.print("Has touch screen: [true/false] ");
                boolean hasTouchScreen = scanner.nextBoolean();
                product = new Notebook(product, processors, hasTouchScreen);
            }
            case "television" -> {
                System.out.print("Screen size in inches: ");
                int screenSize = scanner.nextInt();
                System.out.print("Has Smart capabilities: [true/false] ");
                boolean isSmart = scanner.nextBoolean();
                product = new Television(product, screenSize, isSmart);
            }
            case "mobile phone" -> {
                System.out.print("Battery size in mAh: ");
                int batterySize = scanner.nextInt();
                System.out.print("No. of mega pixels for main camera: ");
                int megaPixels = scanner.nextInt();
                product = new MobilePhone(product, batterySize, megaPixels);
            }
        }
        STOCK_SERVICE.addNewProduct(product);
//        STOCK_SERVICE.listStock();
    }

    private void updateStock(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Name product to update it's quantity: ");
        STOCK_SERVICE.listStock();

        String productName = scanner.nextLine();
        System.out.println("Enter updated quantity for " + productName + ": ");
        int updatedQuantity = scanner.nextInt();
        STOCK_SERVICE.setStock(productName, updatedQuantity);
    }

    private void addProductToBasket(Scanner scanner) {
        // Client verification
        Client verifiedClient = verifyClient(scanner);

        // Listing all products from stock
        System.out.print("Select item (input no.) from the list below to add to your basket:\n");
        List<Product> productsInStock = STOCK_SERVICE.getAllProductsInStock();
        for (int i = 0; i < productsInStock.size(); i++) {
            System.out.println((i + 1) + ". " + productsInStock.get(i));
        }

        //Choosing product and quantity
        int index = scanner.nextInt() - 1;
        System.out.print("\nChoose quantity: ");
        int quantityInBasket = scanner.nextInt();

        Product chosenProduct = productsInStock.get(index);
        Product productToBeAdded = null;
        switch (chosenProduct.getType()) {
            case "notebook" -> productToBeAdded = new Notebook((Notebook) chosenProduct, quantityInBasket);
            case "television" -> productToBeAdded = new Television((Television) chosenProduct, quantityInBasket);
            case "mobile phone" -> productToBeAdded = new MobilePhone((MobilePhone) chosenProduct, quantityInBasket);
        }

        // Update stock
        if (chosenProduct.getQuantity() < 1) {
            System.err.println("Insufficient Stock, chose other product!");
            StoreMenu.getInstance().displayMenu(scanner);
        }
        STOCK_SERVICE.setStock(productsInStock.get(index).getName(), productsInStock.get(index).getQuantity() - quantityInBasket);

        // Add to basket
        CLIENT_SERVICE.setBasket(verifiedClient.getName(), productToBeAdded);
    }

    private void listBasketContent(Scanner scanner) {
        Client verifiedClient = verifyClient(scanner);

        System.out.println("Basket content: ");
        List<Product> verifiedClientBasket = verifiedClient.getBasket().getBasketContent();
        for (int i = 0; i < verifiedClientBasket.size(); i++) {
            System.out.println((i + 1) + verifiedClientBasket.get(i).toString());
        }
        double basketValue = 0;
        for (Product product : verifiedClientBasket) {
            basketValue += (product.getPrice() * product.getQuantity());
        }

        double basketValueWithDiscount = Utils.getDiscount(verifiedClient, basketValue);
        System.out.println("\nBasket value is: " + basketValueWithDiscount);

    }

    private void removeProduct(Scanner scanner) {
        Client verifiedClient = verifyClient(scanner);
        System.out.println("Type name of product to be removed from basket: ");
        String productName = scanner.nextLine();
        List<Product> basketContent = verifiedClient.getBasket().getBasketContent();
        Iterator<Product> it = basketContent.iterator();
        while (it.hasNext()){
            if(productName.equals(it.next().getName())){
                it.remove();
            }
        }
    }

    private void removeAllProducts(Scanner scanner) {
        Client verifiedClient = verifyClient(scanner);
        verifiedClient.getBasket().getBasketContent().clear();
        System.out.println("Basket is cleared!");
        System.out.println(verifiedClient.getName() + " - Basket = " + verifiedClient.getBasket().getBasketContent());
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




