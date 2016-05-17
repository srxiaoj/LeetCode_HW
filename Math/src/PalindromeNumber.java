/**
 * Created by thanksgiving on 5/17/16.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(131));
        System.out.println(isPalindrome(1331));
        System.out.println(isPalindrome(1));
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(1874994781));
    }

    public static boolean isPalindrome(int x) {
        int bits = (int) Math.log10((double) x); //the length of x
        int n = (int) Math.pow(10, (double) bits);

        int l = n, r = 1;
        while (l >= r) {
            if ((x / l) % 10 != (x / r) % 10) {
                return false;
            }
            l /= 10;
            r *= 10;
        }
        return true;
    }
}
