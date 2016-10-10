import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 4/23/16.
 */
public class GeneralizedAbbreviation {
    public static void main(String[] args) {
//        System.out.println(generateAbbreviationsBit("apple"));
        System.out.println(generateAbbreviationsBit("word"));
//        System.out.println(generateAbbreviationsBit("dictionary"));
    }

    /**
     * 方法1：backtracking
     */
    public static List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        int len = word.length();
        if (len == 0) {
            res.add("");
        } else {
            res.add(String.valueOf(len));
        }
        for (int i = 0; i < len; i++) {
            List<String> next = generateAbbreviations(word.substring(i + 1));
            for (String right : next) {
                String leftNum;
                if (i > 0) {
                    leftNum = String.valueOf(i);
                } else {
                    leftNum = "";
                }
                res.add(leftNum + word.substring(i, i + 1) + right);
            }
        }
        return res;
    }

    /**
     * 方法2：bit
     */
    public static List<String> generateAbbreviationsBit(String word) {
        List<String> res = new ArrayList<>();
        int n = word.length();
        for (int mask = 0; mask < (1 << n); mask++) {
            int count = 0;
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i <= n; i++) {
                if (((1 << i) & mask) != 0) {
                    count++;
                } else {
                    if (count != 0) {
                        sb.append(count);
                        count = 0;
                    }
                    if (i < n) sb.append(word.charAt(i));
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
}
