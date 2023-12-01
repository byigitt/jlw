import java.util.Scanner;

public class Sixth {
    public static void main(String args[]) {
        int grade, select = 4;
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter your grade: ");
        grade = keyboard.nextInt();

        if (grade >= 90 && grade <= 100) {
            select = 0;
        } else if (grade >= 80 && grade <= 89) {
            select = 1;
        } else if (grade >= 70 && grade <= 79) {
            select = 2;
        } else if (grade >= 60 && grade <= 69) {
            select = 3;
        } else if (grade <= 59) {
            select = 4;
        };

        switch (select) {
            case 0:
                System.out.println("Your letter grade is: AA");
                break;
            case 1:
                System.out.println("Your letter grade is: BB");
                break;
            case 2:
                System.out.println("Your letter grade is: CC");
                break;
            case 3:
                System.out.println("Your letter grade is: DD");
                break;
            case 4:
                System.out.println("Your letter grade is: FF");
                break;
            default:
                System.out.println("No grade found.");
        };
        
        keyboard.close();
    }
}
