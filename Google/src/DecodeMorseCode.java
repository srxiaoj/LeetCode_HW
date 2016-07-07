import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by thanksgiving on 7/6/16.
 */
public class DecodeMorseCode {
    public static void main(String[] args) {
        Map<String, Character> morseRule = new HashMap<>();
        morseRule.put("._", 'A');
        morseRule.put(".__", 'B');
        morseRule.put("._.__", 'C');
        morseRule.put(".._", 'Z');
        String s = "._.__.._";
        System.out.println(decodeMorse(s, morseRule));
    }

    public static List<String> decodeMorse(String str, Map<String, Character> morseRule) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(sb, res, str, morseRule);
        return res;
    }

    private static void helper(StringBuilder sb, List<String> res, String s, Map<String, Character> morseRule) {
        if (s.equals("")) {
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String first = s.substring(0, i + 1);
            if (morseRule.containsKey(first)) {
                StringBuilder newSb = new StringBuilder(sb.toString());
                newSb.append(morseRule.get(first));
                helper(newSb, res, s.substring(i + 1), morseRule);
            }
        }
    }
}
