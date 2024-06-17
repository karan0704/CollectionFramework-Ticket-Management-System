package controller;

import modelTicket.TicketModel;
import numberGenerated.RandomSixDigitNumber;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicketInfoFillerImpl implements TicketInfoFiller {
    @Override
    public TicketModel fillTicketInfo(int ticketID) {
        Scanner scanner = new Scanner(System.in);
        TicketModel ticket = new TicketModel();
        ticket.setTicketID(ticketID);

        try {
            System.out.print("Enter Customer Name: ");
            ticket.setCustomerName(scanner.nextLine());

            System.out.print("Enter Ticket Title: ");
            ticket.setTicketTitle(scanner.nextLine());

            System.out.print("Enter Ticket Issue: ");
            ticket.setTicketIssue(scanner.nextLine());

            RandomSixDigitNumber randomSixDigitNumber = new RandomSixDigitNumber();
            ticket.setSixDigitTicketNumber(randomSixDigitNumber.getSixDigitNumber());

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter the correct data type.");
        }

        return ticket;
    }
}
