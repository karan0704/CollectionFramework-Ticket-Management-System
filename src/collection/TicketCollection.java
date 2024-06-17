package collection;

import modelTicket.TicketModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TicketCollection {
    private List<TicketModel> tickets;
    private int nextTicketID;

    public TicketCollection() {
        tickets = new ArrayList<>();
        nextTicketID = 1;
    }

    public int generateNextTicketID() {
        return nextTicketID++;
    }

    public void addTicket(TicketModel ticket) {
        tickets.add(ticket);
    }

    public List<TicketModel> getAllTickets() {
        return tickets;
    }

    public List<TicketModel> getAllTicketsSortedById() {
        List<TicketModel> sortedTickets = new ArrayList<>(tickets);
        Collections.sort(sortedTickets, Comparator.comparingInt(TicketModel::getTicketID));
        return sortedTickets;
    }

    public List<TicketModel> getAllTicketsSortedByCustomerName() {
        List<TicketModel> sortedTickets = new ArrayList<>(tickets);
        Collections.sort(sortedTickets, Comparator.comparing(TicketModel::getCustomerName));
        return sortedTickets;
    }

    public TicketModel searchTicketByTitle(String title) {
        for (TicketModel ticket : tickets) {
            if (ticket.getTicketTitle().equalsIgnoreCase(title)) {
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

    public boolean deleteTicketBySixDigitNumber(int sixDigitTicketNumber) {
        return tickets.removeIf(ticket -> ticket.getSixDigitTicketNumber() == sixDigitTicketNumber);
    }
}