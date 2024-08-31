package src.main.java.com.eventsystem.model;

public class Registration {
    private int participantIndex;
    private int eventIndex;

    public Registration(int participantIndex, int eventIndex) {
        this.participantIndex = participantIndex;
    }

    public Integer getParticipantIndex() {
        return participantIndex;
    }

    public Integer setParticipantIndex(int participantIndex) {
        return this.eventIndex = participantIndex;
    }

    public Integer getEventIndex() {
        return eventIndex;
    }

    public Integer setEventIndex(int eventIndex) {
        return this.eventIndex = eventIndex;
    }

    @Override
    public String toString() {
        return "Event{" +
                "participantIndex='" + participantIndex + '\'' +
                ", eventIndex='" + eventIndex + '\'' +
                '}';
    }
}
