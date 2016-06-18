import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by thanksgiving on 4/22/16.
 */
public class LetterCombinationsofaPhoneNumber {
    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber obj = new LetterCombinationsofaPhoneNumber();
        List<String> res = obj.letterCombinations3("23");
        System.out.println(res);
    }

    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    /**
     * 一个offset记录已经输入几个letter
     * 一个 i 记录下一个digit所有输入的可能
     * "" 23 0
     * a  23 1
     * ad 23 2 {ad}
     * ae 23 2 {ad, ae}
     * af 23 2 {ad, ae, af}
     * b  23 1 {ad, ae, af}
     * bd 23 2 {ad, ae, af, bd}
     * be 23 2 {ad, ae, af, bd, be}
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<String>();
        combination("", digits, 0, res);
        return res;
    }

    private void combination(String prefix, String digits, int offset, List<String> res) {
        if (offset >= digits.length()) {
            res.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, res);
        }
    }

    /**
     * 方法2
     */
    public List<String> letterCombinations2(String digits) {
        String[] letter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        helper(res, "", letter, digits, 0);
        return res;
    }

    private void helper(List<String> res, String part, String[] letter, String s, int start) {
        if (start > s.length()) return;
        if (start == s.length()) {
            res.add(part);
            return;
        }

        int index = s.charAt(start) - '0';
        String symbol = letter[index];
        for (int j = 0; j < symbol.length(); j++) {
            String newPart = part + symbol.substring(j, j + 1);
            helper(res, newPart, letter, s, start + 1);
        }
    }


    /**
     * 方法3: 使用StringBuilder
     */
    public List<String> letterCombinations3(String digits) {
        String[] letter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        helper3(res, new StringBuilder(), 0, digits, letter);
        return res;
    }

    private void helper3(List<String> res, StringBuilder part, int start, String digits, String[] letter) {
        if (start > digits.length()) return;
        if (start == digits.length()) {
            res.add(part.toString());
            return;
        }

        int index = digits.charAt(start) - '0';
        String symbol = letter[index];
        for (int i = 0; i < symbol.length(); i++) {
            StringBuilder newPart = new StringBuilder(part);
            newPart.append(symbol.charAt(i));
            helper3(res, newPart, start + 1, digits, letter);
        }
    }
}
