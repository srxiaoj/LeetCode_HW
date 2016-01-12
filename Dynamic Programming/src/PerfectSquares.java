import java.util.Arrays;


public class PerfectSquares {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(numSquares(13));
    }
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }
}
