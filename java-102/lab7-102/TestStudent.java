import java.util.Scanner;

public class TestStudent {
    public static void main(String[] args) {
        String name;
        double credit;
        long ID;
        Student st;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter student's first name");
        name = scan.nextLine();

        // a. Read the student’s name and create st
        st = new Student(name);
        System.out.println("Student " + st.getName() + ":");
        System.out.println(st);

        System.out.println("\nEnter initial credit");
        // b. Read the initial credit for the Student and create a new Student
        credit = scan.nextDouble();
        st = new Student(credit, name);
        System.out.println("Student " + st.getName() + ":");
        System.out.println(st);

        // c. Prompt for and read the ID for the Student and create a new Student with ID
        System.out.println("\nEnter Student number");
        ID = scan.nextLong();
        st = new Student(credit, name, ID);
        System.out.println("Student " + st.getName() + " (" + st.getID() + "):");
        System.out.println(st);

        System.out.print("\nIncreasing credit by 100, credit is now ");
        // d. Increase the credit by 100 and prints the new credit
        st.increase(100);
        System.out.println(st.getCredit());

        System.out.print("\nDecreasing 25 with 2 as bonus, credit is now ");
        // e. Decrease 25 with 2 as bonus and print the new credit
        st.decrease(25, 2);
        System.out.println(st.getCredit());

        scan.close();
    }
}
