/**
 * Created by thanksgiving on 9/18/16.
 */
public class NthDigit {
    public static void main(String[] args) {
//        System.out.println(findNthDigit(3));
        System.out.println(findNthDigit(11));
        System.out.println(findNthDigit(10));
        System.out.println(findNthDigit(100));
        System.out.println(findNthDigit(1000));
        System.out.println(findNthDigit(10000));
        System.out.println(findNthDigit(2147483647));
    }

    public static int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}
