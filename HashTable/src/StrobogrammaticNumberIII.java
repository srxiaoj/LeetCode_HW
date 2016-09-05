import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 9/5/16.
 */
public class StrobogrammaticNumberIII {
    public static void main(String[] args) {
        StrobogrammaticNumberIII obj = new StrobogrammaticNumberIII();
        System.out.println(obj.strobogrammaticInRange("0", "0"));
        System.out.println(obj.res);
        System.out.println(obj.strobogrammaticInRange("50", "100"));
        System.out.println(obj.res);
        System.out.println(obj.strobogrammaticInRange("500", "1000"));
        System.out.println(obj.res);
        System.out.println(obj.strobogrammaticInRange("5000", "10000"));
        System.out.println(obj.res);
    }

    private char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    private int count;
    private List<String> res;

    /**
     * 从low到high去生成Strobogrammatic number，然后判断是否在low, high之间
     */
    public int strobogrammaticInRange(String low, String high) {
        count = 0;
        res = new ArrayList<>();
        for (int i = low.length(); i <= high.length(); i++) {
            dfs(low, high, new char[i], 0, i - 1);
        }
        return count;
    }

    public void dfs(String low, String high, char[] c, int left, int right) {
        if (left > right) {
            String s = new String(c);
            if ((s.length() == low.length() && s.compareTo(low) < 0) || (s.length() == high.length() && s.compareTo(high) > 0)) return;
            count++;
            res.add(s);
            return;
        }

        for (char[] p : pairs) {
            c[left] = p[0];
            c[right] = p[1];
            if (c.length != 1 && c[0] == '0') continue;
            // 防止出现669, 696等数字
            if (left < right || left == right && p[0] == p[1]) dfs(low, high, c, left + 1, right - 1);
        }
    }
}
