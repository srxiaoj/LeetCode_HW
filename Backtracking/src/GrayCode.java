import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 4/26/16.
 */
public class GrayCode {

  public static void main(String[] args) {
    GrayCode obj = new GrayCode();
    System.out.println(obj.grayCode(2));

  }

  /*public List<Integer> grayCode(int n) {
    List<Integer> res = new ArrayList<>();
    dfs(res, new ArrayList<>(), 0, n);
    return res;
  }

  private void dfs(List<Integer> res, List<Character> part, int index, int n) {
    if (part.size() == n) {
      res.add(bitToInt(part));
      return;
    }

    for (int i = 0; i < part.size(); i++) {
      List<Character> newPart = new ArrayList<>(part);
      newPart.add(i, (char) index);
      dfs(res, newPart, index + 1, n);
    }
  }

  private int bitToInt(List<Character> s) {
    int res = 0;
    for (int i = s.size() - 1; i >= 0; i--) {
      res += Math.pow(2, s.get(i) - '0');
    }
    return res;
  }*/

  /**
   * 非常巧妙的解法：i ^ (i >> 1)
   *
   * @param n
   * @return
   */
  public List<Integer> grayCode(int n) {
      int count = (int) Math.pow(2, n);
      List<Integer> res = new ArrayList<>();
      for (int i = 0; i < count; i++) {
          int temp = i >> 1;
          System.out.print(temp + " ");
          res.add(i ^ temp);
      }
      return res;
  }
}
