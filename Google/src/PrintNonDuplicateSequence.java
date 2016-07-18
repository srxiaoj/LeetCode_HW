import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by thanksgiving on 7/16/16.
 */
public class PrintNonDuplicateSequence {
    public static void main(String[] args) {
        System.out.println(getNonDuplicateSequence(1000));
    }

    public static List<Integer> getNonDuplicateSequence(int n) {
        List<Integer> res = new ArrayList<>();
        int next = 0;
        while (res.size() < n) {
            int ignore = getBadDigit(next);
            if (ignore == -1) {
                res.add(next);
                next++;
            } else {
                int ignoreNum = (int) Math.pow(10, ignore);
//                if (ignore > 0) System.out.println("last " + next + ", ignore " + ignoreNum);
                next += ignoreNum;
            }
        }
        System.out.println("size " + res.size());
        return res;
    }

    private static int getBadDigit(int num) {
        String s = String.valueOf(num);
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
            } else {
                return s.length() - i - 1;
            }
        }
        return -1;
    }
}
