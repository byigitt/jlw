import java.util.Scanner;

public class First {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Enter string1: ");
        String string1 = keyboard.next();

        System.out.println("Enter string2: ");
        String string2 = keyboard.next();

        if (string1.equalsIgnoreCase(string2)) {
            System.out.println(string1 + string2);  
        } else {
            if (string1.compareToIgnoreCase(string2) < 0) {
                System.out.println(string1 + " comes first");  
            } else {
                System.out.println(string2 + " comes first"); 
            };
        };

        keyboard.close();
    }
}