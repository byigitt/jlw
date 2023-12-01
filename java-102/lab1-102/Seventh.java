import java.util.Scanner;

public class Seventh {
    public static void main(String args[]) {
        char selected = 'm';
        char guessed = 'a';
        int tries = 0;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("I have guessed a letter in the English alphabet.");

        while (guessed != selected) {
            tries++;
            System.out.print("Guess the letter: ");
            guessed = keyboard.next().charAt(0);

            if ((int)selected > (int)guessed) {
                System.out.println("Go forward in the alphabet");
            } else if ((int)selected < (int)guessed) {
                System.out.println("Go backward in the alphabet");
            }
        };

        System.out.println(selected + " is correct! You guessed correctly after " + tries + " tries!");
        keyboard.close();
    }
}
