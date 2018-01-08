package sda.training.system.erp.view1;

import java.util.Scanner;

import static sda.training.system.erp.view1.NewTicketsOrder.menu;

public class MenuMethods extends AvailableTickets {

    protected static Scanner scanner = new Scanner(System.in);
    protected static Scanner scannerForString = new Scanner(System.in);
    private static int theMostExpensive = 0;
    private static int midPrice = 0;
    private static int cheapPrice = 0;
    private static int totalPrice = 0;
    public static final String BLUE = "\033[1;34m";
    public static final String RESET = "\033[0m";

    protected static void orderTicketMethod(int seatsToChoose[][]) {

        AvailableTickets availableTickets = new AvailableTickets();
        System.out.println("Choose a free seat marked '0' from the below");
        availableTickets.displayAvailableTickets(seatsToChoose);

        System.out.println("\n" + "Type a row you would like to choose: ");

        int a = scanner.nextInt();
        System.out.println("Type which seat in the choosen row: ");
        int b = scanner.nextInt();

        if (((a > 0) && (a <= 5)) && ((b > 0) && (b <= 5))) {
            System.out.println("You have choosen a row: " + a + "\n" + "and a seat number: " + b);
            if (((seatsToChoose[a - 1][b - 1]) == 0)) {
                seatsToChoose[a - 1][b - 1] = 1;
                availableTickets.displayAvailableTickets(seatsToChoose);
                if (a == 1) {
                    System.out.println("\n" + "The price for the choosen seat is 100 zl");
                    if (a == 1)
                        theMostExpensive = theMostExpensive + 100;
                } else if ((a > 1) && (a <= 4)) {
                    System.out.println("\n" + "The price for the choosen seat is 60 zl");
                    if ((a > 1) && (a <= 4))
                        midPrice = midPrice + 60;
                } else if ((a > 4) && (a <= 5)) {
                    System.out.println("\n" + "The price for the choosen seat is 20 zl");
                    if ((a > 4) && (a <= 5))
                        cheapPrice = cheapPrice + 20;
                }
                System.out.println("\n" + "Would you buy a ticket for chosen seat? Confirm y/n");
                String t = scannerForString.nextLine();
                if (t.equalsIgnoreCase("y")) {
                    System.out.println("You have just bought a ticket" + "\n" + "Would you like to buy another one? Confirm y/n");
                    String u = scannerForString.nextLine();
                    if (t.equalsIgnoreCase("y")) {
                        totalPrice = theMostExpensive + midPrice + cheapPrice;
                    } else {
                        //totalPrice = totalPrice;
                    }
                    if (u.equalsIgnoreCase("y")) {
                        menu(seatsToChoose);
                    } else {
                        if ((totalPrice > 0) && (t.equalsIgnoreCase("y")))
                            theEnd();
                    }
                } else {
                    if ((totalPrice > 0) && (t.equalsIgnoreCase("y")))
                        theEnd();
                    else
                        System.out.println("You have canceled the purchase of the chosen ticket -" + BLUE + "So far you have spent: "
                                + totalPrice + " zl" + RESET + "\n" + "Thank you for visiting, Goodbye");
                }
            } else {
                System.out.println(BLUE + "Sorry, but the seat is already taken" + RESET);
                menu(seatsToChoose);
            }
        } else {
            System.out.println(BLUE + "There is no such a seat in the room - please choose a right one" + RESET);
            menu(seatsToChoose);
        }
    }

    protected static void showPrice(int seatsToChoose[][]) {
        System.out.println("The seats in the first row cost 100 zł\n" +
                "The seats from the second to the third row cost 60 zł\n" +
                "The seats from the fourth to the fifth row cost 20 zł. \n");
        System.out.println("Type any number to get back to the main menu ");
        int number1 = scanner.nextInt();
        menu(seatsToChoose);
    }

    protected static void theEnd() {
        if (totalPrice > 0) {
            System.out.println("Thank you for shopping. " + BLUE + "You spent together: " + totalPrice + " zl" + RESET + " Goodbye");
        } else {
            System.out.println("You have not made any purchase. Thank you for visiting. Goodbye");
        }
    }
}
