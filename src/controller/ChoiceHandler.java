package controller;

import collection.TicketCollection;
import modelTicket.TicketModel;

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
            System.out.println("4. Delete a ticket");
            System.out.println("5. Exit");

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
                    deleteTicket();
                    break;
                case 5:
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

        int choice = getChoice();
        switch (choice) {
            case 1:
                for (TicketModel t : collection.getAllTicketsSortedById()) {
                    System.out.println(t);
                }
                break;
            case 2:
                for (TicketModel t : collection.getAllTicketsSortedByCustomerName()) {
                    System.out.println(t);
                }
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    private void searchTicket() {
        System.out.println("\nSearch Tickets:");
        System.out.println("1. By Ticket Title");
        System.out.println("2. By Ticket ID");

        int choice = getChoice();
        switch (choice) {
            case 1:
                System.out.print("Enter Ticket Title: ");
                scanner.nextLine(); // Consume newline
                String title = scanner.nextLine();
                TicketModel ticketByTitle = collection.searchTicketByTitle(title);
                if (ticketByTitle != null) {
                    System.out.println(ticketByTitle);
                } else {
                    System.out.println("Ticket not found.");
                }
                break;
            case 2:
                System.out.print("Enter Ticket ID: ");
                int ticketID = getChoice();
                TicketModel ticketByID = collection.searchTicketByID(ticketID);
                if (ticketByID != null) {
                    System.out.println(ticketByID);
                } else {
                    System.out.println("Ticket not found.");
                }
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
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