import java.util.Scanner;

public class Third {
    public static void main(String args[]) {
        double radius;
        double height;

        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Please enter radius: ");
        radius = keyboard.nextDouble();
        
        System.out.print("Please enter height: ");
        height = keyboard.nextDouble();

        keyboard.close();
        System.out.println("The volume of the cone is: " + (int)((3.14) * height * radius * radius) / 3);
    }
}