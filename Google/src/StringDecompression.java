import java.util.Stack;

/**
 * 上来大概问了5分钟background然后直接上题，一个string decompression的题。。不知道是不是原题反正没见过。。题目如下
 * 2[abc]3[a]c => abcabcabcaaac;     2[ab3[d]]2[cc] => abdddabdddcc
 * 输入                   输出
 * 然后follow-up问的是不要输出string而是输出解压后的K-th character，主要也还是嵌套情况就从内到外把疙瘩解开以后再算。
 * 然后我问俩问题就结束了。整体感觉妹子面试官人很nice 反应很快而且不是特别picky的那种。
 */
public class StringDecompression {
    public static void main(String[] args) {
        System.out.println(stringDecompression("10[a]2[abc]e"));
        System.out.println(stringDecompression("3[2[de]f]"));
        System.out.println(stringDecompressionFollowUp("3[2[de]f]", 10));
    }

    public static String stringDecompression(String s) {
        Stack<String> stack = new Stack<>();
        String res = "";
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
                stack.add(sb.toString());
            } else if (c == '[') {
                continue;
            } else if (c == ']') {
                String last = stack.peek();
                String part = "";
                while (Character.isLetter(last.charAt(0))) {
                    part = last + part;
                    stack.pop();
                    last = stack.peek();
                }
                int count = Integer.parseInt(stack.pop());
                String newPart = "";
                for (int j = 0; j < count; j++) {
                    newPart += part;
                }
                if (stack.isEmpty()) {
                    res += newPart;
                } else {
                    stack.add(newPart);
                }
            } else { // letter
                stack.add(String.valueOf(c));
            }
            i++;
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static char stringDecompressionFollowUp(String s, int k) {
        Stack<String> stack = new Stack<>();
        String res = "";
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
                stack.add(sb.toString());
            } else if (c == '[') {
                continue;
            } else if (c == ']') {
                String last = stack.peek();
                String part = "";
                while (Character.isLetter(last.charAt(0))) {
                    part = last + part;
                    stack.pop();
                    last = stack.peek();
                }
                int count = Integer.parseInt(stack.pop());
                String newPart = "";
                for (int j = 0; j < count; j++) {
                    newPart += part;
                }
                if (stack.isEmpty()) {
                    res += newPart;
                    if (res.length() >= k) {
                        return res.charAt(k - 1);
                    }
                } else {
                    stack.add(newPart);
                }
            } else { // letter
                stack.add(String.valueOf(c));
            }
            i++;
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res.charAt(k - 1);
    }
}
