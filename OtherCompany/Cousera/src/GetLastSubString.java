import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by thanksgiving on 9/8/16.
 */
public class GetLastSubString {
    public static void main(String[] args) {
        System.out.println(getLastSubString2("acb"));
        System.out.println(getLastSubString2("acaacab"));
        System.out.println(getLastSubString2("abczabczcbazbaczcab"));
    }

    /**
     * O(n^2)
     */
    public static String getLastSubString(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                res.add(s.substring(i, j));
            }
        }
        Collections.sort(res);
        System.out.println(res);
        return res.get(res.size() - 1);
    }

    public static String getLastSubString2(String s) {
        String curMax = "";
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.substring(i).compareTo(curMax) > 0) {
                curMax = s.substring(i);
            }
        }
        return curMax;
    }
}
