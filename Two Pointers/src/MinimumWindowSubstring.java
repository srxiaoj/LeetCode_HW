import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.minWindow("ADOBECODEBANCS", "ABC"));
        System.out.println(obj.minWindow("a", "a"));
        System.out.println(obj.minWindow("bbaac", "aba"));
    }

    int initTargetHash(int[] targethash, String Target) {
        int num = 0;
        for (char c : Target.toCharArray()) {
            num++;
            targethash[c]++;
        }
        return num;
    }

    public String minWindow(String Source, String Target) {
        // queueing the position that matches the char in T
        int min = Integer.MAX_VALUE;
        String minStr = "";

        int[] targethash = new int[256];

        int targetnum = initTargetHash(targethash, Target);
        int sourcenum = 0;
        int i = 0, j = 0;
        while (j < Source.length()) {
            if (targethash[Source.charAt(j)] > 0)
                sourcenum++;

            targethash[Source.charAt(j)]--;
            while (sourcenum >= targetnum) {
                if (min > j - i + 1) {
                    min = Math.min(min, j - i + 1);
                    minStr = Source.substring(i, j + 1);
                }
                targethash[Source.charAt(i)]++;
                if (targethash[Source.charAt(i)] > 0)
                    sourcenum--;
                i++;
            }
            j++;
        }
        return minStr;
    }


    /**
     * 方法2：用两个hashMap去查是否target在source中 O(s.length() * t.length())
     */
    public String minWindow2(String s, String t) {
        Map<Character, Integer> sourceMap = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (!targetMap.containsKey(c)) {
                targetMap.put(c, 1);
            } else {
                int count = targetMap.get(c);
                targetMap.put(c, count + 1);
            }
        }
        int min = Integer.MAX_VALUE;
        String res = "";
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && !isValid(targetMap, sourceMap)) {
                char c = s.charAt(j);
                if (!sourceMap.containsKey(c)) {
                    sourceMap.put(c, 1);
                } else {
                    int count = sourceMap.get(c);
                    sourceMap.put(c, count + 1);
                }
                j++;
            }

            // 需要把isValid 条件也加上，防止是因为 j == s.length() 跳出while循环
            if (min > j - i && j <= s.length() && isValid(targetMap, sourceMap)) {
                res = s.substring(i, j);
                min = j - i;
            }
            int count = sourceMap.get(s.charAt(i));
            count--;
            if (count == 0) {
                sourceMap.remove(s.charAt(i));
            } else {
                sourceMap.put(s.charAt(i), count);
            }
        }
        return res;
    }


    private boolean isValid(Map<Character, Integer> targetMap, Map<Character, Integer> sourceMap) {
        for (Character key : targetMap.keySet()) {
            if (!sourceMap.containsKey(key)) {
                return false;
            } else {
                int targetCount = targetMap.get(key);
                int sourceCount = sourceMap.get(key);
                // 只要source里面的字母比target里的字母多就可以，不必相等
                if (targetCount > sourceCount) {
                    return false;
                }
            }
        }
        return true;
    }
}
