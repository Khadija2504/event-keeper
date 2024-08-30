package src.main.java.com.eventsystem.service;

import src.main.java.com.eventsystem.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventService {
    private List<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        events.add(event);
    }

    public void deleteEvent(int index) {
        events.remove(index);
    }

    public void updateEvent(int index, Event event){
        events.set(index, event);
    }

    public List<Event> getAllEvents() {
        return events;
    }
}
