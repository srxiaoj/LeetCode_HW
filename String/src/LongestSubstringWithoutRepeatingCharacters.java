import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String test = "abcdbcdbggcdea";
        System.out.println(lengthOfLongestSubstring(test));
    }
    public static int lengthOfLongestSubstring(String s) {
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



        /**
         * O(N^2)
         * 每次添加新字符时判断该字符是否已经存在，存在则达到该起始点 i 所能达到的最大长度
         * 起始点+1
         */
        /*if (s == null || s.length() == 0) return 0;
        int max = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            int start = i + 1;
            while (start < s.length() && !s.substring(i, start).contains(String.valueOf(s.charAt(start)))) {
                start++;
            }
            if (max < s.substring(i, start).length()) {
                max = s.substring(i, start).length();
            }
        }
        return max;*/
    }
}
