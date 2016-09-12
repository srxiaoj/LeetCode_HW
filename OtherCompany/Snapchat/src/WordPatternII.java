import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class WordPatternII {
    public static void main(String[] args) {
        WordPatternII obj = new WordPatternII();
        System.out.println(obj.wordPatternMatch("abba", "redbluebluered"));
        System.out.println(obj.wordPatternMatch("abab", "redblueredblue"));
        System.out.println(obj.wordPatternMatch("abbb", "redredredred"));
        System.out.println(obj.wordPatternMatch("d", "e"));
        System.out.println(obj.wordPatternMatch("ab", "aa"));
        System.out.println(obj.wordPatternMatch("aba", "aaaa"));
    }

    Map<Character, String> map = new HashMap();
    Set<String> set = new HashSet();

    public boolean wordPatternMatch(String p, String s) {
        if (p.isEmpty()) return s.isEmpty();
        if (p.length() > s.length()) return false;

        if (!map.containsKey(p.charAt(0))) {
            for (int i = 1; i <= s.length(); i++) {
                String key = s.substring(0, i);
                if (set.contains(key)) continue;
                set.add(key);
                map.put(p.charAt(0), key);
                if (wordPatternMatch(p.substring(1), s.substring(i))) return true;
                set.remove(key);
                map.remove(p.charAt(0));
            }
        } else {
            String toMatch = map.get(p.charAt(0));
            int len = toMatch.length();
            if (s.length() >= len && s.substring(0, len).equals(toMatch)) {
                if (wordPatternMatch(p.substring(1), s.substring(len))) return true;
            }
            return false;
        }

        return false;


        /*       if (p.isEmpty()) return s.isEmpty();
        int m = p.length(), n = s.length();
        if (m > n) return false;

//        System.out.println("p: " + p + ", s: " + s);
//        System.out.println("map " + map + ", set " + set);
        for (int i = 0; i < m; i++) {
            char c = p.charAt(i);
            if (!map.containsKey(c)) {
                for (int j = 0; j < n; j++) {
                    String curMatch = s.substring(0, j + 1);
                    if (set.contains(curMatch)) continue;
                    map.put(c, curMatch);
                    set.add(curMatch);
                    if (wordPatternMatch(p.substring(i + 1), s.substring(j + 1))) return true;
                    map.remove(c);
                    set.remove(curMatch);
                }
            } else {
                String lastMatch = map.get(c);
                if (lastMatch.length() > s.length() || !s.substring(0, lastMatch.length()).equals(lastMatch)) return false;
                if (wordPatternMatch(p.substring(i + 1), s.substring(lastMatch.length()))) return true;
            }
            if (map.size() != i + 1) return false;
        }
        return false;*/
    }

/*    public boolean wordPatternMatch(String p, String s) {
        if (p.isEmpty()) return s.isEmpty();
        if (map.containsKey(p.charAt(0))) {
            String value = map.get(p.charAt(0));
            if (s.length() < value.length() || !s.substring(0, value.length()).equals(value)) return false;
            if (wordPatternMatch(p.substring(1), s.substring(value.length()))) return true;
        } else {
            for (int i = 1; i <= s.length(); i++) {
                if (set.contains(s.substring(0, i))) continue;
                map.put(p.charAt(0), s.substring(0, i));
                set.add(s.substring(0, i));
                if (wordPatternMatch(p.substring(1), s.substring(i))) return true;
                set.remove(s.substring(0, i));
                map.remove(p.charAt(0));
            }
        }
        return false;
    }*/

}