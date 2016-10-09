import java.util.Arrays;

/**
 * Created by thanksgiving on 10/9/16.
 */
public class WordGuessHW {
    public static void main(String[] args) {
        System.out.println(leastGuess());
    }

    public static String leastGuess() {
        String res = findChars();
        int cur = makeAGuess(res);
        while (cur != 6) {
            res = nextPermute(res);
            cur = makeAGuess(res);
        }
        return res;
    }

    /**
     * O (5 * 5)
     */
    private static String nextPermute(String s) {
        char[] array = s.toCharArray();
        int n = s.length();
        for (int i = n - 1; i >= 1; i--) {
            if (array[i] > array[i - 1]) {
                Arrays.sort(array, i, n);
                for (int j = i; j < n; j++) {
                    if (array[j] > array[i - 1]) {
                        swap(array, i - 1, j);
                        return new String(array);
                    }
                }
            }
        }
        Arrays.sort(array);
        return new String(array);
    }

    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    private static String secret = "zebra";
    public static int makeAGuess(String word) {
        if (word.equals(secret)) return 6;
        int[] map = new int[26];
        for (int i = 0; i < word.length(); i++) {
            map[word.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (map[secret.charAt(i) - 'a'] != 0) {
                count++;
                map[secret.charAt(i) - 'a']--;
            }
        }
        return count;
    }

    /**
     * find out all the characters in target word
     * O(26 * 5)
     */
    public static String findChars() {
        int[] scores = new int[26];
        for (char c = 'a'; c <= 'z'; c++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < secret.length(); i++)
                sb.append(c);
            int score = makeAGuess(sb.toString());
            if (score == 6) return sb.toString();
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
