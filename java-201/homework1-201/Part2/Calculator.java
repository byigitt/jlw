import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Stack;
import java.util.List;

public class Calculator {
    public static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String[] args) {
        String[] operands = { "+", "-", "*", "/" };
        String input = "";
        
        Scanner sc = new Scanner(System.in);
        
        while (input != "E") {
            input = sc.nextLine();

            if (input.equals("E")) {
                System.out.println("Exiting.");
                break;
            }

            try {
                stack.push(Integer.parseInt(input));
            } catch (NumberFormatException er) {
                List<String> operandList = Arrays.asList(operands);

                if (input.length() == 1 && operandList.contains(input)) {
                    char c = input.charAt(0);
                    int a = 0;
                    int b = 0;

                    try {
                        a = stack.pop();
                        b = stack.pop();
                    } catch (EmptyStackException e) {
                        System.out.println("Please write integers before calling an operator");
                        continue;
                    }

                    int result = 0;
                    switch (c) {
                        case '+':
                            result = b + a;
                            break;
                        case '-':
                            result = b - a;
                            break;
                        case '*':
                            result = b * a;
                            break;
                        case '/':
                            result = b / a;
                            break;
                    }

                    stack.push(result);
                    System.out.println("Result is " + result);
                } else {
                    System.out.println("Invalid operator");
                    continue;
                }
            }
        }

        sc.close();
    }
}
