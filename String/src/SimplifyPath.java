import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class SimplifyPath {

	public static void main(String[] args) {
		String path = "/home/users/../";
		String path2 = "/a/./b/../../c/d";
		System.out.println(simplifyPath(path));
		System.out.println(simplifyPath(path2));
	}
	public static String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty())
                stack.pop();
            else if (!skip.contains(dir))
                stack.push(dir);
        }
        String res = "";
        // System.out.println(stack);
        for (String dir : stack) {
            res = "/" + dir + res;
        }
        return res.isEmpty() ? "/" : res;
    }
}
