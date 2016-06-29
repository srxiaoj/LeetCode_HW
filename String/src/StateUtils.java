import java.util.HashMap;
import java.util.Map;

/**
 * Comment: The original code involves hard code of state and abbreviations everywhere.
 * Therefore, it is very easy to make errors due to typo. It is also a lot of work if
 * one of two states want to be removed from the list. The way I did, only one array for
 * full state name and one array for abbreviations are needed. This is much easier to work with
 * and it's more flexiable to future requirements.
 */
public class StateUtils {
    public static void main(String[] args) {
        System.out.println(createStateSelectList());
    }

    private static final String[] FULL_NAME = {"Alabama", "Alaska", "Arizona", "Arkansas", "California"};
    private static final String[] ABBREVIATION = {"AL", "AK", "AZ", "AR", "CA"};
    private static Map<String, String> fullMap;
    private static Map<String, String> abMap;

    public StateUtils() {
        fullMap = new HashMap<>();
        abMap = new HashMap<>();
        for (int i = 0; i < FULL_NAME.length; i++) {
            fullMap.put(FULL_NAME[i], ABBREVIATION[i]);
            fullMap.put(ABBREVIATION[i], FULL_NAME[i]);
        }
    }

    public static String createStateSelectList() {
        String result =  "<select name=\"state\">\n";
        for (int i = 0; i < FULL_NAME.length; i++) {
            result += "<option value=\"" + FULL_NAME[i] + "\">" + FULL_NAME[i] + "</option>\n";
        }
        result += "</select>\n";
        return result;
 /*               "<select name=\"state\">\n"
                        + "<option value=\"Alabama\">Alabama</option>\n"
                        + "<option value=\"Alaska\">Alaska</option>\n"
                        + "<option value=\"Arizona\">Arizona</option>\n"
                        + "<option value=\"Arkansas\">Arkansas</option>\n"
                        + "<option value=\"California\">California</option>\n"
                        // more states here
                        + "</select>\n";*/
    }

    //
    // Parses the state from an HTML form submission, converting it to
    // the two-letter abbreviation.
    //
    public static String parseSelectedState(String s) {
        if (!fullMap.containsKey(s)) {
            return "";
        } else {
            return fullMap.get(s);
        }
/*        if (s.equals("Alabama")) {
            return "AL";
        }
        if (s.equals("Alaska")) {
            return "AK";
        }
        if (s.equals("Arizona")) {
            return "AZ";
        }
        if (s.equals("Arkansas")) {
            return "AR";
        }
        if (s.equals("California")) {
            return "CA";
        }
        // more states here*/
    }

    //
    // Displays the full name of the state specified by the two-letter code.
    //
    public static String displayStateFullName(String abbr) {
        if (!abMap.containsKey(abbr)) {
            return "";
        } else {
            return abMap.get(abbr);
        }
 /*       {
            if (abbr.equals("AL")) {
                return "Alabama";
            }
            if (abbr.equals("AK")) {
                return "Alaska";
            }
            if (abbr.equals("AZ")) {
                return "Arizona";
            }
            if (abbr.equals("AR")) {
                return "Arkansas";
            }
            if (abbr.equals("CA")) {
                return "California";
            }
            // more states here
        }*/
    }
}
