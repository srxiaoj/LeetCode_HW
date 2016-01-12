import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "tmmzuxt";
        
        System.out.println(lengthOfLongestSubstring(test));
    }
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int i = 0, j = 0, count = 0;
        while (i < s.length() && j < s.length()) {
            if (!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), j);
                j++;
                count++;
            } else {
                int previousPosition = map.get(s.charAt(j)); // get the index of match character
                if (previousPosition >= i) { // if the match character is after the new starting index i, then update i
                    map.put(s.charAt(j), j); // update the new character position
                    i = previousPosition + 1;
                    count = j - i + 1;
                    j++;
                } else { // if the match character is before the new starting index i, then update this character position
                    map.put(s.charAt(j), j); // update the new character position
                    count++;
                    j++;
                }
            }
            max = Math.max(max,  count);
        }
        return max;
    }
}
