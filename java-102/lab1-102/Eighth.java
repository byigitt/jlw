import java.util.Scanner;

public class Eighth {
    public static void main(String args[]) {
        int duplicate;

        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter a word: ");
        String word = keyboard.nextLine();
        
        System.out.print("Enter a integer: ");
        duplicate = keyboard.nextInt();
        
        for (int i = 0; i < duplicate; i++) {
            System.out.print(word);
        };

        keyboard.close();
    }
}
