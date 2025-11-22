import java.util.*;
import java.time.LocalDate;

public class Ticket implements Comparable<Ticket> {
    private final LocalDate date; // Date posted
    private final String details;
    private final User associatedUser;
    private String staffResponse;
    private String status;

    public Ticket(User user, String details) {
        associatedUser = user;
        date = LocalDate.now();
        this.details = details;
        staffResponse = "";
        status = "RAISED";
    }

    public User getUser() {
        return associatedUser;
    }

    public String getDetails() {
        return details;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStaffResponse() {
        return staffResponse;
    }

    public String getStatus() {
        return status;
    }

    public void updateStatus(String staffMessage, String newStatus) {
        this.staffResponse = staffMessage;
        this.status = newStatus;
        associatedUser.addNotification("TICKET UPDATE: " + LocalDate.now());
    }

    @Override
    public int compareTo(Ticket other) {
        return this.getDate().compareTo(other.getDate());
    }
}
