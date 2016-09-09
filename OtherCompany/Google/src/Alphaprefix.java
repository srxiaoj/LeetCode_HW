/**
 * Created by thanksgiving on 7/8/16.
 */
public class Alphaprefix {
    public static void main(String[] args) {
        System.out.println(alphaprefix("ransom"));;
        System.out.println(alphaprefix("google"));
        System.out.println(alphaprefix("knotty"));
        System.out.println(alphaprefix("a"));
    }

    public static int alphaprefix(String s) {
        if (s == null || s.length() == 0) return 0;
        int i = 0;
        while (i + 1 < s.length() && s.charAt(i + 1) >= s.charAt(i)) {
            i++;
        }
        return i + 1;
    }
}
