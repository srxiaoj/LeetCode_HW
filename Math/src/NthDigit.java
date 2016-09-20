/**
 * Created by thanksgiving on 9/18/16.
 */
public class NthDigit {
    public static void main(String[] args) {
//        System.out.println(findNthDigit(11));
//        System.out.println(findNthDigit(10));
//        System.out.println(findNthDigit(100));
//        System.out.println(findNthDigit(1000));
//        System.out.println(findNthDigit(10000));
        System.out.println(findNthDigit(2147483647));
    }

    public static int findNthDigit(int n) {
        int[] dp = new int[11];
        long total = 0;
        int i = 0;
        while (total < n) {
            dp[i] = i + 1;
            int next = (int) ((long) Math.pow(10, i + 1) - Math.pow(10, i));
            total += dp[i] * next;
            i++;
        }
        int rest, fac, mod, num;
        if (i == 9) {
            dp[9] = 10;
            rest = (int) (n - total);
            System.out.println("total " + total + ", rest " + rest);
            fac = (rest + 1) / dp[9];
            mod = rest % dp[9];
            num = (int) (Math.pow(10, 9) - 1 + fac);
        } else {
            i--;
            total -= dp[i] * (Math.pow(10, i + 1) - Math.pow(10, i));
            rest = (int) (n - total);
            fac = (rest + 1) / dp[i];
            mod = rest % dp[i];
            num = (int) (Math.pow(10, i) - 1 + fac);
        }
        return getLast(num, mod);
    }

    public static int getLast(int num, int mod) {
        if (mod == 0) {
            return num % 10;
        } else {
            String next = String.valueOf(num + 1);
            System.out.println("next " + next + ", mod " + mod);
            return (next.charAt(mod - 1) - '0');
        }
    }
}
