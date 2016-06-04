public class AddandSearchWord {
    public static void main(String[] args) {
        // Your WordDictionary object will be instantiated and called as such:
        WordDictionary wordDictionary = new WordDictionary();
        /*
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
        */

        wordDictionary.addWord("ran");wordDictionary.addWord("rune");wordDictionary.addWord("runner");wordDictionary.addWord("runs");
        wordDictionary.addWord("add");wordDictionary.addWord("adds");wordDictionary.addWord("adder");wordDictionary.addWord("addee");
        System.out.println(wordDictionary.search("r.n"));System.out.println(wordDictionary.search("ru.n.e"));
        System.out.println(wordDictionary.search("add"));System.out.println(wordDictionary.search("add."));
        System.out.println(wordDictionary.search("adde."));System.out.println(wordDictionary.search(".an."));
        System.out.println(wordDictionary.search("...s"));System.out.println(wordDictionary.search("....e."));
        System.out.println(wordDictionary.search("......."));System.out.println(wordDictionary.search("..n.r"));

    }
}

class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    private class TrieNode {
        private boolean hasWord = false;
        private TrieNode[] children = new TrieNode[26];
        private char val;

        public TrieNode() {
            this.val = ' ';
        }
        public TrieNode(char c) {
            this.val = c;
        }
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode(c);
            }
            cur = cur.children[c - 'a'];
        }
        cur.hasWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode cur = root;
        return helper(word, cur, 0);
    }

    private boolean helper(String word, TrieNode cur, int pos) {
        if (cur == null) return false;
        if (pos == word.length()) return cur.hasWord;
        char c = word.charAt(pos);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (helper(word, cur.children[i], pos + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            return helper(word, cur.children[c - 'a'], pos + 1);
        }

    }
}