import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 1/21/16.
 */
public class FillingBlanks {
    public static void main(String[] args) {
        FillingBlanks obj = new FillingBlanks();
        String a = "ABCD";
//        System.out.println(a.substring(0, 2));
        System.out.println(obj.fillBlank(a));
    }

    public List<String> fillBlank(String s) {
        List<String> res = new ArrayList<>();
        String newString = new String(s);
        dfs(s, newString, res, 0, 1);
        return res;
    }

    public void dfs(String s, String newString, List<String> res, int lastLetter, int lastBlank) {
        if (lastLetter == s.length() - 1) {
            if (!res.contains(newString)) {
                res.add(newString);
            }
            return;
        }

        // use lastLetter to track whether the program has iterated all the characters in string
        // use lastBlank to track the next possible blank position
        for (int i = 0; i < s.length(); i++) {
            String str = newString;
            if (lastBlank + i < newString.length()) {
                str = newString.substring(0, lastBlank + i) + "_"
                        + newString.substring(lastBlank + i);
            }
            dfs(s, str, res, lastLetter + 1, lastBlank + i + 2);
        }
    }
}
