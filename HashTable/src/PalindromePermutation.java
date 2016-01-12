import java.util.HashMap;

/**
 * Created by thanksgiving on 1/10/16.
 */
public class PalindromePermutation {
    public static void main(String[] args) {
        PalindromePermutation obj = new PalindromePermutation();
        String a = "code";
        String b = "aab";
        System.out.println(obj.canPermutePalindrome(a));
        System.out.println(obj.canPermutePalindrome(b));
    }
    public boolean canPermutePalindrome(String s) {
        int n = s.length();
        if (s == null || n == 0) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        int oddCount = 0;
        for (Character c : map.keySet()) {
            if (map.get(c) % 2 != 0) {
                oddCount++;
                if (oddCount > 1)
                    return false;
            }
        }
        if (oddCount > 1 && n % 2 != 0)
            return false;
        return true;
    }
}
