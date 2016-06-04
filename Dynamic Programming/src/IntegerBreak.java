/**
 * Created by thanksgiving on 4/23/16.
 */
public class IntegerBreak {
    public static void main(String[] args) {
        IntegerBreak obj = new IntegerBreak();
        int res = obj.integerBreak(10);
        System.out.println(res);
    }

    public int integerBreak(int n) {
        /**
         * O(n^2) 解法，需注意dp[2] < 2, dp[3] < 3, dp[5] = 2 * 3 = 6, 比 dp[2] * dp[3] 大
         * 因此dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max((i-j), dp[i - j]));
         */
/*        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
//                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max((i-j), dp[i - j]));
            }
        }
        return dp[n];*/


        /**
         * O(n) 解法
         * 从5， 开始后，p[i] = 3 * p[i - 3], 注意p2 = 2, p3 = 3, p4 = 4
         */
        if (n <= 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int[] p = new int[n + 1];
        p[2] = 2;
        p[3] = 3;
        p[4] = 4;
        for (int i = 5; i <= n; ++i) {
            p[i] = 3 * p[i - 3];
        }
        return p[n];
    }


    /*Why the max product of any n>4 must contain a factor of 3?
            1. It can't contain any factor x that is >= 5, o.w., we can further increase the
               max product by decomposing x, as the decomposed x when x>=5 is strictly greater than x;
            2. Out of 1, 2, 3, 4, we know 1 won't be a factor of n when n>4, if n is an odd number,
               must be there as a factor (2 and 4 can't add up to an odd number);
            3. Now say n is an even number (n>4) and only has factor of 2 and 4, we can always split a 6 to 3X3, which is better than 2X2X2.
            Therefore, the max product of any n (n>4) must contain a factor of 3. The recurrence relation holds.

            Further, as it holds for all n (n>4), we will be only using 3 as factor for n (n>4),
            we keep subtracting 3 until n<=4, and adopt the remaining factor. This leads to the closed form answer:
    */
    public int integerBreak2(int n) {
        if (n <= 2) return 1;
        if (n == 3) return 2;
        if (n % 3 == 0) return (int)Math.pow(3, (n/3));
        else if (n % 3 == 1) return 4 * (int)Math.pow(3, (n-4)/3);
        else return 2 * (int)Math.pow(3, (n-2)/3);
    }
/**
 *  As for the complexity of the close form solution, it depends on the implementation of the build-in pow,
 *  it could be O(logn) (as a simple O(logn) implementation exists), but not necessarily.
 *  The build-in pow could be better than that by using caching or bit level manipulation.
 *  I don’t know the answer though.*/
}
