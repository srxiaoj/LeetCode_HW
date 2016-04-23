import java.util.LinkedList;
import java.util.List;

/**
 * Created by thanksgiving on 4/22/16.
 */
public class LetterCombinationsofaPhoneNumber {
    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber obj = new LetterCombinationsofaPhoneNumber();
        List<String> res = obj.letterCombinations("23");
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
}
