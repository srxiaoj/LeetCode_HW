/**
 * Created by thanksgiving on 8/3/16.
 */
public class SumofTwoIntegers {
    public static void main(String[] args) {
        System.out.println(getSum(11, 3));
        System.out.println(getSum(2, 2));
    }

    // Iterative
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

    // Iterative
    public static int getSubtract(int a, int b) {
        while (b != 0) {
            int borrow = (~a) & b;
            a = a ^ b;
            b = borrow << 1;
        }

        return a;
    }
}
