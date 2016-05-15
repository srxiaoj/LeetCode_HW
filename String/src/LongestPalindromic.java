
public class LongestPalindromic {
    public static void main(String[] args) {
        String test = "bbabbab";
        LongestPalindromic ob = new LongestPalindromic();
        System.out.println("The palindrome is: " + ob.longestPalindrome(test));

        String my = "aaabaaaa";
        System.out.println(ob.longestPalindrome(my));
    }
    private int globalMax = 0;
    private int start = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        for (int i = 0; i < s.length(); i++) {
            findMaxLen(s, i, i);
            findMaxLen(s, i, i+1);
        }
        return s.substring(start, start + globalMax);
    }

    private void findMaxLen(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(r) == s.charAt(l)) {
            l--;
            r++;
        }
        if (globalMax < r - l - 1) {
            globalMax = r - l - 1;
            start = l + 1;
        }
    }
}
