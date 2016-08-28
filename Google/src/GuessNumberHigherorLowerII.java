/**
 * Created by thanksgiving on 7/18/16.
 */
public class GuessNumberHigherorLowerII {
    public static void main(String[] args) {
        System.out.println(getMoneyAmountDP(5));
        for (int i = 1; i <= 22; i++) {
//            System.out.print(getMoneyAmount(i) + " ");
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
                    if (globalMin > localMax) {
                        globalMin = Math.min(globalMin, localMax);
//                        if (j == n && i == 1)
//                            System.out.println(dp[i][k - 1] + " " + k + " " + dp[k + 1][j] + " local max " + localMax);
                    }
                }
                if (i + 1 == j) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = globalMin;
                }
            }
            printArray(dp);
        }
        return dp[1][n];
    }

    /**
     * print 2D array.
     */
    public static void printArray(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print("[");
            for (int j = 0; j < A[i].length; j++) {
                if (j != A[i].length - 1) {
                    System.out.print(A[i][j] + ", ");
                } else
                    System.out.print(A[i][j]);

            }
            System.out.println("]");
        }
        System.out.println("");
    }
}
