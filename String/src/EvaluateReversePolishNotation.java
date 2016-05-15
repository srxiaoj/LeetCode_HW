import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        EvaluateReversePolishNotation obj = new EvaluateReversePolishNotation();
//        String[] tokens = {"4", "13", "5", "/", "+"};
        String[] tokens = {"3","-4","+"};
        System.out.println(obj.evalRPN(tokens));
    }

    /**
     * 借用stack的特点，将非符号的String放入stack，然后在碰到符号的时候取出两个数字进行操作
     * 再将结果放入stack
     */
    public int evalRPN(String[] tokens) {
        List<String> op = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
        if (tokens == null) return 0;
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (!op.contains(s)) {
                stack.add(Integer.parseInt(s));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                int sub = operate(a, b, s);
                stack.add(sub);
            }
        }
        return stack.pop();
    }

    private int operate(int a, int b, String s) {
        if (s.equals("+")) {
            return a + b;
        } else if (s.equals("-")) {
            return a - b;
        } else if (s.equals("*")) {
            return a * b;
        } else {
            return a / b;
        }
    }
}
