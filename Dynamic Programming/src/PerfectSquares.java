import java.util.Arrays;

public class PerfectSquares {

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    /**
     * 核心步骤： dp[i] = Math.min(dp[i], dp[i - j * j] + 1)
     * 如果i - j * j == 0, 则dp[i] = 0;
     * The key point is to decompose n into subresults with different square number
     * eg. n = 12
     * res[12] = res[1] + res[11]
     * res[12] = res[4] + res[8]
     * res[12] = res[9] + res[3]
     */
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j*j <= i; j++) {
                // if i - j * j == 0, then dp[i] = 0
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 1 stands for dp[j *j] which should be 1
            }
        }
        return dp[n];
    }
}
