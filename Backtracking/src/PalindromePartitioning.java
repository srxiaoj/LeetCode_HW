import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 12/28/15.
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        PalindromePartitioning obj = new PalindromePartitioning();
        String test = "aabcb";
//        System.out.println(obj.isPalindrome(test));
//        System.out.println(obj.palindromePartitioning(test));
        System.out.println(obj.partition2(test));
    }

    /**
     * 方法3
     */
    public List<List<String>> partition3(String s) {
        int n = s.length();
        List<List<String>> res = new ArrayList<>();
        if (n == 0) return res;
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (i + 1 == j) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
            }
        }

        helper(res, new ArrayList<>(), 0, s, dp);
        return res;
    }

    private void helper(List<List<String>> res, List<String> part, int pos, String s, boolean[][] dp) {
        if (pos == s.length()) {
            res.add(part);
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            if (dp[pos][i]) {
                List<String> newPart = new ArrayList<>(part);
                newPart.add(s.substring(pos, i + 1));
                helper(res, newPart, i + 1, s, dp);
            }
        }
    }

    public List<List<String>> partition2(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();
        int n = s.length();
        List<List<String>>[] dp = new ArrayList[n + 1];
        // add an empty array for initial result
        dp[0] = new ArrayList<>();
        dp[0].add(new ArrayList<>());

        boolean[][] pair = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pair[i][j] = false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isPalin(s, i, j, pair)) {
                    pair[i][j] = true;
                }
            }
        }

        printArray(pair);

        for (int i = 0; i < n; i++) {
            dp[i + 1] = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                String right = s.substring(j, i + 1);
                if (pair[j][i]) {
                    for (List<String> r : dp[j]) {
                        List<String> newSub = new ArrayList<>(r);
                        newSub.add(right);
                        dp[i + 1].add(newSub);
                    }
                }
            }
            System.out.println(dp[i]);
        }
        return dp[n];
    }

    private boolean isPalin(String s, int i, int j, boolean[][] pair) {
        if (i > j) return false;
        if (i == j) return true;
        if (i == j - 1) return s.charAt(i) == s.charAt(j);
        return s.charAt(i) == s.charAt(j) && isPalin(s, i + 1, j - 1, pair);

      /*  if (i > j) return false;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                if (i + 1 <= j - 1 && pair[i + 1][j - 1]) return true;
            } else {
                return false;
            }
            i++;
            j--;
        }
        return true;*/
    }

    public static void printArray(boolean[][] A) {
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


    /**
     * 方法1：dynamic programming
     */
    public static List<List<String>> palindromePartitioning(String s) {
        int n = s.length();
        List<List<String>>[] result = new List[n + 1];
        result[0] = new ArrayList<List<String>>();
        result[0].add(new ArrayList<String>());
        // pair stores the result that whether a range of string is a palindrome or not
        // pair[0][1] is true means that s.substring(0, 2) is a palindrome
        boolean[][] pair = new boolean[n][n];
        for (int i = 0; i < s.length(); i++) {
            result[i + 1] = new ArrayList<List<String>>();
            for (int j = 0; j <= i; j++) {
                // core step, determine whether this is a palindrome
                // only if the two side chars are equal and the sequence in the middle is palindrome
                if (s.charAt(j) == s.charAt(i) && (j + 1 > i - 1 || pair[j + 1][i - 1])) {
                    pair[j][i] = true;
                    String str = s.substring(j, i + 1);
                    for (List<String> r : result[j]) {
                        List<String> ri = new ArrayList<String>(r);
                        ri.add(str);
                        result[i + 1].add(ri);
                    }
                }
            }
        }
        return result[n];
    }

    /**
     * 方法2：dfs, 每次判断s.substring(start, i)是不是palindrome， 是的话就添加到list中
     * a, a, b true
     * a, ab false
     * aa, b true
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        List<String> part = new ArrayList<>();
        add(res, part, s, 0);
        return res;
    }

    private void add(List<List<String>> res, List<String> part, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(part));
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (isPalindrome(str)) {
                List<String> newPart = new ArrayList<>(part);
                newPart.add(str);
                add(res, newPart, s, i);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
