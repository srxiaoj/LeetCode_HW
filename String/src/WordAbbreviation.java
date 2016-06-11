import java.util.HashMap;
import java.util.Map;

/**
 * Created by thanksgiving on 6/11/16.
 */
public class WordAbbreviation {
    public static void main(String[] args) {
        /**
         * l4e god internal me internet internel inte9n inten8o f4e intr9n
         */
//        String[] strs = {"aaaaa", "aabaa", "aaaca", "god", "geed"};
        String[] strs = {"like", "god", "internal", "me", "internet", "internel", "intension", "intensio", "face", "intrusion"};
//        String[] strs = {"internet", "interval", "intension"};
        WordAbbreviation obj = new WordAbbreviation();
        String[] result = obj.encode(strs);
        printArray(result);
    }


    /**
     * 根据每个不同长度的单词来建不同的tree，长度不相同的单词互相不干扰
     * 长度相同的单词取最后一个不为s.length() - 1的分割点进行分隔
     * 如果最后单词等于或者大于原来s的长度则返回原来单词
     */
    public String[] encode(String[] strs) {
        if (strs == null || strs.length == 0) return new String[0];
        Map<Integer, Trie> map = new HashMap<>();
        for (String s : strs) {
            Trie root;
            if (!map.containsKey(s.length())) {
                root = new Trie(' ');
            } else {
                root = map.get(s.length());
            }
            add(root, s);
            map.put(s.length(), root);
        }

        String[] res = new String[strs.length];
        int k = 0;
        outer:
        for (String s : strs) {
            int n = s.length();
            Trie cur = map.get(s.length());
            int lastSplitIndex = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (cur.val != ' ' && cur.activeChildrenNumber != 1) {
//                    if (i != s.length() - 1) {
                        lastSplitIndex = i;
//                    }
                }
                cur = cur.children[s.charAt(i) - 'a'];
            }
            if (lastSplitIndex != 0) {
                sb.append(s.substring(0, lastSplitIndex + 1)).append(n).append(s.charAt(n - 1));
//                System.out.println(sb.toString());
                if (sb.length() >= n) {
                    res[k] = s;
                } else {
                    res[k] = sb.toString();
                }
            } else {
                res[k] = simplify(s);
            }
            k++;
        }
        return res;
    }

    private String simplify(String s) {
        if (s.length() <= 3) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0)).append(s.length()).append(s.charAt(s.length() - 1));
        return sb.toString();
    }


    class Trie {
        char val;
        Trie[] children = new Trie[26];
        int activeChildrenNumber = 0;

        public Trie(char c) {
            this.val = c;
        }
    }

    private void add(Trie root, String s) {
        Trie cur = root;
        for (char c : s.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Trie(c);
                cur.activeChildrenNumber++;
            }
            cur = cur.children[c - 'a'];
        }
    }

    //print array
    public static void printArray(String[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }
}
