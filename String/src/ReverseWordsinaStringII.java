/**
 * Created by thanksgiving on 1/3/16.
 */
public class ReverseWordsinaStringII {
    public static void main(String[] args) {
        ReverseWordsinaStringII obj = new ReverseWordsinaStringII();
//        String a = "the sky is blue";
        String a = "a ";
        char[] s = a.toCharArray();
        System.out.println("Before reverse");
        System.out.println(s);
        obj.reverseWords(s);
        System.out.println("After reverse");
        System.out.println(s);
    }
    public void reverseWords(char[] s) {
        if (s == null) return;
        int len = s.length;
        int start = 0, end = 1;
        for (int i = 0; i < len; i++) {
            while (i < len && s[i] != ' ') {
                i++;
            }
            end = i - 1;
            reverse(s, start, end);
            start = i + 1;
        }
        reverse(s, 0, len - 1);
    }
    private void reverse(char[] s, int l, int r) {
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }
}
