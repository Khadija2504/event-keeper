package src.main.java.com.eventsystem.ui;

import src.main.java.com.eventsystem.model.Event;
import src.main.java.com.eventsystem.model.Participant;
import src.main.java.com.eventsystem.service.EventService;
import src.main.java.com.eventsystem.service.ParticipantService;
import src.main.java.com.eventsystem.service.RegistrationService;
import src.main.java.com.eventsystem.util.InputValidator;

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
    private SecondMenu secondMenu;

    public Menu() {
        this.secondMenu = new SecondMenu();
    }

    public void userMenu() {
        while (true) {
            System.out.println("\nUser Menu:");
            System.out.println("1. Register for an event"); // done
            System.out.println("2. View my registrations"); //done
            System.out.println("3. View all events"); // done
            System.out.println("4. update my details"); // done
            System.out.println("5. unregister from event"); // done
            System.out.println("6. Search events"); // done
            System.out.println("7. Back to the first menu"); // done

            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerForEvent();
                    break;
                case 2:
                    viewMyRegistrations();
                    break;
                case 3:
                    viewAllEvents();
                    break;
                case 4:
                    secondMenu.updateParticipant();
                    break;
                case 5:
                    secondMenu.unregisterFromEvent();
                    break;
                case 6:
                    secondMenu.searchMenu();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }

    public void adminMenu() {
        while (true) {
            System.out.println("\nAdministrator Menu:");
            System.out.println("1. Add event"); // done
            System.out.println("2. Delete event"); // done
            System.out.println("3. Update event"); //done
            System.out.println("4. Events list"); // done
            System.out.println("5. View all event inscriptions");
            System.out.println("6. Manage participants"); //done
            System.out.println("7. Search events"); // done
            System.out.println("8. Events with one participant at least"); //working on
            System.out.println("9. Generate reports"); // Not yet
            System.out.println("10. Back to the first menu"); //done

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
                case 5:
                    viewAllEventRegistrations();
                    break;
                case 6:
                    secondMenu.manageParticipants();
                    break;
                case 7:
                    secondMenu.searchMenu();
                    break;
                case 8:
                    EventsWithOneParticipantsOrMore();
                    break;
                case 9:
                    secondMenu.generateReports();
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void EventsWithOneParticipantsOrMore() {
        System.out.println("Events with one or more then one participant");
        List<Event> events = eventService.getAllEvents();
        for (Event event : events) {
            List<Participant> participants = registrationService.getRegistrationsForEvent(event);
            if(participants.size() > 0) {
                System.out.println(event);
                System.out.println("Inacriptions for this event:");
                for (Participant participant : participants) {
                    System.out.println(participant);
                }
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
            System.out.println("Event added successfully");
        } catch (ParseException e) {
            System.out.println("Invalid date format");
        }
    }

    private void registerForEvent() {
        viewAllEvents();
        System.out.println("Enter event index to register for:");
        int eventIndex = scanner.nextInt();
        scanner.nextLine();
    
        System.out.println("Enter your email:");
        String email = scanner.nextLine();

        if(!InputValidator.isValidEmail(email)) {
            System.out.println("Invalid email format");
            return;
        }
    
        Participant participant = participantService.findParticipantByEmail(email);
        if (participant == null) {
            System.out.println("Participant not found, admin must add you as a participant first");
            return;
        }
    
        Event event = eventService.getAllEvents().get(eventIndex - 1);
        registrationService.registerParticipant(event, participant);
        System.out.println("Registered for event successfully");
    }


    private void viewMyRegistrations(){
        System.out.println("Enter your email:");
        String email = scanner.nextLine();

        if(!InputValidator.isValidEmail(email)) {
            System.out.println("Invalid email format");
            return;
        }

        Participant participant = participantService.findParticipantByEmail(email);
        if (participant == null) {
            System.out.println("Participant not found.");
            return;
        }
    
        List<Event> events = registrationService.getEventsForParticipant(participant);
        for (Event event : events) {
            System.out.println(event);
        }
    }

    private void viewAllEventRegistrations() {
        viewAllEvents();
        System.out.println("Enter event index:");
        int eventIndex = scanner.nextInt();
        scanner.nextLine();

        Event event = eventService.getAllEvents().get(eventIndex - 1);
        List<Participant> participants = registrationService.getRegistrationsForEvent(event);
        for (Participant participant : participants) {
            System.out.println(participant);
        }
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
            System.out.println("Event updated successfully");
        } catch (ParseException e) {
            System.out.println("Invalid date format");
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