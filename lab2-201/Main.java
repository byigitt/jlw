import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int selection;
        Reservations reservations = new Reservations();
        Scanner keyboard = new Scanner(System.in);

        do {
            String flightNumber = "";
            String personName = "";

            System.out.println("-------------------");
            System.out.println("Enter the number from the menu");
            System.out.println("1. Reserve a ticket");
            System.out.println("2. Cancel reservation");
            System.out.println("3. Check reservation");
            System.out.println("4. List all reservations");
            System.out.println("5. Exit");
            System.out.println("-------------------\n");
        
            selection = keyboard.nextInt();
            
            if (selection >= 1 && selection < 4) {   
                System.out.print("Enter the flight number: ");
                flightNumber = keyboard.next();
                System.out.print("Enter the person name: ");
                personName = keyboard.next();   
            };
            
            switch (selection) {
                case 1:
                    reservations.reserve(flightNumber, personName);
                    break;
                case 2:
                    reservations.cancelReservation(flightNumber, personName);
                    break;
                case 3:
                    reservations.checkReservation(flightNumber, personName);
                    break;
                case 4:
                    reservations.listAllReservations();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid selection");
                    break;
            }
        } while (selection != 5);
        
        keyboard.close();
    }
}
