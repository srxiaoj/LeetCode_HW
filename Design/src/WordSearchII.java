import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 6/8/16.
 */
public class WordSearchII {
    public static void main(String[] args) {
        WordSearchII obj = new WordSearchII();
        char[][] board = {{'a', 'b'},
                           {'c', 'd'}};
        String[] words = {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};
        List<String> res = obj.findWords(board, words);
        System.out.println(res);
    }

    class Trie {
        char val;
        Trie[] children = new Trie[26];
        boolean hasWord = false;
        public Trie(char c) {
            this.val = c;
        }
    }
    Trie root;
    private void addWord(String word) {
        Trie cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Trie(c);
            }
            cur = cur.children[c - 'a'];
        }
        cur.hasWord = true;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || words == null || board.length == 0 || words.length == 0) return res;
        root = new Trie(' ');
        for (String word : words) {
            addWord(word);
        }
        int m = board.length, n = board[0].length;
        boolean visit[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                helper(board, i, j, res, root, "", visit);
            }
        }
        return res;
    }

    private void helper(char[][] board, int i, int j, List<String> res, Trie node, String part, boolean[][] visit) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || node.children[board[i][j] - 'a'] == null || visit[i][j]) return;
        char c = board[i][j];
        part += board[i][j];
        node = node.children[c - 'a'];
        if (node.hasWord) {
            if (!res.contains(part)) {
                res.add(part);
            }
        }
        visit[i][j] = true;
        helper(board, i + 1, j, res, node, part, visit);
        helper(board, i - 1, j, res, node, part, visit);
        helper(board, i, j + 1, res, node, part, visit);
        helper(board, i, j - 1, res, node, part, visit);
        visit[i][j] = false;
    }
}
