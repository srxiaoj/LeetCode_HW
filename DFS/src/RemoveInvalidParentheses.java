import java.util.*;

/**
 * Created by thanksgiving on 8/15/16.
 */
public class RemoveInvalidParentheses {
    public static void main(String[] args) {
//        System.out.println(removeInvalidParentheses(")(()("));
//        System.out.println(removeInvalidParentheses("()()))()"));
        System.out.println(removeInvalidParenthesesBFS("()()))()"));
    }

    public static List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    /**
     * 先从左到右移除多余的')', 然后从右到左移除多余的'('
     */
    public static void remove(String s, List<String> res, int last_i, int last_j, char[] pair) {
        int stack = 0;
        for (int i = last_i; i < s.length(); i++) {
            if (s.charAt(i) == pair[0]) stack++;
            if (s.charAt(i) == pair[1]) stack--;
            if (stack >= 0) continue;
            for (int j = last_j; j <= i; j++) {
                // only remove the first occurance
                if (s.charAt(j) == pair[1] && (j == last_j || s.charAt(j - 1) != pair[1]))
                    remove(s.substring(0, j) + s.substring(j + 1), res, i, j, pair);
            }
            return;
        }

        String reversed = new StringBuilder(s).reverse().toString();
        if (pair[0] == '(') {// finished left to right
            remove(reversed, res, 0, 0, new char[]{')', '('});
        } else {// finished right to left
            res.add(reversed);
        }
    }


    public static List<String> removeInvalidParenthesesBFS(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        // initialize
        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            s = queue.poll();

            if (isValid(s)) {
                // found an answer, add to the result
                res.add(s);
                found = true;
            }

            if (found) continue;

            // generate all possible states
            for (int i = 0; i < s.length(); i++) {
                // we only try to remove left or right paren
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

                String t = s.substring(0, i) + s.substring(i + 1);

                if (!visited.contains(t)) {
                    // for each state, if it's not visited, add it to the queue
                    queue.add(t);
                    visited.add(t);
                }
            }
        }
        return res;
    }

    // helper function checks if string s contains valid parantheses
    private static boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }
        return count == 0;
    }
}
