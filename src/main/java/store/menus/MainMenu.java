package store.menus;

import java.util.Scanner;

public class MainMenu implements IMenu {
    //Singleton pattern
    private static MainMenu instance = null;

    private static final String MAIN_MENU = "\r\n=== Virtual Store ===\r\n"
            + "\r\n0) Access the store"
            + "\r\n9) Close application";

    public static MainMenu getInstance() {
        if (instance == null) {
            instance = new MainMenu();
        }
        return instance;
    }

    @Override
    public void displayMenu(Scanner scanner) {
        int option;
        do {
            System.out.println(MAIN_MENU);
            option = scanner.nextInt();
            switch (option) {
                case INT_0 -> StoreMenu.getInstance().displayMenu(scanner);
                case INT_9 -> {
                    System.out.println(EXIT);
                    System.exit(0);
                }
                default -> System.out.println(INVALID_OPTION);
            }
        } while (true);
    }
}
