package src.main.java.com.eventsystem.ui;

import src.main.java.com.eventsystem.model.Event;
import src.main.java.com.eventsystem.model.Registration;
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
            System.out.println("1. Register for an event"); // done
            System.out.println("2. View my registrations"); //done
            System.out.println("3. View all events"); // done
            System.out.println("4. update my details"); // done
            System.out.println("5. unregister from event"); // done
            System.out.println("6. Back to the first menu"); // done

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
                    updateParticipant();
                case 5:
                    unregisterFromEvent();
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }

    public void manageParticipants() {
        while (true) {
            System.out.println("\nParticipant Management Menu:");
            System.out.println("1. Add participant"); // done
            System.out.println("2. Update participant"); // done
            System.out.println("3. Delete participant"); //done
            System.out.println("4. View all participants"); // done
            System.out.println("5. unregister from event"); // done
            System.out.println("6. Back to the user menu"); // done

            int choice = scanner.nextInt();

            scanner.nextLine();
            switch (choice) {
                case 1:
                    addParticipant();
                    break;
                case 2:
                    updateParticipant();
                    break;
                case 3:
                    deleteParticipant();
                    break;
                case 4:
                    viewAllParticipants();
                    break;
                case 5:
                    unregisterFromEvent();
                case 6:
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
            System.out.println("5. Manage participants"); //done
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
                case 5:
                    manageParticipants();
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void addParticipant() {
        System.out.println("Eneter your name");
        String name = scanner.nextLine();

        System.out.println("Eneter your email");
        String email = scanner.nextLine();

        try {
            Participant participant = new Participant(name, email);
            participantService.addParticipant(participant);
            System.out.println("Participant successfully added");
        } catch (Exception e) {
            System.out.println("Invalid data");
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
    
        Participant participant = participantService.findParticipantByEmail(email);
        if (participant == null) {
            System.out.println("Participant not found, admin must add you as a participant first");
            return;
        }
    
        Event event = eventService.getAllEvents().get(eventIndex - 1);
        registrationService.registerParticipant(event, participant);
        System.out.println("Registered for event successfully");
    }

    private void unregisterFromEvent() {
        viewAllParticipants();
        System.out.println("Enter event index to unregister from:");
        int eventIndex = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your email");
        String email = scanner.nextLine();

        Participant participant = participantService.findParticipantByEmail(email);
        if(participant == null) {
            System.out.println("Participant not found, you must be registred from this event first");
            return;
        }
        Event event = eventService.getAllEvents().get(eventIndex - 1 );
        registrationService.unregisterParticipant(event, participant);

    }

    private void viewMyRegistrations(){
        System.out.println("Enter your email:");
        String email = scanner.nextLine();

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

    private void updateParticipant() {
        viewAllParticipants();
        System.out.println("Enter participant index to update:");
        int index = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new name:");
        String name = scanner.nextLine();

        System.out.println("Enter new email:");
        String email = scanner.nextLine();

        Participant participant = new Participant(name, email);
        participantService.updateParticipant(index - 1, participant);
        System.out.println("Participant updated successfully");
    }
    
    private void deleteEvent() {
        viewAllEvents();
        System.out.println("Enter event index to delete:");
        int index = scanner.nextInt();
        eventService.deleteEvent(index - 1);
        System.out.println("Event deleted successfully.");
    }

    private void deleteParticipant() {
        viewAllParticipants();
        System.out.println("Enter participant index to delete:");
        int index = scanner.nextInt();
        participantService.deleteParticipant(index);
        System.out.println("Participant deleted successfully.");
    }

    private void viewAllEvents() {
        List<Event> events = eventService.getAllEvents();
        for (int i = 0; i < events.size(); i++) {
            System.out.println((i + 1) + ". " + events.get(i));
        }
    }

    private void viewAllParticipants() {
        List<Participant> participants = participantService.getAllParticipants();
        for (int i = 0; i < participants.size(); i++) {
            System.out.println((i + 1) + ". " + participants.get(i));
        }
    }

}    