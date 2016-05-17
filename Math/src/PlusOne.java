/**
 * Created by thanksgiving on 5/17/16.
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9, 9};
        System.out.println(plusOne(digits)[0]);
    }

    public static int[] plusOne(int[] digits) {
        int sum = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += sum;
            if (digits[i] <= 9) // early return
                return digits;
            digits[i] = 0;
        }
        int[] ret = new int[digits.length + 1];
        ret[0] = 1;
        return ret;
    }
}
