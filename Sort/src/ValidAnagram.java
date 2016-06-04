import java.util.Arrays;


public class ValidAnagram {
    public static void main(String[] args) {
        String s = new String("nagaram");
        String t = new String("anagram");
        System.out.println(isAnagram(s, t) + " anagram");
        String a = "rat";
        String b = "car";
        System.out.println(isAnagram(a,b));
    }
    public static boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        String str = new String(s1);
        String tstr = new String(t1);
        return str.equals(tstr);
       /* if (s.length() != t.length()) return false;
        if (s.equals("") && t.equals("")) return true;
        Map <Character, Integer> alphabet = new HashMap<>();
        for (int i = 97; i <= 122; i++) {
            alphabet.put((char) i, 0);//put all the 26 letters into map, with key = 0
        }
        for (int i = 0; i < s.length(); i++) {
            int currentKey = alphabet.get(s.charAt(i));
            alphabet.put(s.charAt(i), currentKey+1);
            int currentKey2 = alphabet.get(t.charAt(i));
            alphabet.put(t.charAt(i), currentKey2-1);
        }
        for (int i = 97; i <= 122; i++) {
            if (alphabet.get((char) i) != 0) {
                return false;
            }
        }
        return true;*/
    }
}
