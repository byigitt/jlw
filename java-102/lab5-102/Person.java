public class Person {
    private String name;
    private String surname;
    private int age;
    private double salary;

    public Person(String name, String surname, int age, double salary) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
    };

    public static void main(String[] args) {
        Person person1 = new Person("Ali", "Irmak", 36, 5000);
        Person person2 = new Person("Veli", "Kaya", 61, 3500);

        person1.applyForLoan(person1, 100000,6, "Mortgage");
        person1.applyForLoan(person1, 10000, 6, "Mortgage");
        person2.applyForLoan(person2, 50000, 12, "Vehicle");
        person2.applyForLoan(person2, 50000, 24, "Vehicle");
        person1.applyForLoan(person2, 50000, 12, "Holiday");
        person1.applyForLoan(person2, 50000, 24, "Holiday");
    };
       
    public String getName() {
        return name;
    };

    public void setName(String name) {
        this.name = name;
    };
    
    public String getSurname() {
        return surname;
    };

    public void setSurname(String surname) {
        this.surname = surname;
    };

    public int getAge() {
        return age;
    };

    public void setAge(int age) {
        this.age = age;
    };

    public double getSalary() {
        return salary;
    };

    public void setSalary(double salary) {
        this.salary = salary;
    };

    public void applyForLoan(Person p, int capital, int month, String loanType) {
        double interest = 0;

        if (loanType.equals("Mortgage")) {
            Mortgage mortage = new Mortgage();
            interest = mortage.calculateInterest(capital, p);
        } else if (loanType.equals("Vehicle")) {
            Vehicle vehicle = new Vehicle();
            interest = vehicle.calculateInterest(capital, p);
        } else if (loanType.equals("Holiday")) {
            Holiday holiday = new Holiday();
            interest = holiday.calculateInterest(capital, p);
        };
        
        double installment = interest / month; 
        if (p.getSalary() < installment) {
            printCreditResult(false, capital, p, installment, month, loanType);
        } else {
            printCreditResult(true, capital, p, installment, month, loanType);
        };
    };
    
    public void printCreditResult(Boolean b, int capital, Person person, double installment, int month, String loanType) {
        if (b) {
            System.out.println("Congratulations " + person.getName() + " " + person.getSurname() + "!");
            System.out.println("Your " + loanType + " credit application: " + capital + " has been accepted!");
            System.out.println("Your monthly payment will be: " + installment + " x " + month);
            System.out.println("Repayment costs = " + installment * month);
        } else {
            System.out.println("We are so sorry " + person.getName() + " " + person.getSurname() + "!");
            System.out.println("Your " + loanType + " credit application " + capital + " has been rejected because your salary is lower than the installments!");
            System.out.println("Your salary: " + person.getSalary() + " < " + installment);
        };
    };
};
