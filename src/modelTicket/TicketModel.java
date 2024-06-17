package modelTicket;

public class TicketModel {
    private int ticketID;
    private String customerName;
    private int sixDigitTicketNumber;
    private String ticketTitle;
    private String ticketIssue;

    // Getters and Setters
    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getSixDigitTicketNumber() {
        return sixDigitTicketNumber;
    }

    public void setSixDigitTicketNumber(int sixDigitTicketNumber) {
        this.sixDigitTicketNumber = sixDigitTicketNumber;
    }

    public String getTicketTitle() {
        return ticketTitle;
    }

    public void setTicketTitle(String ticketTitle) {
        this.ticketTitle = ticketTitle;
    }

    public String getTicketIssue() {
        return ticketIssue;
    }

    public void setTicketIssue(String ticketIssue) {
        this.ticketIssue = ticketIssue;
    }

    @Override
    public String toString() {
        return "TicketModel{" +
                "ticketID=" + ticketID +
                ", customerName='" + customerName + '\'' +
                ", sixDigitTicketNumber=" + sixDigitTicketNumber +
                ", ticketTitle='" + ticketTitle + '\'' +
                ", ticketIssue='" + ticketIssue + '\'' +
                '}';
    }
}