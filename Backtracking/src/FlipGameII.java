import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by thanksgiving on 4/23/16.
 */
public class FlipGameII {
    public static void main(String[] args) {
        FlipGameII obj = new FlipGameII();
//        String s = "+++++++++";
        String s = "++++";
        System.out.println(obj.canWin(s));
    }

    public boolean canWin(String s) {
        if (s == null) return false;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)) {
                String temp = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!canWin(temp)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 使用map存下每个string的结果，速度更快
     */
    public boolean canWin2(String s) {
        Map<String, Boolean> map = new HashMap<>();
        return helper(s, map);
    }

    private boolean helper(String s, Map<String, Boolean> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.startsWith("++", i)) {
                String temp = s.substring(0, i) + "--" + s.substring(i + 2);
                if (helper(temp, map)) {
                    continue;
                }
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
