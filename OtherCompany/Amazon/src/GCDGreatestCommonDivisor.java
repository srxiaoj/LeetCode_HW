/**
 * Created by Administrator on 2016/10/8.
 */
public class GCDGreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(getGcd(new int[] {15, 3, 6, 12, 21}));
    }

    public static int getGcd(int[] array) {
        if (array == null || array.length == 1) return 0;
        int gcd = array[0];
        for (int i = 1; i < array.length; i++) {
            gcd = gcd(gcd, array[i]);
        }
        return gcd;
    }
    private static int gcd(int a, int b) {
        if (a == 0 || b == 0) return a + b;
        return gcd(b, a % b);


       /* if (a == 0 || b == 0) return 0;
        while (a != 0 && b != 0) {
            if (b > a) {
                a ^= b;
                b ^= a;
                a ^= b;
            }
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a + b;*/
    }
}
