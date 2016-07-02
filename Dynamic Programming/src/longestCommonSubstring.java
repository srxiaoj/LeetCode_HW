/**
 * Created by thanksgiving on 7/2/16.
 */
public class longestCommonSubstring {
    public static void main(String[] args) {
        String A = "tutorialhorizon";
        String B = "dynamictutorialProgramming";
        System.out.println(longest(A, B));
    }

    public static int longest(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0) return 0;
        int m = a.length(), n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
