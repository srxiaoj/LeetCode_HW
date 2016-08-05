import java.util.*;

/**
 * Created by thanksgiving on 8/4/16.
 */
public class WordLadderII {
    public static void main(String[] args) {
        WordLadderII obj = new WordLadderII();
        String begin = "hit";
        String end = "cog";
        Set<String> wordList = new HashSet(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        System.out.println(obj.findLadders(begin, end, wordList));

        String begin2 = "a";
        String end2 = "c";
        Set<String> wordList2 = new HashSet(Arrays.asList("a", "b", "c"));
        System.out.println(obj.findLadders(begin2, end2, wordList2));

        String begin3 = "red";
        String end3 = "tax";
        Set<String> wordList3 = new HashSet(Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee"));
        System.out.println(obj.findLadders(begin3, end3, wordList3));
    }


    /**
     * 先用bfs 计算每个word到beginWord的最短长度和每个word能一步变换的单词list
     * 然后用这两个map去进行dfs求所有解
     */
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> distMap = new HashMap<>();
        Map<String, List<String>> map = new HashMap<>();

        wordList.add(endWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visit = new HashSet<>();
        visit.add(beginWord);
        int len = 1;
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            len++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String last = queue.poll();
                List<String> neighbors = new ArrayList<>();
                for (int j = 0; j < last.length(); j++) {
                    char[] temp = last.toCharArray();
                    for (char k = 'a'; k < 'z'; k++) {
                        temp[j] = k;
                        String next = new String(temp);
                        if (next.equals(endWord)) {
                            min = Math.min(len, min);
                        }
                        if (wordList.contains(next) && !visit.contains(next)) {
                            queue.offer(next);
                            distMap.put(next, len);
                        }
                        if (wordList.contains(next) && !neighbors.contains(next) && !next.equals(beginWord) && !next.equals(last)) {
                            neighbors.add(next);
                        }
                    }
                }
                map.put(last, neighbors);
                visit.addAll(neighbors);
            }
        }
        distMap.put(beginWord, 1);
        distMap.put(endWord, min);
        System.out.println(map);
        System.out.println(distMap);
        dfs(res, new ArrayList<>(), beginWord, endWord, map, distMap);
        return res;

    }

    private void dfs(List<List<String>> res, List<String> part, String cur, String endWord,
                     Map<String, List<String>> map, Map<String, Integer> distMap) {
        if (cur.equals(endWord)) {
            List<String> newPart = new ArrayList<>(part);
            newPart.add(endWord);
            res.add(newPart);
            return;
        }
        for (String next : map.get(cur)) {
            if (distMap.get(next) == distMap.get(cur) + 1) {
                List<String> newPart = new ArrayList<>(part);
                newPart.add(cur);
                dfs(res, newPart, next, endWord, map, distMap);
            }
        }
    }
}
