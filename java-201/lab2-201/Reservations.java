import java.util.LinkedList;

public class Reservations {
    Ticket ticket;
    private LinkedList<Ticket> tickets = new LinkedList<Ticket>();

    private class Ticket {
        public String flightNumber;
        public String name;
    };

    public void reserve(String number, String name) {
        Ticket ticket = new Ticket();
        ticket.flightNumber = number;
        ticket.name = name;
        tickets.add(ticket);
        System.out.println("Reservation is added successfully\n");
    };

    public void cancelReservation(String number, String name) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).flightNumber.equals(number) && tickets.get(i).name.equals(name)) {
                tickets.remove(i);
                System.out.println("Flight is removed successfully\n");
                return;
            }
        };

        System.out.println("No flight is found\n");
    };

    public void checkReservation(String number, String name) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).flightNumber.equals(number) && tickets.get(i).name.equals(name)) {
                System.out.println("Flight exists\n");
                return;
            }
        };

        System.out.println("No flight is found\n");
    };

    public void listAllReservations() {
        if (tickets.size() < 1) {
            System.out.println("No flight found\n");
            return;
        };

        for (int i = 0; i < tickets.size(); i++) {
            System.out.println((i + 1) + ": Flight Number: " + tickets.get(i).flightNumber + ", Person: " + tickets.get(i).name);
        };
        
        System.out.print("\n");
    };
}