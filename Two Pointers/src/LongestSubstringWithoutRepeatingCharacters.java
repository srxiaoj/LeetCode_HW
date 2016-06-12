import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String test = "abcdbcdbggcdea";
        System.out.println(lengthOfLongestSubstring(test));
    }


    /**
     * 如果发现当前字符为重复字符，则将当前字符前所有字符都清空，最后再将当前字符重新放回
     */
    public static int lengthOfLongestSubstring(String s) {
        int[] map = new int[256]; // map from character's ASCII to its last occured index
        int i = 0;
        int j = 0;
        int res = 0;
        for (j = 0; j < s.length(); j++) {
            while (map[s.charAt(j)] != 0 && i < j) {
                map[s.charAt(i)] = 0;
                i++;
            }
            map[s.charAt(j)] = 1;
            res = Math.max(res, j - i + 1);
        }

        return res;
    }

    public static int lengthOfLongestSubstring2(String s) {
        /**
         * O(N)
         * i 记录unique index的位置
         * start 为最后一个重复的char之后的index
         * i - start + 1则为两个相同char之间的unique字符串的长度
         */
        if (s.length() == 0) return 0;
        //keep a hashmap which stores the characters in string as keys and their positions as values
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // start 为最后一个重复的char之后的index, 所以要用Math.max
                start = Math.max(start, map.get(s.charAt(i)) + 1);
//                start = map.get(s.charAt(i)) + 1;
            }
            //else put in map and get max pointer update with the current longest string
            map.put(s.charAt(i), i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
