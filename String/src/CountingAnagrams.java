import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by thanksgiving on 6/4/16.
 */
public class CountingAnagrams {
    public static void main(String[] args) {
        String a = "abdcafgicdba";
        String b = "adcb";
        find_sort(a, b);
    }

    public static void find_sort(String str1, String str2) {
        if (str1.length() < str2.length()) {
            System.out.println("str1 length is smaller than str2 length");
            return;
        }

        char[] a2 = str2.toCharArray();
        Arrays.sort(a2);
        String str2_anagram = new String(a2);
        List<Integer> res = new ArrayList<>();
        int total_number = 0;
        for (int i = 0; i < str1.length() - str2.length() + 1; i++) {
            char[] str1_char = str1.substring(i, i + str2.length()).toCharArray();
            Arrays.sort(str1_char);
            String str1_anagram = new String(str1_char);
            if (str1_anagram.equals(str2_anagram)) {
                res.add(i);
//                i = i + str2.length() - 1;
                total_number++;
            }
        }
        System.out.println("total number : " + total_number);
        System.out.println("starting index" + res);
    }
}
