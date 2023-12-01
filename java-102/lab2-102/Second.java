import java.util.Scanner;

public class Second {
    static float calculate(float num1, float num2, String operator) {
        float result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        };

        return result;
    };

    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Enter the string of operations: ");
        String operators = keyboard.next();

        if (operators.matches(".*\\d.*")) {
            System.out.println("Invalid string");
        } else {
            System.out.println("Enter the integer: ");
            String num = keyboard.next();

            if (operators.length() + 1 == num.length()) {
                String[] operatorArray = operators.split("");
                float[] numbersArray = new float[num.length()];
                for (int i = 0; i < num.length(); i++) {
                    numbersArray[i] = num.charAt(i) - '0';
                };

                float currentResult = 0;
                currentResult = calculate(numbersArray[0], numbersArray[1], operatorArray[0]);

                for (int i = 1; i < operators.length(); i++) {
                    currentResult = calculate(currentResult, numbersArray[i + 1], operatorArray[i]);
                };

                System.out.println("Result: " + currentResult);
            } else {
                System.out.println("The length of the integer is inappropriate");
            }
        }

        keyboard.close();
    }
}