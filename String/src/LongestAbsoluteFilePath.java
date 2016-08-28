import java.util.Stack;

/**
 * Created by thanksgiving on 8/26/16.
 */
public class LongestAbsoluteFilePath {
    public static void main(String[] args) {
        System.out.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
        System.out.println(lengthLongestPath("a"));
        System.out.println(lengthLongestPath("dir\n    file.txt"));
    }

    public static int lengthLongestPath(String input) {
        Stack<String> stack = new Stack<>();

        if (input.length() == 0) return 0;
        int n = input.length();

        int i = 0;
        int max = 0;

        int level = 0;
        while (i < n) {
            int next = input.indexOf('\n', i);
            // contain a file or no more \n
            if (next == -1 || input.substring(i, next).contains(".")) {
                int temp = i;
                while (temp < n && (input.charAt(temp) != '\n' && input.charAt(temp) != '\t')) {
                    temp++;
                }
                // file must has extension
                if (input.substring(i, temp).contains(".")) {
                    stack.add(input.substring(i, temp).replaceAll("\t", ""));
                    //                System.out.println(input.substring(i, temp));
                    String file = getWord(stack);
                    System.out.println(file);
                    max = Math.max(file.length(), max);
                }
                i = temp;
            } else {
                String filePath = input.substring(i, next);
                while (stack.size() > level) {
                    stack.pop();
                }
                stack.add(filePath);

                level = 0;
                while (next + 1 < n && input.substring(next + 1, next + 2).equals("\t")) {
                    next++;
                    level++;
                }
                i = next + 1;
            }
        }
        return max;
    }

    private static String getWord(Stack<String> stack) {
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append(s).append("/");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
