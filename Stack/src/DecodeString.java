import java.util.Stack;

/**
 * Created by thanksgiving on 9/5/16.
 */
public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("leetcode"));
        System.out.println(decodeString("2[abc]xyc3[z]"));
    }

    public static String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        int n = s.length();
        int num = 0;
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        Stack<String> letter = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                if (sb.length() > 0) {
                    letter.add(sb.toString());
                    sb = new StringBuilder();
                }
                stack.add(num);
                num = 0;
            } else if (Character.isLetter(c)) {
                sb.append(c);
            } else { // c = ']'
                StringBuilder build = new StringBuilder();
                int count = stack.pop();
                String toAdd;
                if (sb.length() == 0) {
                    toAdd = letter.pop();
                } else {
                    toAdd = sb.toString();
                }
                for (int j = 0; j < count; j++) {
                    build.append(toAdd);
                }
                if (!letter.isEmpty()) {
                    String last = letter.pop();
                    last += build.toString();
                    letter.add(last);
                } else {
                    letter.add(build.toString());
                }
                sb = new StringBuilder();
            }
        }


        if (letter.isEmpty()) {
            return sb.toString();
        }
        String res = "";
        for (String sub : letter) {
            res += sub;
        }
        if (s.charAt(n - 1) != ']') {
            res += sb.toString();
        }
        return res;
    }
}
