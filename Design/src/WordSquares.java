import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/22.
 */
public class WordSquares {
    public static void main(String[] args) {
        WordSquares obj = new WordSquares();
        System.out.println(obj.wordSquares(new String[]{"area", "lead", "wall", "lady", "ball"}));
    }

    /**
     * https://discuss.leetcode.com/topic/63516/explained-my-java-solution-using-trie-126ms-16-16
     * @param words
     * @return
     */
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        int n = words[0].length();
        Trie trie = new Trie(words);
        List<String> list = new ArrayList<>();
        for (String w : words) {
            list.add(w);
            dfs(n, trie, res, list);
            list.remove(list.size() - 1);
        }
        return res;
    }

    private void dfs(int len, Trie trie, List<List<String>> ans, List<String> list) {
        if (list.size() == len) {
            ans.add(new ArrayList<>(list));
            return;
        }

        int i = list.size();
        StringBuilder prefixBuilder = new StringBuilder();
        for (String s : list)
            prefixBuilder.append(s.charAt(i));
        List<String> possibleWords = trie.findByPrefix(prefixBuilder.toString());
        for (String w : possibleWords) {
            list.add(w);
            dfs(len, trie, ans, list);
            list.remove(list.size() - 1);
        }
    }

    class TrieNode {
        List<String> startWith;
        TrieNode[] children;

        public TrieNode() {
            startWith = new ArrayList<>();
            children = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root;

        public Trie(String[] words) {
            root = new TrieNode();
            for (String w : words) {
                TrieNode cur = root;
                for (char c : w.toCharArray()) {
                    int i = c - 'a';
                    if (cur.children[i] == null)
                        cur.children[i] = new TrieNode();
                    cur.children[i].startWith.add(w);
                    cur = cur.children[i];
                }
            }
        }

        public List<String> findByPrefix(String prefix) {
            List<String> ans = new ArrayList<>();
            TrieNode cur = root;
            for (char c : prefix.toCharArray()) {
                int i = c - 'a';
                if (cur.children[i] == null)
                    return ans;

                cur = cur.children[i];
            }
            ans.addAll(cur.startWith);
            return ans;
        }
    }
}
