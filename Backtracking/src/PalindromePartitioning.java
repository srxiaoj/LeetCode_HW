import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 12/28/15.
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        PalindromePartitioning obj = new PalindromePartitioning();
        String test = "aabcb";
        System.out.println(obj.isPalindrome(test));
        System.out.println(obj.palindromePartitioning(test));
//        System.out.println(obj.partition(test));
    }

    /**
     * dynamic programming
     *
     * @param s
     * @return
     */
    public static List<List<String>> palindromePartitioning(String s) {
        int len = s.length();
        List<List<String>>[] result = new List[len + 1];
        result[0] = new ArrayList<List<String>>();
        result[0].add(new ArrayList<String>());
        // pair stores the result that whether a range of string is a palindrome or not
        // pair[0][1] is true means that s.substring(0, 2) is a palindrome
        boolean[][] pair = new boolean[len][len];
        for (int i = 0; i < s.length(); i++) {
            result[i + 1] = new ArrayList<List<String>>();
            for (int left = 0; left <= i; left++) {
                // core step, determine whether this is a palindrome
                // only if the two side chars are equal and the sequence in the middle is palindrome
                if (s.charAt(left) == s.charAt(i) && (i - left <= 1 || pair[left + 1][i - 1])) {
                    pair[left][i] = true;
                    String str = s.substring(left, i + 1);
                    for (List<String> r : result[left]) {
                        List<String> ri = new ArrayList<String>(r);
                        ri.add(str);
                        result[i + 1].add(ri);
                    }
                }
            }
        }
        return result[len];
    }

    /**
     * dfs
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return result;
        }

        List<String> partition = new ArrayList<String>();//track each possible partition
        addPalindrome(s, 0, partition, result);
//        partitionStr(s, 0, partition, result);
        return result;
    }

    /**
     * partition a string into substrings of palindrome
     *
     * @param s
     * @param start
     * @param partition
     * @param result
     */
    private void addPalindrome(String s, int start, List<String> partition,
                               List<List<String>> result) {
        //stop condition
        if (start == s.length()) {
            List<String> temp = new ArrayList<String>(partition);
            result.add(temp);
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (isPalindrome(str)) {
                partition.add(str);
                addPalindrome(s, i, partition, result);
                partition.remove(partition.size() - 1);
            }
        }
    }

    /**
     * partition a string into substrings
     *
     * @param s
     * @param start
     * @param partition
     * @param result
     */
    private void partitionStr(String s, int start, List<String> partition, List<List<String>> result) {
        //stop condition
        if (start == s.length()) {
            List<String> temp = new ArrayList<String>(partition);
            result.add(temp);
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            partition.add(str);
            partitionStr(s, i, partition, result);
            partition.remove(partition.size() - 1);
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
