/**
 * Created by thanksgiving on 1/3/16.
 */
public class ReverseWordsinaStringII {
    public static void main(String[] args) {
//        String a = "the sky is blue";
        String a = " ";
        char[] s = a.toCharArray();
        System.out.println("Before reverse");
        System.out.println("[" + new String(s) +"]");
        reverseWords(s);
        System.out.println("After reverse");
        System.out.println("[" + new String(s) +"]");
    }

    /**
     * 先将整个char[] reverse，然后将每个' '隔开的单词reverse，注意最后一个单词也要reverse
     */
    public static void reverseWords(char[] s) {
        int l = 0, r = s.length - 1;
        swap(s, l, r);
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                swap(s, start ,i - 1);
                start = i + 1;
            }
            if (i == s.length - 1) {
                swap(s, start, i);
            }
        }
    }

    private static void swap(char[] a, int l, int r) {
        while (l <= r) {
            char temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
    }
}
