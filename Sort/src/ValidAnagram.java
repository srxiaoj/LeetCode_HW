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
        int[] map = new int[256];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]--;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) return false;
        }
        return true;


        /*char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        String str = new String(s1);
        String tstr = new String(t1);
        return str.equals(tstr);*/
    }
}
