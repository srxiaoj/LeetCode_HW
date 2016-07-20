import java.util.HashMap;

/**
 * Created by thanksgiving on 1/1/16.
 */
public class LongestSubstringwithAtMostTwoDistinctCharacters {
    public static void main(String[] args) {
        LongestSubstringwithAtMostTwoDistinctCharacters obj = new LongestSubstringwithAtMostTwoDistinctCharacters();
        String s = "cabcccacacccbbcbb";
        System.out.println(obj.lengthOfLongestSubstringTwoDistinct2(s));
        System.out.println(obj.lengthOfLongestSubstringTwoDistinct(s));
    }

    /**
     * 方法1：搞一个map，256位，在每个character位统计character的个数，并且搞个num统计distinct number数量
     * 如果distinct number数量比k大，则不断从i开始减去开头的字符直到 num <= k为止
     */
    public int lengthOfLongestSubstringTwoDistinct2(String s) {
        int[] map = new int[256];
        int num = 0;
        int res = 0;
        int i = 0, j = 0;
        for (j = 0; j < s.length(); j++) {
            while (num > 2 && i < j) {
                map[s.charAt(i)]--;
                if (map[s.charAt(i)] == 0) num--;
                i++;
            }
            if (map[s.charAt(j)] == 0) num++;
            map[s.charAt(j)]++;

            if (num <= 2)
                res = Math.max(res, j - i + 1);
        }
        return res;
    }


    /**
     * 方法2
     */
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
