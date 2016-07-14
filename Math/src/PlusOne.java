/**
 * Created by thanksgiving on 5/17/16.
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 9, 9};
        int[] res = plusOne(digits);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
    }

    /**
     * plus any val
     */
    public static int[] plusOne(int[] digits) {
        int val = 8;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += val;
            if (digits[i] <= 9) // early return
                return digits;
            val = digits[i] / 10;
            digits[i] = digits[i] % 10;
        }
        int[] ret = new int[digits.length + 1];
        ret[0] = 1;
        for (int i = 1; i < ret.length; i++) {
            ret[i] = digits[i - 1];
        }
        return ret;
    }
}
