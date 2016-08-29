import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 4/23/16.
 */
public class GeneralizedAbbreviation {
    public static void main(String[] args) {
//        System.out.println(generateAbbreviationsBit("word"));
        System.out.println(generateAbbreviationsBit("dictionary"));
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

    public static List<String> generateAbbreviationsBit(String word) {
        List<String> res = new ArrayList<>();
        if (word == null || word.length() == 0) return res;
        int n = word.length();
        for (int i = 0; i < (1 << n); i++) {
            res.add(binaryToWord(word, i));
        }
        return res;
    }

    private static String binaryToWord(String word, int num) {
        StringBuilder sb = new StringBuilder();
        int i = word.length() - 1;
        while (i >= 0) {
            if (((num >> i) & 1) == 1) {
                int count = 0;
                while (((num >> i) & 1) == 1) {
                    i--;
                    count++;
                }
                sb.append(count);
            } else {
                sb.append(word.charAt(word.length() - 1 - i));
                i--;
            }
        }
        return sb.toString();
    }
}
