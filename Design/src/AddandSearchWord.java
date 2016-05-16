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
        return helper(cur, word, 0);
    }

    private boolean helper(TrieNode cur, String word, int pos) {
        if (cur == null) return false;
        if (pos == word.length()) return cur.hasWord;
        char c = word.charAt(pos);
        if (c != '.' && cur.children[c - 'a'] == null) {
            return false;
        }
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (helper(cur.children[i], word, pos + 1)) {
                    return true;
                }
            }
            return false;
        }
        return helper(cur.children[c - 'a'], word, pos + 1);

    }





   /* private class TrieNode {
        private boolean hasWord;
        private HashMap<Character, TrieNode> children;

        public TrieNode() {
            hasWord = false;
            children = new HashMap<Character, TrieNode>();
        }
    }

    private TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (!cur.children.containsKey(word.charAt(i))) {
                cur.children.put(word.charAt(i), new TrieNode());
            }
            cur = cur.children.get(word.charAt(i));
        }
        cur.hasWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchHelper(root, 0, word);
    }

    private boolean searchHelper(TrieNode node, int pos, String word) {
        //if the word has all been scanned, return
        if (pos == word.length()) {
            return node.hasWord;
        }
        //reach the leaf before finishing scanning the word
        if (node.children.size() == 0) {
            return false;
        }

        //if the character at current position is '.',
        //recursive check whether the remaing word is in the trie
        if (word.charAt(pos) == '.') {
            for (Character c : node.children.keySet()) {
                if (searchHelper(node.children.get(c), pos + 1, word)) {
                    return true;
                }
            }
        }

        //if character at position 'pos' is neither equal to the node nor '.', return false
        if (!node.children.containsKey(word.charAt(pos))) {
            return false;
        }

        //if character at current position matches the node,
        //recursively search the remaining word
        return searchHelper(node.children.get(word.charAt(pos)), pos + 1, word);
    }*/
}