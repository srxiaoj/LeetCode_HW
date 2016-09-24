import java.util.*;

/**
 * Created by thanksgiving on 9/23/16.
 */
public class BuildSubsequence {
    public static void main(String[] args) {
        printArray(buildSubsequences("abc"));
        printArray(buildSubsequences("ab"));
        printArray(buildSubsequences("aab"));
    }

    static String[] buildSubsequences(String s) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        set.add("");

        for (int i = 0; i < s.length(); i++) {
            List<String> temp = new ArrayList<>();
            for (String j : set) {
                String part = j + s.charAt(i);
                temp.add(part);
            }
            set.addAll(temp);
        }
        set.remove("");
        for (String i : set) {
            res.add(i);
        }
        Collections.sort(res);
        res.add("");

        String[] output = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            output[i] = res.get(i);
        }
        return output;
    }

    //print array
    public static void printArray(String[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }
}
