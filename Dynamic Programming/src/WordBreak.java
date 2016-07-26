import java.util.*;

/**
 * Created by thanksgiving on 12/29/15.
 */
public class WordBreak {
    public static void main(String[] args) {
        WordBreak obj = new WordBreak();
        Set<String> dict = new HashSet<>();
        dict.add("car");
        dict.add("ca");
        dict.add("rs");
        System.out.println(obj.wordBreak("cars", dict));
    }

    /**
     * 如果s.substring(0,j)是wordbreakable, 而且s.substring(j,i)在wordDict中，则s.substring(0, i)是wordbreakable
     */
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null && wordDict == null) return true;
        if (s == null || wordDict == null) return false;
        //dp[i] represents if s.substring(0, i) is wordbreakable.
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
            printArray(dp);
        }
        return dp[s.length()];
    }


    public static void printArray(boolean[] A) {
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
