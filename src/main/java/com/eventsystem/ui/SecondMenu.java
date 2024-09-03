package src.main.java.com.eventsystem.ui;

import src.main.java.com.eventsystem.model.Event;
import src.main.java.com.eventsystem.model.Participant;
import src.main.java.com.eventsystem.service.EventService;
import src.main.java.com.eventsystem.service.ParticipantService;
import src.main.java.com.eventsystem.service.RegistrationService;
import src.main.java.com.eventsystem.util.InputValidator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SecondMenu {

    private EventService eventService = new EventService();
    private ParticipantService participantService = new ParticipantService();
    private RegistrationService registrationService = new RegistrationService();
    private Scanner scanner = new Scanner(System.in);

    public void searchMenu(){
        System.out.println("Search by type:");
        System.out.println("1. Type");
        System.out.println("2. Date");
        System.out.println("3. place");
        System.out.println("4. Back to the previous menu");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                findEventsByType();
                break;
            case 2:
                findEventsByDate();
                break;
            case 3:
                findEventsByLocation();
                break;
            case 4:
                return;
            default:
                break;
        }
    }

    public void generateReports() {
        System.out.println("1. generate report for next week");
        System.out.println("2. generate report for previous week");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice) {
            case 1:
                generateNextWeekReport();
                break;
            case 2:
                generatePreviousWeekReport();
                break;
            default:
                System.out.println("Invalid choice");
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
            System.out.println("6. Back to the previous menu"); // done

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
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    //search

        private void findEventsByDate() {
        System.out.println("Enter event date (dd/mm/yyyy)");
        String dateString = scanner.nextLine();
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
            List<Event> events = EventService.findEventsByDate(date);
            for (Event event : events) {
                System.out.println(event);
            }
        } catch (Exception e) {
            System.out.println("Invalid date format");
        }

    }

    private void findEventsByLocation() {
        System.out.println("Eneter event location");
        String location = scanner.nextLine();
        List<Event> events = eventService.FindEventByLocation(location);
        for (Event event : events) {
            System.out.println(event);
        }
    }

    private void findEventsByType() {
        System.out.println("Enter event type:");
        String type = scanner.nextLine();

        List<Event> events = eventService.FindEventByType(type);
        for (Event event : events) {
            System.out.println(event);
        }
    }

    // participants

    public void viewAllParticipants() {
        List<Participant> participants = participantService.getAllParticipants();
        for (int i = 0; i < participants.size(); i++) {
            System.out.println((i + 1) + ". " + participants.get(i));
        }
    }

    private void addParticipant() {
        System.out.println("Eneter your name");
        String name = scanner.nextLine();

        System.out.println("Eneter your email");
        String email = scanner.nextLine();

        if(!InputValidator.isValidEmail(email) || !InputValidator.isValidName(name)) {
            System.out.println("Invalid email or name format");
            return;
        }

        try {
            Participant participant = new Participant(name, email);
            participantService.addParticipant(participant);
            System.out.println("Participant successfully added");
        } catch (Exception e) {
            System.out.println("Invalid data");
        }
    }

    public void updateParticipant() {
        viewAllParticipants();
        System.out.println("Enter participant index to update:");
        int index = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new name:");
        String name = scanner.nextLine();

        System.out.println("Enter new email:");
        String email = scanner.nextLine();

        if(!InputValidator.isValidEmail(email) || !InputValidator.isValidName(name)) {
            System.out.println("Invalid email or name format");
            return;
        }

        Participant participant = new Participant(name, email);
        participantService.updateParticipant(index - 1, participant);
        System.out.println("Participant updated successfully");
    }

    public void unregisterFromEvent() {
        viewAllParticipants();
        System.out.println("Enter event index to unregister from:");
        int eventIndex = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your email");
        String email = scanner.nextLine();

        if(!InputValidator.isValidEmail(email)) {
            System.out.println("Invalid email format");
            return;
        }

        Participant participant = participantService.findParticipantByEmail(email);
        if(participant == null) {
            System.out.println("Participant not found, you must be registred from this event first");
            return;
        }
        Event event = eventService.getAllEvents().get(eventIndex - 1 );
        registrationService.unregisterParticipant(event, participant);

    }

    private void deleteParticipant() {
        viewAllParticipants();
        System.out.println("Enter participant index to delete:");
        int index = scanner.nextInt();
        participantService.deleteParticipant(index);
        System.out.println("Participant deleted successfully.");
    }

    // generate reports

    private void generateNextWeekReport() {
        System.out.println("Report for next week");
        List<Event> events = EventService.findNextWeekEvents();
        for (Event event : events) {
            System.out.println("Event:");
            System.out.println(event);
            System.out.println("Inacriptions for this event:");
            List<Participant> participants = registrationService.getRegistrationsForEvent(event);
            for (Participant participant : participants) {
                System.out.println(participant);
            }
        }
    }

    private void generatePreviousWeekReport() {
        System.out.println("Report for previous week");
        List<Event> events = EventService.findPreviousWeekEvents();
        for (Event event : events) {
            System.out.println("Event:");
            System.out.println(event);
            System.out.println("Inacriptions for this event:");
            List<Participant> participants = registrationService.getRegistrationsForEvent(event);
            for (Participant participant : participants) {
                System.out.println(participant);
            }
        }
    }
    
}
