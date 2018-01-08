package sda.training.system.erp.view1;

public class AvailableTickets {

    protected int[][] displayAvailableTickets(int seatsToChoose[][]) {

        System.out.println("SEAT TO CHOOSE");
        for (int row = 0; row < seatsToChoose.length; row++) {
            System.out.println();
            for (int col = 0; col < seatsToChoose[row].length; col++)
                System.out.print(seatsToChoose[row][col]+ "\t");
        }
        return seatsToChoose;
    }
}
