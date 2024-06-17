package controller;

import collection.TicketCollection;
import modelTicket.TicketModel;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ChoiceHandler {
    private final TicketCollection collection;
    private final Scanner scanner;

    public ChoiceHandler(TicketCollection collection) {
        this.collection = collection;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Create a new ticket");
            System.out.println("2. View all tickets");
            System.out.println("3. Search for a ticket");
            System.out.println("4. Change ticket status");
            System.out.println("5. Delete a ticket");
            System.out.println("6. Exit");

            int choice = getChoice();

            switch (choice) {
                case 1:
                    createTicket();
                    break;
                case 2:
                    viewAllTickets();
                    break;
                case 3:
                    searchTicket();
                    break;
                case 4:
                    changeTicketStatus();
                    break;
                case 5:
                    deleteTicket();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private int getChoice() {
        try {
            System.out.print("Enter your choice: ");
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Consume newline
            return -1;
        }
    }

    private void createTicket() {
        int ticketID = collection.generateNextTicketID();
        TicketInfoFiller filler = new TicketInfoFillerImpl();
        TicketModel ticket = filler.fillTicketInfo(ticketID);
        collection.addTicket(ticket);
        System.out.println("Ticket created successfully.");
    }

    private void viewAllTickets() {
        System.out.println("\nView Tickets:");
        System.out.println("1. Sorted by Ticket ID");
        System.out.println("2. Sorted by Customer Name");

        int viewChoice = getChoice();
        switch (viewChoice) {
            case 1:
                displayTickets(collection.getAllTicketsSortedById());
                break;
            case 2:
                displayTickets(collection.getAllTicketsSortedByCustomerName());
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    private void displayTickets(Iterable<TicketModel> tickets) {
        System.out.printf("%-10s | %-20s | %-15s | %-20s | %-30s | %-10s%n",
                "Ticket ID", "Customer Name", "Ticket Number", "Ticket Title", "Ticket Issue", "Ticket Status");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");

        for (TicketModel ticket : tickets) {
            System.out.printf("%-10d | %-20s | %-15d | %-20s | %-30s | %-10s%n",
                    ticket.getTicketID(), ticket.getCustomerName(), ticket.getSixDigitTicketNumber(),
                    ticket.getTicketTitle(), ticket.getTicketIssue(), ticket.getTicketStatus());
        }
    }

    private void searchTicket() {
        System.out.println("\nSearch Tickets:");
        System.out.println("1. By Ticket Title");
        System.out.println("2. By Ticket ID");

        int searchChoice = getChoice();
        switch (searchChoice) {
            case 1:
                System.out.print("Enter Ticket Title: ");
                scanner.nextLine(); // Consume newline
                String title = scanner.nextLine();
                TicketModel ticketByTitle = collection.searchTicketByTitle(title);
                if (ticketByTitle != null) {
                    displayTickets(Collections.singletonList(ticketByTitle));
                } else {
                    System.out.println("Ticket not found.");
                }
                break;
            case 2:
                System.out.print("Enter Ticket ID: ");
                int ticketID = getChoice();
                TicketModel ticketByID = collection.searchTicketByID(ticketID);
                if (ticketByID != null) {
                    displayTickets(Collections.singletonList(ticketByID));
                } else {
                    System.out.println("Ticket not found.");
                }
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    private void changeTicketStatus() {
        System.out.print("Enter Ticket ID to change status: ");
        int ticketID = getChoice();
        TicketModel ticket = collection.searchTicketByID(ticketID);
        if (ticket != null) {
            String currentStatus = ticket.getTicketStatus();
            String newStatus = currentStatus.equals("open") ? "closed" : "open";
            ticket.setTicketStatus(newStatus);
            System.out.println("Ticket status changed successfully.");
        } else {
            System.out.println("Ticket not found.");
        }
    }

    private void deleteTicket() {
        System.out.print("Enter the 6-digit Ticket Number to delete: ");
        int sixDigitNumber = getChoice();
        boolean deleted = collection.deleteTicketBySixDigitNumber(sixDigitNumber);
        if (deleted) {
            System.out.println("Ticket deleted successfully.");
        } else {
            System.out.println("Ticket not found.");
        }
    }
}