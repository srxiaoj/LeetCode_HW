/**
 * Created by thanksgiving on 5/16/16.
 */
public class ReverseWordsinaString {
    public static void main(String[] args) {
        ReverseWordsinaString obj = new ReverseWordsinaString();
//        String a = "the sky is blue";
        String s = "the sky is blue";
        System.out.println("Before reverse");
        System.out.println(s);
        s = obj.reverseWords(s);
        System.out.println("After reverse");
        System.out.println(s);


        String s1 = "  ";
        System.out.println("Before reverse");
        System.out.println(s1);
        s = obj.reverseWords(s1);
        System.out.println("After reverse");
        System.out.println(s1);


        String s2 = "  blue";
        System.out.println("Before reverse");
        System.out.println(s2);
        s = obj.reverseWords(s2);
        System.out.println("After reverse");
        System.out.println(s2);
    }

    /**
     * 可以有多个空格，可以为全部空格
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        char[] a = s.toCharArray();
        swap(a, 0, a.length - 1);
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (i == 0 && i < a.length && a[i] == ' ') {
                while (i < a.length && a[i] == ' ') {
                    index++;
                    i++;
                }
            } else {
                if (a[i] == ' ') {
                    swap(a, index, i - 1);
                    while (i < a.length && a[i] == ' ') {
                        i++;
                    }
                    index = i;
                }
            }
        }
        // swap the last word
        int j = a.length - 1;
        while (j > index && a[j] == ' ') {
            j--;
        }
        swap(a, index, j);
        return new String(a);
    }

    private void swap (char[] a, int l, int r) {
        while (l <= r) {
            char temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
    }
}
