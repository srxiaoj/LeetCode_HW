/**
 * Created by thanksgiving on 9/16/16.
 */
public class IntegerReplacement {
    public static void main(String[] args) {
        for (int i = 8; i <= 17; i++) {
            System.out.println(i + ": " + integerReplacement(i));
        }
        System.out.println(integerReplacement(65535));
        System.out.println(integerReplacement(2147483647));
    }

    public static int integerReplacement(int n) {
        long cur = (long) n;
        int count = 0;
        while (cur > 1) {
            if (cur % 2 == 0) {
                cur /= 2;
            } else {
                if ((cur - 1) / 2 % 2 == 0 || cur == 3) {
                    cur -= 1;
                } else {
                    cur += 1;
                }
            }
            count++;
        }
        return count;
    }
}
