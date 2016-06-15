/**
 * Created by thanksgiving on 6/15/16.
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
//        System.out.println(isMatch("aa", "a"));
//        System.out.println(isMatch("aa", "aaa"));
//        System.out.println(isMatch("aa", "aa"));
//        System.out.println(isMatch("aa", "a*"));
//        System.out.println(isMatch("aa", ".*"));
//        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
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

    public static boolean isMatchDp(String s, String p) {
        // DP
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        // base case
        dp[0][0] = true;
        boolean valid = false;
        for (int j = 2; j <= p.length(); j += 2) {
            if (p.charAt(j - 1) == '*') {
                valid = true;
                dp[0][j] = true;
            } else {
                valid = false;
            }
            if (!valid) break;
        }
        // iteration
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                dp[i][j] = false;
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                        // dp[i-1][j] do take s[i] to match p[j-1],p[j]
                        // dp[i][j-2] don't take s[i] to match p[j-1],p[j]
                    else
                        dp[i][j] = dp[i][j - 2];
                    // dp[i][j-2] cannot take s[i] to match p[j-1],p[j]
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
