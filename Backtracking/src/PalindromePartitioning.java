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
     * dfs, 每次判断s.substring(start, i)是不是palindrome， 是的话就添加到list中
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
