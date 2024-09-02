package src.main.java.com.eventsystem.util;

public class ExceptionHandler {
    public static void handle(Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    }
}