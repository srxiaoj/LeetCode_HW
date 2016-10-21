import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2016/10/21.
 */
public class ReconstructOriginalDigitsfromEnglish {
    public static void main(String[] args) {
        System.out.println(originalDigits("owoztneoer"));
        System.out.println(originalDigits("fviefuro"));
    }

    public static String originalDigits(String s) {
        String[] array = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        if (s == null || s.length() == 0) return s;
        int n = s.length();
        int[] map = new int[26];
        for (int i = 0; i < n; i++) {
            map[s.charAt(i) - 'a']++;
        }

        List<Integer> res = new ArrayList<>();
        // zero has unique z
        while (map['z' - 'a'] > 0) {
            res.add(0);
            map['z' - 'a']--;
            map['e' - 'a']--;
            map['r' - 'a']--;
            map['o' - 'a']--;
        }

        // eight has unique g
        while (map['g' - 'a'] > 0) {
            res.add(8);
            map['e' - 'a']--;
            map['i' - 'a']--;
            map['g' - 'a']--;
            map['h' - 'a']--;
            map['t' - 'a']--;
        }

        // two has unique w
        while (map['w' - 'a'] > 0) {
            res.add(2);
            map['t' - 'a']--;
            map['w' - 'a']--;
            map['o' - 'a']--;
        }

        // six has unique x
        while (map['x' - 'a'] > 0) {
            res.add(6);
            map['s' - 'a']--;
            map['i' - 'a']--;
            map['x' - 'a']--;
        }

        // after remove all six, seven has unique s
        while (map['s' - 'a'] > 0) {
            res.add(7);
            map['s' - 'a']--;
            map['e' - 'a']--;
            map['v' - 'a']--;
            map['e' - 'a']--;
            map['n' - 'a']--;
        }

        // after remove all seven, five has unique v
        while (map['v' - 'a'] > 0) {
            res.add(5);
            map['f' - 'a']--;
            map['i' - 'a']--;
            map['v' - 'a']--;
            map['e' - 'a']--;
        }

        // after remove all five, four has unique f
        while (map['f' - 'a'] > 0) {
            res.add(4);
            map['f' - 'a']--;
            map['o' - 'a']--;
            map['u' - 'a']--;
            map['r' - 'a']--;
        }

        // after remove all zero and four, three has unique r
        while (map['r' - 'a'] > 0) {
            res.add(3);
            map['t' - 'a']--;
            map['h' - 'a']--;
            map['r' - 'a']--;
            map['e' - 'a']--;
            map['e' - 'a']--;
        }

        // after remove all o in zero and two, one has unique o
        while (map['o' - 'a'] > 0) {
            res.add(1);
            map['o' - 'a']--;
            map['n' - 'a']--;
            map['e' - 'a']--;
        }

        // only letter left is 9
        while (map['n' - 'a'] > 0) {
            res.add(9);
            map['n' - 'a']--;
            map['i' - 'a']--;
            map['n' - 'a']--;
            map['e' - 'a']--;
        }
        Collections.sort(res);
        StringBuilder sb = new StringBuilder();
        for (int i : res) {
            sb.append(i);
        }
        return sb.toString();
    }
}
