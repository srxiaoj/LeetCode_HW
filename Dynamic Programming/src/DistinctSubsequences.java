/**
 * Created by thanksgiving on 8/6/16.
 */
public class DistinctSubsequences {
    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println(numDistinct("ccc", "c"));
    }

    public static int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return 0;
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) == t.charAt(0)) {
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
