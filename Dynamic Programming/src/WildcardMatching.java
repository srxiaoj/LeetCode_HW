
public class WildcardMatching {

    public static void main(String[] args) {
//        System.out.println(isMatch("", "*a"));
//        System.out.println(isMatch("aab", "***b"));
//        System.out.println(isMatch("acb", "ac*b"));
//        System.out.println(isMatch("acbbb", "ac*b"));
//        System.out.println(isMatch("bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaa", "b*b*ab**ba*b**b***a"));
//        System.out.println(isMatch("bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab", "b*b*ab**ba*b**b***bba"));
//        System.out.println(isMatch("aa", "*"));
//        System.out.println(isMatch("ab", "*a"));
//        System.out.println(isMatch("ab", "?*"));
//        System.out.println(isMatch("aab", "c*a*b"));
//        System.out.println(isMatch("ab", "ab*"));
        System.out.println(isMatch("abef", "ab*"));
    }

    // 非常关键,要把 dp[0][j]中以 '*'开始的所有点全部变为true, 解决 "", "*" 和 "c" "*?*"
    public static boolean isMatch(String s, String p) {
        // dp
        if (s == null || p == null) return true;
        if (p.replace("*", "").length() > s.length()) return false;
        int m = s.length();
        int n = p.length();
        //dp[i][j] use to store the result of isMatch(previous i in s, previous j in p), eg. dp(1,2) means
        //the result isMatch(s.substring(0,1), p.substring(0,2)), check whether the 1st char in s matches the 2 characters in p
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // 非常关键,要把 dp[0][j]中以 '*'开始的所有点全部变为true, 解决 "", "*" 和 "c" "*?*"
        for (int j = 1; j <= n && p.charAt(j - 1) == '*'; j++) {
            dp[0][j] = true;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // dp[i - 1][j] is for "abef", "ab*", means * match one more char, dp[i][j - 1] is for "ab", "ab*", means * doesn't match any character
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
            printArray(dp);
        }

        return dp[m][n];

        /**
         * solution 2:
         */
      /*  if (p.replace("*", "").length() > s.length()) return false;
        int m = s.length();
        int n = p.length();
        int i = 0, j = 0, previousStarPosition = -1, match = 0;
        while (i < m) {
            if (j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < n && p.charAt(j) == '*') {
                previousStarPosition = j;
                match = i;
                j++;
            // means there is a '*' appeared before
            // now use this '*' to match one more character
            } else if (previousStarPosition != -1) {
                j = previousStarPosition;
                match++;
                i = match;
            } else {
                return false;
            }
        }
        System.out.println("j: " + j);
        while (j < n && p.charAt(j) == '*') {
            j++;
        }
        return j == p.length();*/
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
