import java.util.Scanner;
import java.lang.Math;

public class Third {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        
        String state = "";
        float minimum = 0, maximum = 0;

        while (!state.equals("x")) {
            System.out.println("Enter an integer: ");
            state = keyboard.next();
            
            if (!state.equals("x")) {
                float num = Float.parseFloat(state);
                if (num < minimum || minimum == 0)
                    minimum = num;
                
                if (num > maximum || maximum == 0)
                    maximum = num;
            };
        };
        
        System.out.print("Result: " + Math.pow(Math.sin(maximum), minimum));
        keyboard.close();
    }
}