package store.menus;

import java.util.Scanner;

public class AddProductInBasketMenu implements IMenu {

    //Singleton pattern
    private static AddProductInBasketMenu instance = null;

    public static AddProductInBasketMenu getInstance() {
        if (instance == null) {
            instance = new AddProductInBasketMenu();
        }
        return instance;
    }

    @Override
    public void displayMenu(Scanner scanner) {
        //TODO
    }
}
