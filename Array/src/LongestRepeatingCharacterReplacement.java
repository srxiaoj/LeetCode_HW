/**
 * Created by Administrator on 2016/10/21.
 */
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
//        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AAABABBA", 1));
    }

    /**
     * The initial step is to extend the window to its limit, that is, the longest we can get to with maximum number of modifications.
     * Until then the variable start will remain at 0. Then as end increase, the whole substring from 0 to end will violate the rule,
     * so we need to update start accordingly (slide the window). We move start to the right until the whole string satisfy the constraint again.
     * Then each time we reach such situation, we update our max length.
     *
     * max是当前最大的重复char数，如果i 到 j所有的character都相同，那么j - i + 1 == max, 所以j - i + 1 - max代表的就是i到j所不同的char数
     * 如果这个j - i + 1 - max > k, 那么需要将i往右移
     */
    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int[] map = new int[26];
        int i = 0, max = 0, maxLength = 0;
        for (int j = 0; j < n; j++) {
            map[s.charAt(j) - 'A']++;
            max = Math.max(max, map[s.charAt(j) - 'A']);

            while (j - i + 1 - max > k) {
                map[s.charAt(i) - 'A']--;
                i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }
}
