import java.util.Stack;
import java.util.Arrays;
import java.lang.String;

public class postfixToInfix {
    public static void main(String[] args) {
        String postfix = "1234567891+-*+-*+-*";
        System.out.println(pti(postfix));
    }

    public static String pti(String postfix) {
        Stack<String> stack = new Stack<>();
        String[] operators = {"+", "-", "*", "/"};
    
        for (int i = 0; i < postfix.length(); i++) {
            String c = String.valueOf(postfix.charAt(i));
            if (Arrays.asList(operators).contains(c)) {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String expression = "(" + operand1 + c + operand2 + ")";
                stack.push(expression);
            } else {
                stack.push(c + "");
            }
        }
    
        return stack.pop();
    }
}