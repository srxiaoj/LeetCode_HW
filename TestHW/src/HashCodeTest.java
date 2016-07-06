/**
 * Created by thanksgiving on 7/5/16.
 */
public class HashCodeTest {
    public static void main(String[] args) {
        String str = "varotia";
        System.out.println(str.hashCode());
        System.out.println(hashCodeForString(str));
    }

    public static int hashCodeForString(String s) {
        char[] val = s.toCharArray();
        int len = s.length();
        int h = 0;
        for (int i = 0; i < len; i++) {
            h = h * 31 + val[i];
        }
        return h;
    }
}
