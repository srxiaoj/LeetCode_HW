import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 12/28/15.
 */
public class PalindromePartitioningII {
    public static void main(String[] args) {
        PalindromePartitioningII obj = new PalindromePartitioningII();
//        System.out.println(obj.minCut("ababababababababababaababababababababababaababababababababababa"));
//        System.out.println(obj.minCutDynamicProgramming("ababababababababababaababababababababababaababababababababababa"));
//        System.out.println(obj.minCutDynamicProgramming("abcd"));
        System.out.println(obj.minCutDynamicProgramming("aabbc"));
        System.out.println(obj.minCutDynamicProgramming("acbb"));
        System.out.println(obj.minCutDynamicProgramming("efe"));
    }

    public int minCutDynamicProgramming(String s) {
        char[] c = s.toCharArray();
        int n = s.length();
        int[] dp = new int[n];
        boolean[][] pair = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i] = i;
            for (int j = 0; j <= i; j++) {
                if (c[j] == c[i]) {
                    if (i == j + 1 || i == j || pair[j + 1][i - 1]) {
                        pair[j][i] = true;
                        if (j == 0) {
                            dp[i] = 0;
                        } else {
                            dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                        }
                    }
                }
            }
            printArray(dp);
        }
        return dp[n - 1];


       /* char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            cut[i] = i;
            for (int j = 0; j <= i; j++) {
                if (c[j] == c[i] && (i - j < 2 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    if (j == 0) {
                        cut[i] = 0;
                    } else {
                        cut[i] = Math.min(cut[i], cut[j - 1] + 1);
                    }
                }
            }
            printArray(cut);
        }
        return cut[n - 1];*/
    }

    private int min = Integer.MAX_VALUE;
    private List<Integer> cutCount = new ArrayList<>();

    public int minCut(String s) {
        List<List<String>> result = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return 0;
        }

        List<String> partition = new ArrayList<String>();//track each possible partition
        int count = 0;
        addPalindrome(s, 0, partition, result, count);
        System.out.println("Number of cuts are: ");
        System.out.println(cutCount);
        return min;
    }

    /**
     * partition a string into substrings of palindrome
     */
    private void addPalindrome(String s, int start, List<String> partition,
                               List<List<String>> result, int count) {
        //stop condition
        if (start == s.length()) {
            List<String> temp = new ArrayList<String>(partition);
            result.add(temp);
            cutCount.add(count - 1);
            if (count - 1 < min) min = count - 1;
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (isPalindrome(str)) {
                partition.add(str);
                count++;
                addPalindrome(s, i, partition, result, count);
                partition.remove(partition.size() - 1);
                count--;
            }
        }
    }

    private boolean isPalindrome(String s) {
        int len = s.length() - 1;
        for (int i = 0; i <= len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i)) {
                return false;
            }
        }
        return true;
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

    //print array
    public static void printArray(int[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }
}
