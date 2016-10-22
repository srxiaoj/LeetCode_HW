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
        if (input == null || input.length() == 0) return 0;

        Stack<int[]> stack = new Stack<int[]>();
        int tabCount = 0, max = 0;
        boolean foundFile = false, expectingFirstLetter = true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '\t') {
                tabCount++;
            } else if (c == '\n') {
                // if last parsed section was a file, time to compute max length
                if (foundFile) {
                    max = Math.max(max, stack.peek()[0]);
                    foundFile = false;
                }
                tabCount = 0;
                expectingFirstLetter = true;
            } else {
                if (expectingFirstLetter) {
                    // adjusting length count based on the new tab count
                    while (!stack.isEmpty() && tabCount <= stack.peek()[1]) {
                        stack.pop();
                    }

                    expectingFirstLetter = false;
                    stack.push(new int[]{stack.isEmpty() ? 0 : stack.peek()[0] + 1, tabCount}); // added 1 to consider '/'
                }

                if (c == '.') {
                    foundFile = true;
                }

                stack.peek()[0]++;
            }
        }

        // handels use case when there is no \n or input ends at a file
        if (!expectingFirstLetter && foundFile) {
            max = Math.max(max, stack.peek()[0]);
        }

        return max;
    }

  /*  public static int lengthLongestPath(String input) {
        // check for boundary cases
        if (input.length() == 0) return 0;
        int n = input.length();
        Stack<String> stack = new Stack<>();

        int i = 0, max = 0, level = 0;
        while (i < n) {
            int next = input.indexOf('\n', i);
            // if there is no more \n or there is a file exsit
            if (next == -1 || input.substring(i, next).contains(".")) {
                int j = i;
                while (j < n && (input.charAt(j) != '\n' && input.charAt(j) != '\t')) {
                    j++;
                }

                if (input.substring(i, j).contains(".")) {
                    stack.add(input.substring(i, j).replaceAll("\t", ""));
                    String filePath = getAbsolutePath(stack);
                    System.out.println(filePath);
                    max = Math.max(filePath.length(), max);
                }
                i = j;
            } else {
                String filePath = input.substring(i, next);
                while (stack.size() > level) {
                    stack.pop();
                }
                stack.add(filePath);

                level = 0;
                while (next + 1 < n && input.charAt(next + 1) == '\t') {
                    next++;
                    level++;
                }
                i = next + 1;
            }
        }
        return max;
    }

    private static String getAbsolutePath(Stack<String> stack) {
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append(s).append("/");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }*/
}
