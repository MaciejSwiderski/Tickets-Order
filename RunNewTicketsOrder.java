package sda.training.system.erp.view1;

public class RunNewTicketsOrder {

    public static void main(String[] args) {

        int seatsToChoose[][] = new int[5][5];
        NewTicketsOrder newTicketsOrder = new NewTicketsOrder();
        newTicketsOrder.menu(seatsToChoose);
    }
}
