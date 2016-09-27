import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by thanksgiving on 9/27/16.
 */
public class WordGuess {
    private String secret = "xya";
    private boolean found = false;
    private String finalGuess = ":";

    public static void main(String[] args) {
        WordGuess obj = new WordGuess();

        // matching score
        System.out.println(obj.matchScore("aax"));

        // find result
        String target = obj.findChars();
        System.out.println(target);
        obj.permuteUnique(target.toCharArray());
        System.out.println(obj.finalGuess);
    }

    public int matchScore(String guess) {
        int[] g = new int[26];
        int[] s = new int[26];
        int bulls = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (guess.charAt(i) == secret.charAt(i)) bulls++;
            g[guess.charAt(i) - 'a']++;
            s[secret.charAt(i) - 'a']++;
        }
        if (bulls == guess.length()) return 100;
        int same = 0;
        for (int i = 0; i < 26; i++) {
            same += Math.min(g[i], s[i]);
        }
        return same;
    }

    public List<List<Character>> permuteUnique(char[] nums) {
        Arrays.sort(nums);
        List<List<Character>> res = new ArrayList<List<Character>>();
        helper(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void helper(char[] nums, ArrayList<Character> list, boolean[] used) {
        if (list.size() == nums.length) {
            char[] tmp = new char[secret.length()];
            for (int i = 0; i < secret.length(); i++) tmp[i] = list.get(i);
            if (matchScore(new String(tmp)) == 100) {
                found = true;
                finalGuess = new String(tmp);
//                System.out.println(finalGuess);
            }
//        	System.out.println(list);
            return;
        }
//        if (found) return;
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && !used[i - 1] && nums[i] == nums[i - 1]) continue;
            used[i] = true;
            list.add(nums[i]);
            helper(nums, list, used);
            if (found) return;
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    /**
     * find out all the characters in target word
     * @return
     */
    public String findChars() {
        int[] scores = new int[26];
        for (char c = 'a'; c <= 'z'; c++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < secret.length(); i++)
                sb.append(c);
            int score = matchScore(sb.toString());
            if (score == 0) continue;
            scores[c - 'a'] = score;
        }
        StringBuilder target = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < scores[c - 'a']; i++) {
                target.append(c);
            }
        }
        return target.toString();
    }
}
