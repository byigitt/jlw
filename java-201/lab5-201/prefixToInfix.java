import java.util.Stack;
import java.util.Arrays;
import java.lang.String;

public class prefixToInfix {
    public static void main(String[] args) {
        String prefix = "+-*+-*+-*1234567891";
        System.out.println(pti(prefix));
    }

    public static String pti(String prefix) {
        Stack<String> stack = new Stack<String>();
        String[] operators = {"+", "-", "*", "/"};

        for (int i = prefix.length() - 1; i >= 0; i--) {
            String c = String.valueOf(prefix.charAt(i));
            if (Arrays.asList(operators).contains(c)) {
                String s1 = stack.pop();
                String s2 = stack.pop();
                String temp = "(" + s1 + c + s2 + ")";
                stack.push(temp);
            } else {
                stack.push(c + "");
            }
        }

        return stack.pop();
    }
}