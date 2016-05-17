/**
 * Created by thanksgiving on 5/17/16.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger obj = new ReverseInteger();
        int n1 = 123;
        int n2 = -123;
        int n3 = Integer.MIN_VALUE;
        System.out.println(obj.reverse(n1));
        System.out.println(obj.reverse(n2));
        System.out.println(obj.reverse(n3));
    }

    public int reverse(int n) {
        long res = 0;
        int sign = 1;
        long temp = n;
        if (n < 0) {
            sign = -1;
            temp = - (long) n;
        }

        while (temp > 0) {
            res = res * 10 + temp % 10;
            temp /= 10;
        }
        if ((sign * res) > Integer.MAX_VALUE || (sign * res) < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) (sign * res);
    }
}
