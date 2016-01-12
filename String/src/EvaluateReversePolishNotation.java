import java.util.Stack;

/**
 * Created by thanksgiving on 1/1/16.
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        EvaluateReversePolishNotation obj = new EvaluateReversePolishNotation();
//        String[] tokens = {"4", "13", "5", "/", "+"};
        String[] tokens = {"3","-4","+"};
        System.out.println(obj.evalRPN(tokens));
    }
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0 || tokens == null) return 0;
        if (tokens.length == 1) return Integer.parseInt(tokens[0]);
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < tokens.length) {
            while (Character.isDigit(tokens[i].charAt(tokens[i].length() - 1))) {
                stack.add(tokens[i]);
                i++;
            }
            int operant = Integer.parseInt(stack.pop());
            int operand = Integer.parseInt(stack.pop());
            int res = compute(operand, tokens[i], operant);
            stack.add(String.valueOf(res));
            i++;
        }
        return Integer.parseInt(stack.lastElement());
    }
    private int compute(int operand, String op, int operant) {
        switch (op) {
            case "+":
                return operand + operant;
            case "-":
                return operand - operant;
            case "*":
                return operand * operant;
            case "/":
                return operand / operant;
            default:
                return 0;
        }
    }
}
