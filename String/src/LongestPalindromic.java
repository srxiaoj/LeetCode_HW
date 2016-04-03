
public class LongestPalindromic {
    private int lo, maxLen;//used to store the start position of palindrome and current max length of palindrome
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "bbabbab";
        LongestPalindromic ob = new LongestPalindromic();
        System.out.println("The palindrome is: " + ob.longestPalindrome(test));

        String my = "aaabaaaa";
        System.out.println(ob.longestPalindrome(my));
    }
    private static int globalMax = 0;
    private static int start = 0;
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

    /*public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int n = s.length();
        lo = 0;
        for (int i = 0; i < n; i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }
        return s.substring(lo, lo+maxLen);
    }
    *//**
     * start comparing j and k, and then search j-1 and k+1, check if is palindrome
     * @param s
     * @param j
     * @param k
     *//*
    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        //check whether this is a new longer palindrome
        if (maxLen < k-j-1) {
            maxLen = k-j-1;//make this length as new longest length
            lo = j+1;//mark new position
        }
        
    }*/
}
