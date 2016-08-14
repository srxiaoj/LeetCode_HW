import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 8/13/16.
 */
public class ExpressionAddOperators {
    public static void main(String[] args) {
        ExpressionAddOperators obj = new ExpressionAddOperators();
//        System.out.println(obj.addOperators("123", 6));
        System.out.println(obj.addOperators("105", 5));
    }

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        if (num == null || num.length() == 0) return res;
        helper(res, "", num, target, 0, 0, 0);
        return res;
    }

    public void helper(List<String> res, String part, String num, int target, int pos, long total, long lastDigit) {
        if (pos == num.length() && target == total) {
            res.add(part);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            // "05" 被Long.parse成5
            if (i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(res, part + cur, num, target, i + 1, cur, cur);
            } else {
                helper(res, part + "+" + cur, num, target, i + 1, total + cur, cur);
                helper(res, part + "-" + cur, num, target, i + 1, total - cur, -cur);
                //for example, if you have a sequence of 12345 and you have proceeded to 1 + 2 + 3, now your eval is 6 right?
                // If you want to add a * between 3 and 4, you would take 3 as the digit to be multiplied,
                // so you want to take it out from the existing eval. You have 1 + 2 + 3 * 4 and the eval now is (1 + 2 + 3) - 3 + (3 * 4). Hope this could help : )
                helper(res, part + "*" + cur, num, target, i + 1, total - lastDigit + lastDigit * cur, lastDigit * cur);
            }
        }
    }
}
