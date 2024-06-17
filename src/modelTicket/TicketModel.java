package modelTicket;

public class TicketModel {
    private int ticketID;
    private String customerName;
    private int sixDigitTicketNumber;
    private String ticketTitle;
    private String ticketIssue;
    private String ticketStatus; // Added ticket status variable

    public TicketModel() {
        this.ticketStatus = "open"; // Default status is "open"
    }

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

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    @Override
    public String toString() {
        return "TicketModel{" +
                "ticketID=" + ticketID +
                ", customerName='" + customerName + '\'' +
                ", sixDigitTicketNumber=" + sixDigitTicketNumber +
                ", ticketTitle='" + ticketTitle + '\'' +
                ", ticketIssue='" + ticketIssue + '\'' +
                ", ticketStatus='" + ticketStatus + '\'' +
                '}';
    }
}