import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 12/28/15.
 */
public class PalindromePartitioningII {
    public static void main(String[] args){
        PalindromePartitioningII obj = new PalindromePartitioningII();
        String test = "ababababababababababaababababababababababaababababababababababa";
//        System.out.println(obj.minCut(test));
        System.out.println(obj.minCutDynamicProgramming(test));
    }

    public int minCutDynamicProgramming(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
//                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                    if (j == 0) {
                        min = 0;
                    } else {
                        min = Math.min(min, cut[j - 1] + 1);
                    }
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
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
     * @param s
     * @param start
     * @param partition
     * @param result
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
}
