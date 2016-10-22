import java.util.Stack;

/**
 * Created by Administrator on 2016/10/22.
 */
public class LongestPath {
    public static void main(String[] args) {
//        System.out.println(longestPath("dir\n  file.txt"));
        System.out.println(longestPath("dir1\n dir2\n  img1.jpeg\n  dir3\n   img2.gif\ndir4"));
    }

    public static int longestPath(String S) {
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
                    stack.push(filePath);
                    len += filePath.length() + 1;
                    max = Math.max(max, len);
                    /*if (len == max) {
                        for (String ss : stack) {
                            System.out.print("\\" + ss);
                        }
                        System.out.println();
                    }*/

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

    public static int longestPath2(String S) {
        if (S == null || S.length() == 0) return 0;
        String[] strs = S.split("\n");

        Stack<String> stack = new Stack<>();

        int i = 0, len = 0, max = 0;
        while (i < strs.length) {
            String cur = strs[i];

            int level = 0;
            for (int j = 0; j < cur.length(); j++) {
                if (cur.charAt(j) == ' ') {
                    level++;
                } else {
                    break;
                }
            }
            String filename = cur.substring(level);
            if (level == stack.size()) {
                if (cur.contains(".jpeg") || cur.contains(".png") || cur.contains(".gif")) {
                    stack.push(filename);
                    len += filename.length() + 1;
                    max = Math.max(max, len);
                    if (len == max) {
                        for (String ss : stack) {
                            System.out.print("\\" + ss);
                        }
                        System.out.println();
                    }

                } else {
                    len += filename.length() + 1;
                    stack.push(filename);
                }
                i++;
            } else if (level < stack.size()) {
                while (level < stack.size()) {
                    String tempname = stack.pop();
                    len -= (tempname.length() + 1);
                }
            }
        }
        return max;
    }

   /* public int longestPath2(String files) {
        if(files == null || files.length() == 0) return 0;
        String[] strs = files.split("\n");
        Stack<String> stack = new Stack<>();
        stack.push(strs[0]);
        int count = strs[0].length()+1;
        int max = count;
        int space = 0;
        for(int i=1; i<strs.length; i++) {
            for(int j=0; j<strs.length(); j++) {
                if(strs.charAt(j) == ' ') {
                    space++;
                }
                else break;
            }
            if(space == stack.size()) {
                if(strs.contains(".")) {
                    max = Math.max(max, (strs.contains("jpeg")||strs.contains("gif"))?count+strs.length()-space:0);
                }
                else {
                    stack.push(strs);
                    count += strs.length()+1-space;
                }
            }
            else if(space < stack.size()) {
                while(space < stack.size()) {
                    String temp = stack.pop();
                    count -= temp.length()+1-space;
                }
                stack.push(strs);
                count += strs.length()+1-space;
            }
            space = 0;
        }
        return max;
    }*/
}
