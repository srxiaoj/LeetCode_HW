import java.util.HashMap;
import java.util.Map;


class TrieNode {
    TrieNode[] children;
    boolean isWord;
    int numOfWords;

    public TrieNode() {
        this.children = new TrieNode[26];
    }
}

public class WordAbbreviation2 {
    public static void main(String[] args) {
//		String[] strs = {"aaaaa", "aabaa", "aaaca", "god", "geed"};
//		String[] strs = {"like", "god",  "internal", "me", "internet", "internel", "intension", "intensio", "face", "intrusion"};
        String[] strs = {"internet", "interval", "intension"};
        WordAbbreviation2 so = new WordAbbreviation2();
        String[] result = so.Encode(strs);
        for (String s : result) {
            System.out.print(s + " ");
        }
    }

    public void insert(String s, TrieNode root) {
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
            node.numOfWords++;
        }
    }

    public String searchPrefix(String s, TrieNode root) {
        TrieNode node = root;
        String prefix = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (node.children[c - 'a'] != null) {
                node = node.children[c - 'a'];
            }
            prefix += c;
            if (node.numOfWords == 1) return prefix;
        }
        return prefix;
    }

    /* assume no duplicate in string array.*/
    public String[] Encode(String[] strs) {

        Map<Integer, TrieNode> wordDict = new HashMap<Integer, TrieNode>();
        String[] encodeStrs = new String[strs.length];

        // Build trie.
        for (int i = 0; i < strs.length; i++) {
            int len = strs[i].length();
            if (!wordDict.containsKey(len)) {
                TrieNode root = new TrieNode();
                wordDict.put(len, root);
            }
            insert(strs[i], wordDict.get(len));
        }
        // compress each string.
        for (int i = 0; i < strs.length; i++) {

            int len = strs[i].length();
            String prefix = searchPrefix(strs[i], wordDict.get(len));
            if (prefix.length() + 2 < len) encodeStrs[i] = prefix + "" + len + strs[i].charAt(len - 1);
            else encodeStrs[i] = strs[i];
        }

        return encodeStrs;

    }
}