import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by thanksgiving on 1/6/16.
 */
public class StrobogrammaticNumberII {
    public static void main(String[] args) {
        StrobogrammaticNumberII obj = new StrobogrammaticNumberII();
        System.out.println(obj.findStrobogrammatic(3));
    }

    public List<String> findStrobogrammatic(int n) {
        List<String> res = helper(n, n);
//        Collections.sort(res);
        System.out.println("The size of res is: " + res.size());
        return res;
    }

    public List<String> helper(int cur, int n) {
        List<String> res = new LinkedList<>();
        HashMap<String, String> map = new HashMap<>();
//        cache.put("0", "0");
        map.put("1", "1");
        map.put("6", "9");
        map.put("9", "6");
        map.put("8", "8");
        if (cur == 0) {
            res.add("");
            return res;
        }
        if (cur == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }
        List<String> prev = helper(cur - 2, n);
        for (String s : prev) {
            if (cur != n) {
                res.add("0" + s + "0");
            }
            for (String key : map.keySet()) {
                res.add(key + s + map.get(key));
            }
        }
        return res;
    }
}
