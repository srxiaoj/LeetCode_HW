/**
 * Created by thanksgiving on 9/5/16.
 */
public class LongestSubstringwithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(longestSubstring("ababbc", 2));
        System.out.println(longestSubstring("abacbb", 2));
    }

    /**
     * 找到出现次数最少的那个char，以它分割string，再分别对substring找最大的长度
     */
    public static int longestSubstring(String s, int k) {
        if (s.length() == 0 || k == 1) return s.length();
        if (s.length() < k) return 0;

        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        boolean eligible = true;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0 && count[i] < k) {
                eligible = false;
                break;
            }
        }
        if (eligible) return s.length();

        printArray(count);
        char least = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0 && least == 0) {
                least = (char) (i + 'a');
                continue;
            }
            if (count[i] != 0 && count[i] < count[least - 'a']) {
                least = (char) (i + 'a');
            }
        }
        String[] sub = s.split(least + "");
        int res = 0;
        for (String str : sub) {
            res = Math.max(res, longestSubstring(str, k));
        }
        return res;
    }

    //print array
    public static void printArray(int[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }
}
