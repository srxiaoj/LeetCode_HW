import java.util.Stack;

/**
 * Created by Administrator on 2016/10/22.
 */
public class LongestPathWithoutFilename {
    public static void main(String[] args) {
        System.out.println(longestPathWithoutFileName("dir1\n dir2\n  img1.jpeg\n  dir3\n   img2.gif\ndir4"));
        System.out.println(longestPathWithoutFileName("dir1\n dir24\n  img1.jpeg\n dir3\n  img2.gif\ndir4"));
        System.out.println(longestPathWithoutFileName("dir1\n dir24\n  img1.jpeg\n dir3333\n  img2.gif\ndir4"));
        System.out.println(longestPathWithoutFileName("dir1\n dir24\n  img1.jpeg\n dir3333\n  img2.gif\ndir4912839182391829381\n a.gif"));
    }

    /**
     * The idea is to use a stack to maintain the structure of directories,
     * and find out the file with extension that follows this structure.
     * Depending the number of space before a path name, determine whether this
     * directory is on the same level or a sub directory of previous directory.
     * @param S
     * @return
     */
    public static int longestPathWithoutFileName(String S) {
        // check for boundary cases
        if (S == null || S.length() == 0) return 0;
        String[] path = S.split("\n");

        Stack<String> stack = new Stack<>();

        int i = 0, len = 0, max = 0;
        while (i < path.length) {
            String cur = path[i];

            int level = 0;
            for (int j = 0; j < cur.length() && cur.charAt(j) == ' '; j++) {
                level++;
            }
            String filePath = cur.substring(level);
            if (level == stack.size()) {
                if (cur.contains(".jpeg") || cur.contains(".png") || cur.contains(".gif")) {
//                    stack.push(filePath);
//                    len += filePath.length() + 1;
                    max = Math.max(max, len);
                    if (len == max) {
                        for (String ss : stack) {
                            System.out.print("\\" + ss);
                        }
                        System.out.println();
                    }

                } else {
                    len += filePath.length() + 1;
                    stack.push(filePath);
                }
                i++;
            } else if (level < stack.size()) {
                while (level < stack.size()) {
                    String last = stack.pop();
                    len -= last.length() + 1;
                }
            }
        }
        return max;
    }
}
