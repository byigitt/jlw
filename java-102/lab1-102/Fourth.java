
import java.util.Scanner;

public class Fourth {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter the date in dd.mm.yyyy format: ");
        String dateString = keyboard.next();

        keyboard.close();

        String[] dateArray = dateString.split("\\.");
        String newDate = dateArray[1] + "/" + dateArray[0] + "/" + dateArray[2];

        System.out.println("The date you entered is: " + newDate);
    }
}