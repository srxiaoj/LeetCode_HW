import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by thanksgiving on 4/23/16.
 */
public class ShortestWordDistance {
    public static void main(String[] args) {
        ShortestWordDistance obj = new ShortestWordDistance();
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(obj.shortestDistance(words, "coding", "makes"));

    }

    public int shortestDistance(String[] words, String word1, String word2) {
        int min = words.length - 1;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                index1 = i;
            } else if (word2.equals(words[i])) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                min = Math.min(Math.abs(index1 - index2), min);
            }
        }
        return min;
    }

    public int shortestDistance2(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) return -1;
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                map.put(words[i], newList);
            } else {
                List<Integer> oldList = map.get(words[i]);
                oldList.add(i);
                map.put(words[i], oldList);
            }
        }

        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < l1.size(); i++) {
            for (int j = 0; j < l2.size(); j++) {
                int dis = Math.abs(l1.get(i) - l2.get(j));
                if (dis < min) {
                    min = dis;
                }
            }
        }
        return min;
    }
}
