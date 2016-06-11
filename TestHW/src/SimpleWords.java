import java.util.HashSet;
import java.util.Set;

public class SimpleWords {
	
    public boolean isCompound(String s, Set<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
    public void simpleWords(String[] input) {
    	HashSet<String> set = new HashSet<String>();
    	for (String str : input) {
    		set.add(str);
    	}
    	for (String str : input) {
    		set.remove(str);
    		if (!isCompound(str, set)) {
    			System.out.println("\"" + str + "\"");
    		}
    		set.add(str);
    	}
    }
    public static void main(String[] args) {
    	String[] input = {"chat", "ever",  "snapchat" ,"snap", "salesperson" ,"per", "person", "sales",
                "son" ,"whatsoever" ,"what", "so", ""};
        SimpleWords so = new SimpleWords();
    	so.simpleWords(input);
	}
}