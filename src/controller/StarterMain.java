package controller;

import collection.TicketCollection;

public class StarterMain {
    public static void main(String[] args) {
        TicketCollection collection = new TicketCollection();
        ChoiceHandler choiceHandler = new ChoiceHandler(collection);
        choiceHandler.displayMenu();
    }
}