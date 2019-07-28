import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 4/25/16.
 */
public class GenerateParentheses {

  public static void main(String[] args) {
    GenerateParentheses obj = new GenerateParentheses();
    System.out.println(obj.generateParenthesis(3));
  }

  /**
   * 优先填左括号至等于n, 然后去填)至右括号数量等于左括号数 ((())) (()()) (())() ()(()) ()()()
   */
  public List<String> generateParenthesis(int n) {
    List<String> list = new ArrayList<String>();
    helper(list, "", 0, 0, n);
    return list;
  }

  public void helper(List<String> list, String str, int left, int right, int max) {
    if (str.length() == 2 * max) {
      System.out.println(str);
      list.add(str);
      return;
    }

    // 注意是 if 不是 for loop
    if (left < max) {
      helper(list, str + "(", left + 1, right, max);
    }
    if (right < left) {
      helper(list, str + ")", left, right + 1, max);
    }
  }
}
