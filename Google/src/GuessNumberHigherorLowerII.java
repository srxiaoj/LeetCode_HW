/**
 * Created by thanksgiving on 7/18/16.
 */
public class GuessNumberHigherorLowerII {
    public static void main(String[] args) {
        System.out.println(getMoneyAmount(10));
        for (int i = 1; i <= 20; i++) {
            System.out.print(getMoneyAmount(i) + " ");
        }
    }

    public static int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return maxHelper(dp, 1, n);
    }

    /**
     * top down
     */
    private static int maxHelper(int[][] dp, int start, int end) {
        if (start >= end) return 0;
        if (dp[start][end] != 0) return dp[start][end];
        int res = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            int tmp = i + Math.max(maxHelper(dp, start, i - 1), maxHelper(dp, i + 1, end));
            res = Math.min(res, tmp);
        }
        dp[start][end] = res;
        return res;
    }

    /**
     * bottom up
     */
    public static int getMoneyAmountDP(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int j = 2; j <= n; j++) {
            for (int i = j - 1; i > 0; i--) {
                int globalMin = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int localMax = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                    globalMin = Math.min(globalMin, localMax);
                }
                if (i + 1 == j) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = globalMin;
                }
            }
        }
        return dp[1][n];
    }
}
