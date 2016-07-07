/**
 * Created by thanksgiving on 6/12/16.
 */
public class LongestSubstringwithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        String s = "abbcabdac";
        System.out.println(lengthOfLongestSubstringKDistinct(s, 2));

    }

    /**
     * 搞一个map，256位，在每个character位统计character的个数，并且搞个num统计distinct number数量
     * 如果distinct number数量比k大，则不断从i开始减去开头的字符直到 num <= k为止
     */
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] map = new int[256];
        int num = 0;
        int res = 0;
        int i = 0, j = 0;
        for (j = 0; j < s.length(); j++) {
            while (num > k && i < j) {
                map[s.charAt(i)]--;
                if (map[s.charAt(i)] == 0) num--;
                i++;
            }
            if (map[s.charAt(j)] == 0) num++;
            map[s.charAt(j)]++;

            if (num <= k)
                res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
