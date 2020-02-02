import java.util.Stack;

public class ScoreOfParentheses {
  public static void main(String[] args) {
    ScoreOfParentheses obj = new ScoreOfParentheses();
    System.out.println(obj.scoreOfParentheses("()()()"));
    System.out.println(obj.scoreOfParentheses("(()())"));
  }

  public int scoreOfParentheses(String S) {
    if (S == null || S.length() == 0) return 0;
    Stack<String> stack = new Stack<>();
    int sum = 0;

    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);
      if (c == '(') {
        stack.add("(");
      } else if (c == ')') {
        if (stack.peek() == "(") {
          stack.pop();
          stack.add("1");
        } else {
          int num = 0;
          while (!stack.isEmpty() && stack.peek() != "(") {
            num += Integer.parseInt(stack.pop());
          }
          stack.pop();
          stack.add(String.valueOf(2 * num));
        }
      }
    }

    int res = 0;
    while (!stack.isEmpty()) {
      res += Integer.parseInt(stack.pop());
    }
    return res;
  }
}
