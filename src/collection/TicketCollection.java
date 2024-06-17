package collection;

import modelTicket.TicketModel;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;

public class TicketCollection {
    private final List<TicketModel> tickets;
    private int nextTicketID;

    public TicketCollection() {
        this.tickets = new ArrayList<>();
        this.nextTicketID = 1;
    }

    public int generateNextTicketID() {
        return nextTicketID++;
    }

    public void addTicket(TicketModel ticket) {
        tickets.add(ticket);
    }

    public List<TicketModel> getAllTicketsSortedById() {
        List<TicketModel> sortedTickets = new ArrayList<>(tickets);
        sortedTickets.sort(Comparator.comparingInt(TicketModel::getTicketID));
        return sortedTickets;
    }

    public List<TicketModel> getAllTicketsSortedByCustomerName() {
        List<TicketModel> sortedTickets = new ArrayList<>(tickets);
        sortedTickets.sort(Comparator.comparing(TicketModel::getCustomerName));
        return sortedTickets;
    }

    public TicketModel searchTicketByTitle(String title) {
        for (TicketModel ticket : tickets) {
            if (containsMatchingSubstring(ticket.getTicketTitle(), title, 4)) {
                return ticket;
            }
        }
        return null;
    }

    public TicketModel searchTicketByID(int ticketID) {
        for (TicketModel ticket : tickets) {
            if (ticket.getTicketID() == ticketID) {
                return ticket;
            }
        }
        return null;
    }

    public boolean deleteTicketBySixDigitNumber(int sixDigitNumber) {
        return tickets.removeIf(ticket -> ticket.getSixDigitTicketNumber() == sixDigitNumber);
    }

    private boolean containsMatchingSubstring(String source, String target, int minMatchLength) {
        if (source == null || target == null) {
            return false;
        }

        source = source.toLowerCase();
        target = target.toLowerCase();

        for (int i = 0; i <= source.length() - minMatchLength; i++) {
            String substring = source.substring(i, i + minMatchLength);
            if (target.contains(substring)) {
                return true;
            }
        }

        return false;
    }
}