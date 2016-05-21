/**
 * Created by thanksgiving on 5/21/16.
 */
public class PowerofTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(17));
    }

    /**
     * 注意如果 p << 1可能会超过Integer.MAX_VALUE而变成0， 所以要用p != 0判断
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        long p = 1;
        while (p != 0 && p < n) {
            p <<= 1;
        }
        return p == n;


      /*  while ((n % 2) == 0 && n > 1) {
            n /= 2;
        }
        return n == 1;*/
    }
}
