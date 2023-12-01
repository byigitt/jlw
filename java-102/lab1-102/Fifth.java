import java.util.Scanner;

public class Fifth {
    public static void main(String args[]) {
        int balance, price;
        int MINIMUM_BALANCE = 16;

        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter your balance: ");
        balance = keyboard.nextInt();

        if (balance <= MINIMUM_BALANCE) {
            System.out.println("No items available for your budget.");
        } else {
            System.out.print("You can buy meat, juice, milk, apples or chicken. Which one do you choose?: ");
            String selection = keyboard.next();

            if (selection.equals("Meat")) {
                price = 70;
            } else if (selection.equals("Juice")) {
                price = 19;
            } else if (selection.equals("Milk")) {
                price = 22;
            } else if (selection.equals("Apples")) {
                price = 16;
            } else if (selection.equals("Chicken")) {
                price = 50;
            } else {
                price = -1;
            };

            if (price > 0) {
                if (balance >= price) {
                    balance = balance - price;
                    System.out.println("Your new balance is " + balance + ". Enjoy!");
                } else {
                    System.out.println("Your budget is not enough!");
                }
            } else {
                System.out.println("There is no item with that name.");
            };
        };

        keyboard.close();
    }
}