import java.util.HashMap;
import java.util.Map;

/**
 * Created by thanksgiving on 5/17/16.
 */
public class RomanToInteger {
    public static void main(String[] args) {
        String s1 = "MCMXCVI";
        System.out.println(romanToInt(s1));

    }

    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        int res = 0;
        if (map.containsKey(s)) {
            return map.get(s);
        }
        int i = 0;
        // i go to s.length() - 2 to make sure not out of boundary
        while (i < s.length() - 1) {
            String sub = s.substring(i, i + 2);
            if (map.containsKey(sub)) {
                res += map.get(sub);
                i += 2;
            } else {
                res += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        // handle last character
        if (i < s.length()) {
            res += map.get(s.substring(i, i + 1));
        }
        return res;
    }
}
