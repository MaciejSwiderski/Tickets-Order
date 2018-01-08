package sda.training.system.erp.view1;

public class NewTicketsOrder extends MenuMethods {

    protected static void menu(int seatsToChoose[][]) {

        System.out.println("Welcome to the ticket reservation service" + "\n" + "Type 1 to 3 to continue");
        System.out.println("1 - Tickets order " + "\n" + "2 - Prices" + "\n" + "3 - The end ");
        int number = scanner.nextInt();

        switch (number) {
            case 1:
                orderTicketMethod(seatsToChoose);
                break;
            case 2:
                showPrice(seatsToChoose);
                break;
            case 3:
                theEnd();
                break;
            default:
                System.out.println(BLUE + "Choose a right number from the menu" + RESET);
                menu(seatsToChoose);
                break;
        }
    }
}
