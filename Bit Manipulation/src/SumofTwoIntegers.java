/**
 * Created by thanksgiving on 8/3/16.
 */
public class SumofTwoIntegers {
    public static void main(String[] args) {
        System.out.println(getSum(11, 3));
        System.out.println(getSum(2, 2));
    }

    /**
     * https://discuss.leetcode.com/topic/49771/java-simple-easy-understand-solution-with-explanation
     * For this, problem, for example, we have a = 1, b = 3,
     * In bit representation, a = 0001, b = 0011,
     * First, we can use "and"("&") operation between a and b to find a carry.
     * carry = a & b, then carry = 0001
     * Second, we can use "xor" ("^") operation between a and b to find the different bit, and assign it to a,
     * Then, we shift carry one position left and assign it to b, b = 0010.
     * Iterate until there is no carry (or b == 0)
     */
    public static int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }

    public static int getSubtract(int a, int b) {
        while (b != 0) {
            int borrow = (~a) & b;
            a = a ^ b;
            b = borrow << 1;
        }

        return a;
    }
}
