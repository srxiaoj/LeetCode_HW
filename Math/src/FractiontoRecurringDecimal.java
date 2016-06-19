import java.util.HashMap;
import java.util.Map;

/**
 * Created by thanksgiving on 6/19/16.
 */
public class FractiontoRecurringDecimal {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(4, 333));
        System.out.println(fractionToDecimal(0, 4));
        System.out.println(fractionToDecimal(400, 333));
    }

    public static String fractionToDecimal(int a, int b) {
        // a / b
        int sign = 1;
        if (a >= 0 && b >= 0 || a <= 0 && b <= 0) {
            sign = 1;
        } else {
            sign = -1;
        }
        StringBuilder sb = new StringBuilder();
        if (sign == -1) sb.append("-");
        long absA = Math.abs((long) a);
        long absB = Math.abs((long) b);
        sb.append(absA / absB);
        if (absA % absB == 0) {

            return sb.toString();
        }
        sb.append(".");
        long remainder = absA % absB;
        long temp = 0;
        Map<Long, Integer> map = new HashMap<>();
        while (!map.containsKey(remainder)) {
            map.put(remainder, sb.length());
            temp = remainder * 10 / absB;
            remainder = remainder * 10 % absB;
            if (remainder != 0 || remainder == 0 && !map.containsKey(remainder)) {
                sb.append(temp);
            }
        }
        if (remainder != 0) {
            sb.insert(map.get(remainder), "(");
            sb.append(")");
        }
        return sb.toString();
    }
}
