import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "()[]{}";
        String test2 = "([])";
        ValidParentheses obj = new ValidParentheses();
        System.out.println(obj.isValid(test));
        System.out.println(obj.isValid(test2));
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
        
        
//        int length = s.length() + 1; // make sure the program runs into while loop the first time.
//        while (length != s.length()) {
//            length = s.length();
//            s = s.replace("()", "").replace("{}", "").replace("[]", "");
//            
//        }
//        return s.isEmpty();
    }
}
