/**
 * Created by thanksgiving on 5/12/16.
 */
public class PowOfX {
    public static void main(String[] args) {
        System.out.println(myPow(8.88023, 3));
        System.out.println(myPow(1.00000, -2147483648));
        System.out.println(myPow(0.00001, 2147483647));
        System.out.println(myPow(34.00515, -3));
    }

    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        double temp = myPow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            if (n > 0) {
                return temp * temp * x;
            } else {
                return (temp * temp) / x;
            }
        }
    }
}
