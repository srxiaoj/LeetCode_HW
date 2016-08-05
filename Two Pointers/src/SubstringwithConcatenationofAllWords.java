import java.util.*;

/**
 * Created by thanksgiving on 8/4/16.
 */
public class SubstringwithConcatenationofAllWords {
    public static void main(String[] args) {
//        System.out.println(findSubstring("barfoothefoofoobarfooman", new String[]{"foo", "bar", "foo"}));
//        System.out.println(findSubstring("barfoofoobarthefoobarman", new String[]{"foo", "bar", "the"}));
//        System.out.println(findSubstring("sheateateseatea", new String[]{"sea", "tea", "ate"}));
        System.out.println(findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo", "barr", "wing", "ding", "wing"}));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, i);
                i++;
            }
        }
        int[] array = new int[map.size()];
        int targetHash = init(words, array, map);

        int len = words.length;
        int k = words[0].length();
        int num = 0;
        int j = 0;
        i = 0;
        while (j + k <= s.length()) {
            String sub = s.substring(j, j + k);
            if (map.get(sub) != null) {
                if (array[map.get(sub)] > 0) {
                    num++;
                    array[map.get(sub)]--;
                    if (num == targetHash) {
                        res.add(j + k - len * k);
                        i = j + k - len * k;
                    }
                    j += k;
                } else {
                    array[map.get(sub)]--;
                    num++;

                    while (i < j && array[map.get(sub)] != 0) {
                        if (map.containsKey(s.substring(i, i + k))) {
                            array[map.get(s.substring(i, i + k))]++;
                            num--;
                            if (array[map.get(s.substring(i, i + k))] == 0) {
                                if (num == targetHash) {
                                    res.add(j + k - len * k);
                                }
                            }
                        }
                        i += k;
                    }
                    j += k;
                }
            } else {
                num = 0;
                init(words, array, map);
                j += k;
            }
        }
        return res;
    }

    private static int init(String[] words, int[] array, Map<String, Integer> map) {
        int targetHash = 0;
        Arrays.fill(array, 0);
        for (String s : words) {
            targetHash++;
            array[map.get(s)]++;
        }
        return targetHash;
    }
}
