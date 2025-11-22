import org.junit.Test;

import static org.junit.Assert.*;

public class TicketTest {

    @Test
    public void updateStatusTest() {
        Ticket t = new Ticket(new User("John"), "Cannot sign up.");
        t.updateStatus(
                "The system indicates you are already a user. Try signing in.",
                "RESPONDED");

        // POSITIVE TESTS
        assertEquals(
                "The system indicates you are already a user. Try signing in.",
                t.getStaffResponse());
        assertEquals("RESPONDED", t.getStatus());
        assertEquals(1, t.getUser().getNumNotif());
    }

    @Test
    public void updateStatusNull() {
        Ticket t = new Ticket(
                new User("John"),
                "Website takes too long to load.");

        t.updateStatus(
                "Servers are currently under maintenance. Try again later.",
                "RESOLVED");

        // NEGATIVE TESTS using equivalence classes
        assertNotEquals(null, t.getStaffResponse());
        assertNotEquals(null, t.getStatus());

        // POSITIVE TESTS
        assertEquals("RESOLVED", t.getStatus());
        assertEquals(
                "Servers are currently under maintenance. Try again later.",
                t.getStaffResponse());
        assertEquals(1, t.getUser().getNumNotif());
    }


    @Test
    public void updateStatusEmptyString() {
        Ticket t = new Ticket(
                new User("John"),
                "Website takes too long to load.");

        t.updateStatus(
                "Servers are currently under maintenance. Try again later.",
                "RESOLVED");

        // NEGATIVE TESTS
        assertNotEquals("", t.getStaffResponse());
        assertNotEquals("", t.getStatus());

        // POSITIVE TESTS
        assertEquals("RESOLVED", t.getStatus());
        assertEquals(
                "Servers are currently under maintenance. Try again later.",
                t.getStaffResponse());
        assertEquals(1, t.getUser().getNumNotif());
    }

    @Test
    public void updateStatusOneCharacter() {
        Ticket t = new Ticket(
                new User("John"),
                "Website takes too long to load.");

        t.updateStatus(
                "Servers are currently under maintenance. Try again later.",
                "RESOLVED");

        // NEGATIVE TESTS
        assert(t.getStaffResponse().length() > 1);
        assert(t.getStatus().length() > 1);

        // POSITIVE TESTS
        assertEquals("RESOLVED", t.getStatus());
        assertEquals(
                "Servers are currently under maintenance. Try again later.",
                t.getStaffResponse());
        assertEquals(1, t.getUser().getNumNotif());
    }

    @Test
    public void updateStatusWrongString() {
        Ticket t = new Ticket(
                new User("John"),
                "Website takes too long to load.");

        t.updateStatus(
                "Servers are currently under maintenance. Try again later.",
                "RESOLVED");

        // NEGATIVE TESTS
        assertNotEquals(
                "Servers are NOT currently under maintenance. Try again later.",
                t.getStaffResponse());

        assertNotEquals("RESPONDED", t.getStatus());

        // POSITIVE TESTS
        assertEquals("RESOLVED", t.getStatus());
        assertEquals(
                "Servers are currently under maintenance. Try again later.",
                t.getStaffResponse());
        assertEquals(1, t.getUser().getNumNotif());
    }

    @Test
    public void updateStatusWrongNotifCount() {
        Ticket t = new Ticket(
                new User("John"),
                "Website takes too long to load.");

        t.updateStatus(
                "Servers are currently under maintenance. Try again later.",
                "RESOLVED");

        assertNotEquals(-1, t.getUser().getNumNotif());
        assertNotEquals(0, t.getUser().getNumNotif());
        assertNotEquals(Integer.MAX_VALUE, t.getUser().getNumNotif());

        // POSITIVE TESTS
        assertEquals("RESOLVED", t.getStatus());
        assertEquals(
                "Servers are currently under maintenance. Try again later.",
                t.getStaffResponse());
        assertEquals(1, t.getUser().getNumNotif());
    }
}