package src.main.java.com.eventsystem.service;

import java.util.ArrayList;
import java.util.List;

import src.main.java.com.eventsystem.model.Event;

public class RegistrationService {
    private List<Event> registrations = new ArrayList<Event>();

    public void addRegistration(Event registration) {
        registrations.add(registration);
    };
}
