import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by thanksgiving on 1/13/16.
 */
public class UniqueWordAbbreviation {
    public static void main(String[] args) {
        String[] dictionary = {"dog"};
        ValidWordAbbr obj = new ValidWordAbbr(dictionary);
        System.out.println(obj.isUnique("dig"));
        System.out.println(obj.isUnique("dug"));
        System.out.println(obj.isUnique("dag"));
        System.out.println(obj.isUnique("dog"));
        System.out.println(obj.isUnique("doge"));

    }
}

class ValidWordAbbr {
    private HashMap<String, Integer> map;
    private List<String> copy;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        copy = new ArrayList<>(Arrays.asList(dictionary));
        for (int i = 0; i < dictionary.length; i++) {
            int n = dictionary[i].length();
            if (n <= 2) {
                map.put(dictionary[i], 1);
            } else {
                n = n - 2;
                String abbr = String.valueOf(dictionary[i].charAt(0)) + n + String.valueOf(dictionary[i].charAt(dictionary[i].length() - 1));
                if (!map.containsKey(abbr)) {
                    map.put(abbr, 1);
                } else {
                    map.put(abbr, map.get(abbr) + 1);
                }
            }
        }
    }

    public boolean isUnique(String word) {
        if (word == null) return false;
        if (word.length() == 0) return true;
        int n = word.length();
        n = n - 2;
        String abbr = String.valueOf(word.charAt(0)) + n + String.valueOf(word.charAt(word.length() - 1));
        if (map.containsKey(abbr)) {
            if (map.get(abbr) > 1)
                return false;
            if (map.get(abbr) == 1) {
                if (copy.contains(word)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}