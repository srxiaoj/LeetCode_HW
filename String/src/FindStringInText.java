import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 4/8/16.
 */
public class FindStringInText {
    public static void main(String[] args) {
        String text = "this is a car, taken good care of, be careful, this car is expensive";
        List<Integer> pos = getPos(text, "is");
        System.out.println(pos);
    }

    private static class Trie {
        Trie[] next = new Trie[26];
        List<Integer> pos = new ArrayList<>();
        char val;
        public Trie(char val) {
            this.val = val;
        }

    }

    /**
     * First construct the trie, starting with ' ' root, make a copy, then root.next[c - 'a'] point to next level
     * 需要判断 root.next[c - 'a'] 是否为null
     * if finish looping one word, note down the position
     * @param text
     * @param target
     * @return
     */
    public static List<Integer> getPos(String text, String target) {
        text = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        String[] texts = text.split(" ");
        // construct trie with root.val = ' '
        Trie root = new Trie(' ');
        Trie copy = root;
        for (int i = 0; i < texts.length; i++) {
            for (int j = 0; j < texts[i].length(); j++) {
                char c = texts[i].charAt(j);
                if (root.next[c - 'a'] == null) {
                    root.next[c - 'a'] = new Trie(c);
                }
                root = root.next[c - 'a'];
                // only update the position at the last char of this word
                if (j == texts[i].length() - 1) {
                    root.pos.add(i);
                }
            }
            root = copy;
        }
        // search target in trie
        for (char c : target.toCharArray()) {
            if (copy.next[c - 'a'] == null) {
                return new ArrayList<>();
            } else {
                copy = copy.next[c - 'a'];
            }
        }
        return copy.pos;
    }
}
