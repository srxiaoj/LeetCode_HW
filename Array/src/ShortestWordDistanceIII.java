import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by thanksgiving on 4/23/16.
 */
public class ShortestWordDistanceIII {
    public static void main(String[] args) {
        ShortestWordDistanceIII obj = new ShortestWordDistanceIII();
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(obj.shortestWordDistance(words, "makes", "makes"));
    }

    public int shortestWordDistance(String[] words, String word1, String word2) {
        int min = words.length - 1;
        int index1 = -1, index2 = -1;
        boolean isWord1 = false;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i]) && (!isWord1 || !word1.equals(word2))) {
                index1 = i;
                isWord1 = true;
            } else if (word2.equals(words[i])) {
                index2 = i;
                isWord1 = false;
            }
            if (index1 != -1 && index2 != -1) {
                min = Math.min(Math.abs(index1 - index2), min);
            }
        }
        return min;
    }


    /**
     * III 与 I唯一的区别就是在计算最小距离时，因为 I 不允许重复，那么不会出现 min = 0的情况
     * 但是III允许重复，那么则要在更新 min 的值的时候，去掉 val = 0的情况
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int shortestWordDistance2(String[] words, String word1, String word2) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            } else {
                map.get(words[i]).add(i);
            }
        }
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        return getMin(list1, list2);
    }
    private int getMin(List<Integer> list1, List<Integer> list2) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                int val = Math.abs(list1.get(i) - list2.get(j));
                if (min > val && val != 0.0) {
                    min = val;
                }
            }
        }
        return min;
    }
}
