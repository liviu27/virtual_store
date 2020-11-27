package store.menus;

import store.model.Basket;
import store.model.Customer;

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
                case INT_4 -> listBasketContent(scanner);
                case INT_5 -> removeProduct(scanner);
                case INT_6 -> removeAllProducts(scanner);
                case INT_7 -> System.out.println(mapCustomerBasket.keySet());
                case INT_8 -> System.out.println(mapCustomerBasket);
                default -> System.out.println(INVALID_OPTION);
            }
        } while (option != 9);
    }
}
