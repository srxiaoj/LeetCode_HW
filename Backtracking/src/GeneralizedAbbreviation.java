import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 4/23/16.
 */
public class GeneralizedAbbreviation {
    public static void main(String[] args) {
        GeneralizedAbbreviation obj = new GeneralizedAbbreviation();
        System.out.println(obj.generateAbbreviations("word"));
    }

    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        int len = word.length();
        if (len == 0) {
            res.add("");
        } else {
            res.add(String.valueOf(len));
        }
        for (int i = 0; i < len; i++)
            for (String right : generateAbbreviations(word.substring(i + 1))) {
                String leftNum;
                if (i > 0) {
                    leftNum = String.valueOf(i);
                } else {
                    leftNum = "";
                }
                res.add(leftNum + word.substring(i, i + 1) + right);
            }
        return res;
    }
}
