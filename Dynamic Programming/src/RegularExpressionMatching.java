/**
 * Created by thanksgiving on 6/15/16.
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
//        System.out.println(isMatchDp("aa", "a"));
//        System.out.println(isMatchDp("aa", "aaa"));
//        System.out.println(isMatchDp("aa", "aa"));
//        System.out.println(isMatchDp("aa", "a*"));
//        System.out.println(isMatchDp("aa", ".*"));
//        System.out.println(isMatchDp("ab", ".*"));
        System.out.println(isMatchDp("aab", "c*a*b"));
//        System.out.println(isMatchDp("aaa", "ab*ac*a"));
//        System.out.println(isMatchDp("a", "ab*ac*"));
    }

    public static boolean isMatchDp(String s, String p) {
        int m = s.length(), n = p.length();
        boolean dp[][] = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 2; j <= p.length() && p.charAt(j - 1) == '*'; j += 2) {
            dp[0][j] = true;
        }
        // iteration
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = false;
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                        // dp[i-1][j] do take s[i] to match p[j-1],p[j]
                        // dp[i][j-2] don't take s[i] to match p[j-1],p[j]
                    else
                        dp[i][j] = dp[i][j - 2];
                    // dp[i][j-2] cannot take s[i] to match p[j-1],p[j]
                }
            }
//            printArray(dp);
        }
        return dp[m][n];
    }

    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.isEmpty() || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))) {
                return false;
            } else {
                // !s.isEmpty() && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)
                return isMatch(s.substring(1), p.substring(1));
            }
        }

        //P.length() >=2
        while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            s = s.substring(1);
        }
        return isMatch(s, p.substring(2));
    }

    public static void printArray(boolean[][] A) {
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
