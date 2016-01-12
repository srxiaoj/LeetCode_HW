import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WordPattern obj = new WordPattern();
        String pattern1 = "abba", str1 = "dog cat cat dog";
        String pattern2 = "abba", str2 = "dog cat cat fish";
        String pattern3 = "aaaa", str3 = "dog cat cat dog";
        String pattern4 = "abba", str4 = "dog dog dog dog";
        
        System.out.println(obj.wordPattern(pattern1, str1));
        System.out.println(obj.wordPattern(pattern2, str2));
        System.out.println(obj.wordPattern(pattern3, str3));
        System.out.println(obj.wordPattern(pattern4, str4));
        
    }
    public boolean wordPattern(String pattern, String str) {
        String[] array = str.split("\\s");
        if (array.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<Character, String>();
        Set set = new HashSet();
        for (int i = 0; i < array.length; i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                if (!set.contains(array[i])) {
                    map.put(c, array[i]);
                    set.add(array[i]);
                } else {
                    return false;
                }
            } else {
                if (!map.get(c).equals(array[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
