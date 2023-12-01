public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Ali", "Irmak", 36, 5000);
        Person person2 = new Person("Veli", "Kaya", 61, 3500);
        
        Mortgage mortgage1 = new Mortgage();
        Vehicle vehicle1 = new Vehicle();
        Holiday holiday1 = new Holiday();

        mortgage1.restructuringLoan(12, person1, 1244.00,1244.00,1244.00,1244.00);
        vehicle1.restructuringLoan(24, person1, 800.00, 800.00, 800.00, 800.00, 800.00, 800.00, 800.00);
        holiday1.restructuringLoan(24, person2, 650.00, 650.00, 650.00, 650.00, 650.00, 650.00, 650.00);
    };
}
