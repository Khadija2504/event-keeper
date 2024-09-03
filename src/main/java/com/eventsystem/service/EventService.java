package src.main.java.com.eventsystem.service;

import src.main.java.com.eventsystem.model.Event;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EventService {
    private static List<Event> events = new ArrayList<>();

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

    public List<Event> FindEventByType(String type) {
        List<Event> eventsByType = new ArrayList<>();
        for (Event event : events) {
            if (event.getType().equals(type)) {
                eventsByType.add(event);
            }
        }
        return eventsByType;
    }

    public List<Event> FindEventByLocation(String location) {
        List<Event> eventsByLocation = new ArrayList<>();
        for (Event event : events) {
            if (event.getLocation().equals(location)) {
                eventsByLocation.add(event);
            }
        }
        return eventsByLocation;
    }

    public static List<Event> findEventsByDate(Date date) {
        List<Event> eventsByDate = new ArrayList<>();
        for (Event event : events) {
            if (event.getDate().equals(date)) {
                eventsByDate.add(event);
            }
        }
        return eventsByDate;
    }

    public static List<Event> findNextWeekEvents() {
        List<Event> nextWeekEvents = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date startDate = calendar.getTime();
        
        for (Event event : events) {
            Date eventDate = event.getDate();
            if (eventDate.before(startDate) && eventDate.after(currentDate)) {
                nextWeekEvents.add(event);
            }
        }
        return nextWeekEvents;
    }

    public static List<Event> findPreviousWeekEvents() {
        List<Event> previousWeekEvents = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        Date startDate = calendar.getTime();
        
        for (Event event : events) {
            Date eventDate = event.getDate();
            if (eventDate.after(startDate) && eventDate.before(currentDate)) {
                previousWeekEvents.add(event);
            }
        }
        return previousWeekEvents;
    }
    
}
