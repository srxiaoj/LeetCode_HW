import java.util.*;

/**
 * Created by thanksgiving on 6/11/16.
 */
public class SimpleWord {
    public static void main(String[] args) {
        SimpleWord obj = new SimpleWord();
        String[] words = {"snap", "chat", "ever", "snapchat",
                "salesperson", "sales", "per", "person", "son", "whatsoever", "what", "so", "baaa", "a", "aaaaaaa", ""};
        String[] res1 = simpleWords(words);
        printArray(res1);

        String[] words2 = {"aaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "a", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaa", "aaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaa", "aaaaaaaa", "aaaaaaaaaaaaaaaaaa", "aa", "aaaaaaaaaaaaaaaaaaaaaaa", "aaa", "aaaaaaaaaaa", "aaaaaaa", "aaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaa", "aaaaaaaaaaaaa", "aaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
        String[] res2 = getSimpleWords(words2);
        printArray(res2);

        String[] words3 = {""};
        String[] res3 = getSimpleWords(words3);
        printArray(res3);
    }

    public static String[] simpleWords(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }
        for (int i = 0; i < words.length; i++) {
            if (!isCompound(words[i], set)) {
                res.add(words[i]);
            }
        }
        String[] resArray = new String[res.size()];
        resArray = res.toArray(resArray);
        return resArray;
    }

    private static boolean isCompound(String word, Set<String> set) {
        boolean wordIsInSet = false;
        if (set.contains(word)) {
            set.remove(word);
            wordIsInSet = true;
        }
        int n = word.length();
        if (n == 0) {
            return false;
        }
        boolean[] dp = new boolean[n];
        Arrays.fill(dp, false);

        for (int i = 0; i < dp.length; i++) {
            helper(set, word.substring(0, i + 1), dp);
        }
        if (wordIsInSet) {
            set.add(word);
        }
        return dp[n - 1];
    }

    private static void helper(Set<String> set, String s, boolean[] dp) {
        int n = s.length();
        if (set.contains(s)) {
            dp[n - 1] = true;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (dp[i] && set.contains(s.substring(i + 1))) {
                dp[n - 1] = true;
            }
        }
    }


    /**
     * 题型1：dict中单词能重复调用
     * by HW
     */
    public static String[] getSimpleWords(String[] words) {
        if (words == null || words.length == 0) return new String[0];
        Set<String> set = new HashSet<>();
        for (String s : words) {
            set.add(s);
        }

        for (String s : words) {
            set.remove(s);
            boolean[] dp = new boolean[s.length() + 1];
            Arrays.fill(dp, false);
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    String next = s.substring(j, i);
                    if (dp[j] && set.contains(next)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            if (!dp[s.length()] || s.equals("")) {
                set.add(s);
            }
        }
        String[] res = new String[set.size()];
        int i = 0;
        for (String s : words) {
            if (set.contains(s)) {
                res[i] = s;
                i++;
            }
        }
        return res;
    }

    //print array
    public static void printArray(String[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }
}
