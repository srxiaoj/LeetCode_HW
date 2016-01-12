/**
 * Created by thanksgiving on 1/1/16.
 */
public class OneEditDistance {
    public static void main(String[] args) {
        OneEditDistance obj = new OneEditDistance();
        String a = "ab";
        String b = "acb";
        String c = "gredy";
        String d = "greedy";
        System.out.println(obj.isOneEditDistance(a, b));
        System.out.println(obj.isOneEditDistance(c, d));
    }

    public boolean isOneEditDistance(String s, String t) {

        if (s.equals(t)) return false;
        int sLen = s.length();
        int tLen = t.length();
        if (Math.abs(sLen - tLen) > 1) return false;
        // case1: two strings have equal length
        if (sLen == tLen) {
            int numDiffChar = 0;
            for (int i = 0; i < sLen; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    numDiffChar++;
                }
            }
            if (numDiffChar > 1) return false;
            return true;
        } else if (sLen < tLen) { // case2: string s is one letter less than string t
            int i = 0, j = tLen - 1;
            while (i < sLen && s.charAt(i) == t.charAt(i)) {
                i++;
            }
            if (i == sLen) return true;
            return (s.substring(i).equals(t.substring(i + 1)));
        } else {
            return isOneEditDistance(t, s);
        }


        /*
        if (s == null || t == null) return false;
        int sLen = s.length();
        int tLen = t.length();
        // if diff is more than one then return false
        if (Math.abs(sLen - tLen) > 1) return false;

        if (s.length() > t.length()) {
            return isOneEditDistance(t, s);
        }

        int x = 0, y = 0;

        boolean diffOneChar = false;
        while (x < sLen && y < tLen) {
            if (s.charAt(x++) != t.charAt(y++)) {
                diffOneChar = true;
                if (sLen != tLen) x--;
                break;
            }
        }

        // check whether 's' matched with 't' all the way and diff is 1

        if (x == sLen && tLen - x == 1) return true;

        while (x < sLen && y < tLen) {
            if (s.charAt(x++) != t.charAt(y++)) {
                return false;
            }
        }

        // length of both s and t are same but it differs with one character

        if (diffOneChar && y == tLen && x == sLen) return true;

        return false;
        */


    }
}
