package src.main.java.com.eventsystem.service;

import src.main.java.com.eventsystem.model.Event;
import src.main.java.com.eventsystem.model.Participant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrationService {
    private Map<Event, List<Participant>> registrations = new HashMap<>();

    public void registerParticipant(Event event, Participant participant) {
        registrations.computeIfAbsent(event, k -> new ArrayList<>()).add(participant);
    }

    public void unregisterParticipant(Event event, Participant participant) {
        if (registrations.containsKey(event)) {
            registrations.get(event).remove(participant);
        }
    }

    public List<Participant> getRegistrationsForEvent(Event event) {
        return registrations.getOrDefault(event, new ArrayList<>());
    }

    public List<Event> getEventsForParticipant(Participant participant) {
        List<Event> events = new ArrayList<>();
        for (Map.Entry<Event, List<Participant>> entry : registrations.entrySet()) {
            if (entry.getValue().contains(participant)) {
                events.add(entry.getKey());
            }
        }
        return events;
    }
}

