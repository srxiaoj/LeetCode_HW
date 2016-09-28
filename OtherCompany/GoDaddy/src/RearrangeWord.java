import java.util.Arrays;

/**
 * Created by thanksgiving on 9/27/16.
 */
public class RearrangeWord {
    public static void main(String[] args) {
        System.out.println(rearrangeWord("abcd"));
        System.out.println(rearrangeWord("dcba"));
    }

    static String rearrangeWord(String word) {
        if (word == null || word.length() <= 1) return "no answer";
        int n = word.length();
        char[] array = word.toCharArray();

        for (int i = n - 1; i > 0; i--) {
            if (array[i] > array[i - 1]) {
                Arrays.sort(array, i, n);
                for (int j = i; j < n; j++) {
                    if (array[j] > array[i - 1]) {
                        swap(array, j, i - 1);
                        return new String(array);
                    }
                }
            }
        }
        return "no answer";
    }

    static void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }
}
