import java.util.*;

/**
 * Created by thanksgiving on 8/4/16.
 */
public class SubstringwithConcatenationofAllWords {
    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoofoobarfooman", new String[]{"foo", "bar", "foo"})); // [9, 12]
        System.out.println(findSubstring("barfoofoobarthefoobarman", new String[]{"foo", "bar", "the"})); // [6, 9, 12]
        System.out.println(findSubstring("sheateateseatea", new String[]{"sea", "tea", "ate"}));          // [6]
        System.out.println(findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo", "barr", "wing", "ding", "wing"}));  // [13]
        System.out.println(findSubstring("aaaaaaaa", new String[]{"aa", "aa", "aa"}));    // [0, 1, 2]
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        List<Integer> indexes = new ArrayList<Integer>(s.length());
        if (words.length == 0) {
            return indexes;
        }
        int k = words[0].length();
        if (n < k * words.length) {
            return indexes;
        }
        int last = n - k + 1;

        //map each string in words array to some index and compute target counters
        Map<String, Integer> map = new HashMap<String, Integer>(words.length);
        int [][] table = new int[2][words.length];
        int failures = 0, index = 0;
        for (int i = 0; i < words.length; ++i) {
            Integer mapped = map.get(words[i]);
            if (mapped == null) {
                ++failures;
                map.put(words[i], index);
                mapped = index++;
            }
            ++table[0][mapped];
        }

        //find all occurrences at string S and map them to their current integer, -1 means no such string is in words array
        int [] smapping = new int[last];
        for (int i = 0; i < last; ++i) {
            String section = s.substring(i, i + k);
            Integer mapped = map.get(section);
            if (mapped == null) {
                smapping[i] = -1;
            } else {
                smapping[i] = mapped;
            }
        }

        //fix the number of linear scans
        for (int i = 0; i < k; ++i) {
            //reset scan variables
            int currentFailures = failures; //number of current mismatches
            int left = i, right = i;
            Arrays.fill(table[1], 0);
            //here, simple solve the minimum-window-substring problem
            while (right < last) {
                while (currentFailures > 0 && right < last) {
                    int target = smapping[right];
                    if (target != -1 && ++table[1][target] == table[0][target]) {
                        --currentFailures;
                    }
                    right += k;
                }
                while (currentFailures == 0 && left < right) {
                    int target = smapping[left];
                    if (target != -1 && --table[1][target] == table[0][target] - 1) {
                        int length = right - left;
                        //instead of checking every window, we know exactly the length we want
                        if ((length / k) ==  words.length) {
                            indexes.add(left);
                        }
                        ++currentFailures;
                    }
                    left += k;
                }
            }

        }
        return indexes;
    }

    public static List<Integer> findSubstring2(String s, String[] words) {
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
                        j++;
                    } else {
                        j += k;
                    }
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
                // 如果上一个j不match,j只能加一，不能加k
                j++;
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
