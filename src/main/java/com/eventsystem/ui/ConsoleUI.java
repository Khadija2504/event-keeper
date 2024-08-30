package src.main.java.com.eventsystem.ui;
import java.util.Scanner;

public class ConsoleUI {
    private Menu menu;
    private boolean isAdmin = true;

    public ConsoleUI() {
        this.menu = new Menu();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nCurrent Role: " + (isAdmin ? "Admin" : "Regular user"));
            System.out.println("1. Switch Role");
            System.out.println("2. Menu");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    switchRole();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void switchRole() {
        isAdmin = !isAdmin;
    }
}
