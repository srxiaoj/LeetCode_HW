import java.util.HashMap;

/**
 * Created by thanksgiving on 1/1/16.
 */
public class LongestSubstringwithAtMostTwoDistinctCharacters {
    public static void main(String[] args) {
        LongestSubstringwithAtMostTwoDistinctCharacters obj = new LongestSubstringwithAtMostTwoDistinctCharacters();
        String s = "cabcccacacccbbcbb";
        System.out.println(obj.lengthOfLongestSubstringTwoDistinct(s));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        int i = 0, j = 1;
        String pattern = new String();
        int max = Integer.MIN_VALUE;
        HashMap<String, Integer> map = new HashMap<>();

        // if the latter is the same character as previous one
        while (j < s.length() && s.charAt(i) == s.charAt(j)) {
            j++;
        }
        if (j == s.length()) {
            return s.length();
        }
        pattern = s.substring(j - 1, j + 1);

        while (j < s.length()) {

            if (!map.containsKey(pattern)) {
                map.put(pattern, j - i + 1);
            }
            j++;
            while (j < s.length() && pattern.contains(Character.toString(s.charAt(j)))) {
                j++;
                map.put(pattern, map.get(pattern) + 1);
            }
            max = Math.max(max, map.get(pattern));
            if (j == s.length()) return max;
            //reset the counter
            map.remove(pattern);
            pattern = s.substring(j - 1, j + 1);
            // go back and find the first i
            i = j - 1;
            while (i - 1 >= 0 && s.charAt(i - 1) == s.charAt(i)) {
                i--;
            }

        }
        return max;
    }
}
