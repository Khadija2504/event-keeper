package src.main.java.com.eventsystem.util;
    
public class InputValidator {
    public static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }
}
