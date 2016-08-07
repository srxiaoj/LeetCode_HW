import java.util.Stack;

/**
 * Created by thanksgiving on 8/6/16.
 */
public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/."));
        System.out.println(simplifyPath("/a/./"));
        System.out.println(simplifyPath("/a/."));
        System.out.println(simplifyPath("./"));
        System.out.println(simplifyPath("../"));
        System.out.println(simplifyPath("/.."));
        System.out.println(simplifyPath("../a"));
        System.out.println(simplifyPath("/abc/..."));
    }

    public static String simplifyPath(String path) {
        if (path == null || path.length() == 0) return "";

        while (path.length() > 0 && path.charAt(0) == '.') {
            path = path.substring(1);
        }

        boolean addPath = false;
        Stack<String> stack = new Stack<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < path.length()) {
            char c = path.charAt(i);
            i++;
            if (c == '/' && !addPath) {
                addPath = true;
            } else {

                if (c == '/' || i == path.length()) {
                    if (i == path.length() && c != '/') {
                        sb.append(c);
                    }
                    if (sb.toString().equals("/")) {
                        continue;
                    } else if (sb.length() == 1 && sb.charAt(0) == '.') {
                        addPath = false;
                    } else if (sb.toString().equals("..")) {
                        if (!stack.isEmpty()) stack.pop();
                        addPath = false;
                    } else if (addPath) {
                        stack.add(sb.toString());
                        sb = new StringBuilder();
                    }
                } else {
                    sb.append(c);
                }
            }
        }

        String res = new String("/");
        for (String s : stack) {
            res = res + s + "/";
        }
        if (stack.isEmpty()) return "/";
        return res.substring(0, res.length() - 1);
    }
}
