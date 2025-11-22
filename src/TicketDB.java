import java.util.*;

public class TicketDB {
    private PriorityQueue<Ticket> ticketDB;

    public void showAll() {
        Iterator<Ticket> it = ticketDB.iterator();
        while (it.hasNext()) {
            System.out.printf("");
        }
    }
}
