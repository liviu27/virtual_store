package store.menus;

import java.util.Scanner;

public class AddProductInBasketMenu implements IMenu {

    //Singleton pattern
    private static AddProductInBasketMenu instance = null;

    private static final String ADD_TO_BASKET_MENU = "\r\nAdd to basket:"
            + "\r\n - laptop (key 1)"
            + "\r\n - television (key 2)"
            + "\r\n - phone (key 3)"
            + "\r\n Return to Sore (key 9)";

    public static AddProductInBasketMenu getInstance() {
        if (instance == null) {
            instance = new AddProductInBasketMenu();
        }
        return instance;
    }

    @Override
    public void displayMenu(Scanner scanner) {
        int option;
        do {
            System.out.println(ADD_TO_BASKET_MENU);
            option = scanner.nextInt();
            switch (option) {
//                case INT_1 -> addLaptopToBasket(scanner); //TODO
//                case INT_2 -> addTvToBasket(scanner); //TODO
//                case INT_3 -> addPhoneToBasket(scanner); //TODO
                default -> System.out.println(INVALID_OPTION);
            }
        } while (option != 9);
    }
}
