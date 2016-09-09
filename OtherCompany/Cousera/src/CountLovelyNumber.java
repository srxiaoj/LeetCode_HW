/**
 * count the lovely number from 1 to a given n. lovelynumber is a number with unique characters. eg. 123 is a lovely number while 122 isn't.
 */
public class CountLovelyNumber {
    public static void main(String[] args) {
        System.out.println(getCount(45));
        System.out.println(getCount(40));
        System.out.println(getCount(32));
        System.out.println(getCount(145));
    }

    public static int getCount(int n) {
        if (n <= 10) return n;
        int power = (int) Math.log10(n);
        int[] dp = getPowCount(power);
        int[] sum = getPowCountSum(power);
        printArray(dp);
        int divide = 10;
        int res = 0;
        int last = 0;
        for (int i = 0; i < dp.length; i++) {
            if (last >= n % divide && i != 0) {
                res -= dp[i - 1];
            }
            res += n % divide * dp[i];
            last = n % divide;
            n /= divide;
        }
        return res;
    }

    public static int[] getPowCount(int pow) {
        int[] dp = new int[pow + 1];
        dp[0] = 1;
        dp[1] = 9;
        int remain = 9;
        for (int i = 2; i <= pow; i++) {
            dp[i] = dp[i - 1] * remain;
            remain--;
        }

/*        int[] sum = new int[pow + 1];
        for (int i = 0; i < pow + 1; i++) {
            for (int j = 0; j <= i; j++) {
                sum[i] += dp[j];
            }
        }*/
        return dp;
    }

    public static int[] getPowCountSum(int pow) {
        int[] dp = new int[pow + 1];
        dp[0] = 1;
        dp[1] = 9;
        int remain = 9;
        for (int i = 2; i <= pow; i++) {
            dp[i] = dp[i - 1] * remain;
            remain--;
        }

        int[] sum = new int[pow + 1];
        for (int i = 0; i < pow + 1; i++) {
            for (int j = 0; j <= i; j++) {
                sum[i] += dp[j];
            }
        }
        return sum;
    }

    //print array
    public static void printArray(int[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }
}
