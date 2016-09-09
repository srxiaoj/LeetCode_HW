/**
 * Given a string, every step you can add/delete/change one character at any position.
 * Minimize the step number to make it a palindrome.
 */
public class MinimumStepToPalindrome {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abc";
        System.out.println(find(s1));
        System.out.println(find(s2));
    }


    /**
     * 从下往上，从左到右遍历
     */
    public static int find(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else if (i + 1 == j) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) ? 0 : 1);
                } else {
                    if (s.charAt(i) == s.charAt(j))
                        dp[i][j] = dp[i + 1][j - 1];
                    else
                        dp[i][j] = Math.min(dp[i + 1][j - 1], Math.min(dp[i][j - 1], dp[i + 1][j])) + 1;
                }
            }
            printArray(dp);
        }
        return dp[0][s.length() - 1];
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
