/**
 * Created by thanksgiving on 5/17/16.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();
        String[] s = {"aca", "cba"};
        System.out.println(obj.longestCommonPrefix(s));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }
        StringBuilder sb = new StringBuilder();
        outer:
        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    break outer;
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
