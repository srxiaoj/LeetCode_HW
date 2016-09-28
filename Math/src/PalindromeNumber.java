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
        if (x < 0) return false;
        int r = 1, l = (int) Math.pow(10, (int) Math.log10(x));
        while (r <= l) {
            if ((x / l) % 10 != (x / r) % 10) {
                return false;
            }
            r *= 10;
            l /= 10;
        }
        return true;
    }
}
