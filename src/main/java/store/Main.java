package store;

import store.menus.MainMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainMenu.getInstance().displayMenu(scanner);
        scanner.close();
    }
}
