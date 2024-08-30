package src.main.java.com.eventsystem.model;

import java.util.Date;

public class Event {
    private String name;
    private String location;
    private Date date;
    private String type;

    public Event(String name, String location, Date date, String type) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.type = type;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", date=" + date +
                ", type='" + type + '\'' +
                '}';
    }
}

