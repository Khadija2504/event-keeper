package src.main.java.com.eventsystem.service;
import src.main.java.com.eventsystem.model.Participant;
import java.util.ArrayList;
import java.util.List;

public class ParticipantService {
    private List<Participant> participants = new ArrayList<>();

    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    public void updateParticipant(int index, Participant participant) {
        participants.set(index, participant);
    }

    public void deleteParticipant(int index) {
        participants.remove(index);
    }

    public List<Participant> getAllParticipants() {
        return participants;
    }

    public Participant findParticipantByEmail(String email) {
        return participants.stream()
                .filter(p -> p.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }
}