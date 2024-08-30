package src.main.java.com.eventsystem.ui;

import src.main.java.com.eventsystem.model.Event;
import src.main.java.com.eventsystem.model.Participant;
import src.main.java.com.eventsystem.service.EventService;
import src.main.java.com.eventsystem.service.ParticipantService;
import src.main.java.com.eventsystem.service.RegistrationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private EventService eventService = new EventService();
    private ParticipantService participantService = new ParticipantService();
    private RegistrationService registrationService = new RegistrationService();
    private Scanner scanner = new Scanner(System.in);

    public void userMenu() {
        while (true) {
            System.out.println("\nUser Menu:");
            System.out.println("1. Register for an event");
            System.out.println("2. View my registered events");
            System.out.println("3. View all events");
            System.out.println("3. Back to the first menu");

            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerForEvent();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }

    public void adminMenu() {
        while (true) {
            System.out.println("\nAdministrator Menu:");
            System.out.println("1. Add event");
            System.out.println("2. Delete event");
            System.out.println("3. Update event");
            System.out.println("4. Events list");
            System.out.println("5. Manage participants");
            System.out.println("6. Back to the first menu");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    updateEvent();
                    break;
                case 3:
                    deleteEvent();
                    break;
                case 4:
                    viewAllEvents();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    
    private void addEvent() {
        System.out.println("Enter event name:");
        String name = scanner.nextLine();
    
        System.out.println("Enter event location:");
        String location = scanner.nextLine();
    
        System.out.println("Enter event date (dd/MM/yyyy):");
        String dateStr = scanner.nextLine();
    
        System.out.println("Enter event type:");
        String type = scanner.nextLine();
    
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
            Event event = new Event(name, location, date, type);
            eventService.addEvent(event);
            System.out.println("Event added successfully.");
        } catch (ParseException e) {
            System.out.println("Invalid date format.");
        }
    }

    private void registerForEvent() {
        viewAllEvents();
        System.out.println("Enter event index to register for:");
        int index = scanner.nextInt();
        scanner.nextLine();

        // try {
            
            // registrationService.addRegistration(registration);
            
        // }
    }
    
    private void updateEvent() {
        viewAllEvents();
        System.out.println("Enter event index to update:");
        int index = scanner.nextInt();
        scanner.nextLine();
    
        System.out.println("Enter new event name:");
        String name = scanner.nextLine();
    
        System.out.println("Enter new event location:");
        String location = scanner.nextLine();
    
        System.out.println("Enter new event date (dd/MM/yyyy):");
        String dateStr = scanner.nextLine();
    
        System.out.println("Enter new event type:");
        String type = scanner.nextLine();
    
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
            Event event = new Event(name, location, date, type);
            eventService.updateEvent(index - 1, event);
            System.out.println("Event updated successfully.");
        } catch (ParseException e) {
            System.out.println("Invalid date format.");
        }
    }
    
    private void deleteEvent() {
        viewAllEvents();
        System.out.println("Enter event index to delete:");
        int index = scanner.nextInt();
        eventService.deleteEvent(index - 1);
        System.out.println("Event deleted successfully.");
    }

    private void viewAllEvents() {
        List<Event> events = eventService.getAllEvents();
        for (int i = 0; i < events.size(); i++) {
            System.out.println((i + 1) + ". " + events.get(i));
        }
    }

   
}    