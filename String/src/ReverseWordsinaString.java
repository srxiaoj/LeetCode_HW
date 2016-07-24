/**
 * Created by thanksgiving on 5/16/16.
 */
public class ReverseWordsinaString {
    public static void main(String[] args) {
//        String a = "the sky is blue";
        String s = "the   sky is blue";
        System.out.println("Before reverse");
        System.out.println("[" + new String(s) +"]");
        s = reverseWords(s);
        System.out.println("After reverse");
        System.out.println("[" + new String(s) +"]");


        String s1 = "  ";
        System.out.println("Before reverse");
        System.out.println("[" + new String(s1) +"]");
        s1 = reverseWords(s1);
        System.out.println("After reverse");
        System.out.println("[" + new String(s1) +"]");


        String s2 = "     blue";
        System.out.println("Before reverse");
        System.out.println("[" + new String(s2) +"]");
        s2 = reverseWords(s2);
        System.out.println("After reverse");
        System.out.println("[" + new String(s2) +"]");
    }

    /**
     * 可以有多个空格，可以为全部空格
     */
    public static String reverseWords(String s) {
        // 去掉多余空格再进行翻转
        String newS = removeExtraSpace(s);
        char[] a = newS.toCharArray();
        reverse(a, 0, a.length - 1);
        int n = a.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == ' ') {
                reverse(a, start, i - 1);
                start = i + 1;
            }
            if (i == n - 1) {
                reverse(a, start, n - 1);
            }
        }

        return new String(a);
       /* if (s == null || s.length() == 0) return s;
        s = s.replaceAll("[ ]+", " ").trim();
        char[] a = s.toCharArray();
        reverse(a, 0, a.length - 1);
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (i == 0 && i < a.length && a[i] == ' ') {
                while (i < a.length && a[i] == ' ') {
                    index++;
                    i++;
                }
            } else {
                if (a[i] == ' ') {
                    reverse(a, index, i - 1);
                    while (i < a.length && a[i] == ' ') {
                        i++;
                    }
                    index = i;
                }
            }
        }
        // reverse the last word
        int j = a.length - 1;
        while (j > index && a[j] == ' ') {
            j--;
        }
        reverse(a, index, j);
        return new String(a);*/
    }

    private static String removeExtraSpace(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            // remove space at beginning
            if (i == 0 && s.charAt(i) == ' ') {
                while (i < s.length() && s.charAt(i) == ' ') {
                    i++;
                }
                if (i == s.length()) break;
                sb.append(s.charAt(i));
            } else {
                if (s.charAt(i) != ' ') {
                    sb.append(s.charAt(i));
                } else {
                    // remove all space in the middle
                    while (i < s.length() && s.charAt(i) == ' ') {
                        i++;
                    }
                    if (i == s.length()) break;
                    sb.append(' ').append(s.charAt(i));
                }
            }
            i++;
        }
        return sb.toString();


        // 代码精简版
      /*  StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int temp = i;
            // remove space at beginning
            if (s.charAt(i) == ' ') {
                while (i < s.length() && s.charAt(i) == ' ') {
                    i++;
                }
                if (i == s.length()) break;
                if (temp != 0) {
                    // 如果开始碰见空格则前面不补空格
                    sb.append(' ');
                }
            }
            sb.append(s.charAt(i));
            i++;
        }
        return sb.toString();*/
    }

    private static void reverse(char[] a, int l, int r) {
        while (l <= r) {
            char temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
    }
}
