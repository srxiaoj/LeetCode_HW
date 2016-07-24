/**
 * - Given string s and string pattern, find the number of subsequences in s that forms pattern.
 * All characters are discontinuous in s.
 * For example, pattern = ab, s = abcacb. Return 2. because {0, 5} and {3, 5} satisfy the rule.
 * {0, 1} is not a result because they are next to each other
 * 要求是subsequence with all characters not next to each other in s
 */
public class StringMatchPatternNotContinuous {
    public static void main(String[] args) {
        System.out.println(numOfMatchDP("abcacbaccbec", "abc"));
        System.out.println(numOfMatchDP("abcacb", "ab"));
        System.out.println(numOfMatchDP("baaabbb", "ab"));
        System.out.println(numOfMatchDP("aaabbbc", "abc"));
    }

    /**
     * O(n * k)
     */
    public static int numOfMatchDP(String s, String pattern) {
        if (pattern == null || pattern.length() == 0) return s.length();
        int patternLen = pattern.length(), n = s.length();
        int[][] dp = new int[n][patternLen + 1];
        for (int i = 0; i < n; i++) {
            // 将第一排初始化为 1 ，因为每多一个a， 多一种累积组合
            dp[i][0] = 1;
        }
        for (int i = 1; i <= patternLen; i++) {
            for (int j = 0; j < n; j++) {
                // 如果b前面是a,那么该b不能算
                if (s.charAt(j) == pattern.charAt(i - 1)) {
                    if (j == 0) {
                        if (i == 1) {
                            dp[j][i] = 1;
                        } else {
                            dp[j][i] = 0;
                        }
                    } else {
                        if (dp[j - 1][i - 1] == 0) {
//                            System.out.println("c: " + j);
                            dp[j][i] = 0;
                            continue;
                        }
                        if (i == 1 || s.charAt(j - 1) != pattern.charAt(i - 2)) {
                            dp[j][i] += dp[j - 1][i - 1] + dp[j - 1][i];
                        } else {
                            if (j - 2 >= 0 && i - 2 >= 0)
                                dp[j][i] += dp[j - 1][i - 1] + dp[j - 1][i] - dp[j - 2][i - 2];
                            else
                                dp[j][i] += dp[j - 1][i - 1] + dp[j - 1][i] - 1;
                        }
                    }
                } else {
                    if (j == 0) dp[j][i] = 0;
                    else dp[j][i] = dp[j - 1][i];
                }
            }
//            printArray(dp);
        }
        return dp[n - 1][patternLen];
    }

    /**
     * O(n^2 * k), wrong
     */
    public static int numOfMatch(String s, String pattern) {
        if (pattern == null || pattern.length() == 0) return s.length();
        int patternLen = pattern.length(), n = s.length();
        int[][] dp = new int[n][patternLen];
        int max = 0;
        for (int i = 0; i < patternLen; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == pattern.charAt(i)) {
                    if (i == 0) {
                        dp[j][i] = 1;
                        continue;
                    }
                    for (int k = 0; k < j; k++) {
                        if (s.charAt(k) == pattern.charAt(i - 1) && k != j - 1) {
                            System.out.println("k is: " + k + ", i is:" + i);
                            dp[j][i] += dp[k][i - 1];
                            if (i == patternLen - 1)
                                max = Math.max(max, dp[j][i]);
                        }
                    }
                }
            }
//            printArray(dp);
        }
        return max;
    }


    public static void printArray(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (j != A[i].length - 1) {
                    System.out.print(A[i][j] + ", ");
                } else
                    System.out.print(A[i][j]);

            }
            System.out.println("");
        }
        System.out.println("");
    }
}
