
public class LongestPalindromic {
    private int lo, maxLen;//used to store the start position of palindrome and current max length of palindrome
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "bb";
        LongestPalindromic ob = new LongestPalindromic();
        System.out.println("The palindrome is: " + ob.longestPalindrome(test));
    }
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int n = s.length();
        lo = 0;
        for (int i = 0; i < n; i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }
        return s.substring(lo, lo+maxLen);
    }
    /**
     * start comparing j and k, and then search j-1 and k+1, check if is palindrome
     * @param s
     * @param j
     * @param k
     */
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
        
    }
}
