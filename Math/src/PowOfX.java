/**
 * Created by thanksgiving on 5/12/16.
 */
public class PowOfX {
    public static void main(String[] args) {
        System.out.println(myPow(4, -2));
        System.out.println(myPow(1.00000, -2147483648));
        System.out.println(myPow(2.00000, -2147483648));
        System.out.println(myPow(0.00001, 2147483647));
        System.out.println(myPow(34.00515, -3));
        System.out.println(1.0 / -2147483648);
        System.out.println(1 / -2147483648);
    }

    /**
     * n 为负数时候用temp * temp / x， 用myPow(x, -n)会IntegerOverFlow
     */
    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        double temp = myPow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            if (n > 0) {
                return temp * temp * x;
            } else {
                // n < 0, get the reciprocal
                return (temp * temp) / x;
            }
        }
    }
}
