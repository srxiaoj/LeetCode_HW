import java.util.*;

/**
 * Created by thanksgiving on 5/21/16.
 */
public class WordBreakII {

  public static void main(String[] args) {
    WordBreakII obj = new WordBreakII();
    Set<String> set1 = new HashSet<>();
    set1.addAll(Arrays.asList("cat", "cats", "and", "sand", "dog"));
    System.out.println(obj.wordBreak("catsanddog", set1));
//        Set<String> set2 = new HashSet<>();
//        set2.addAll(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
//        System.out.println(obj.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                "aaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", set2));
  }

  static HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();

  public static List<String> wordBreak(String s, Set<String> wordDict) {
    if (map.containsKey(s)) {
      return map.get(s);
    }

    LinkedList<String> res = new LinkedList<String>();
    if (s.length() == 0) {
      res.add("");
      return res;
    }
    for (String word : wordDict) {
      if (s.startsWith(word)) {
        List<String> sublist = wordBreak(s.substring(word.length()), wordDict);
        for (String sub : sublist) {
          res.add(word + (sub.isEmpty() ? "" : " ") + sub);
        }
      }
    }
    map.put(s, res);
    return res;
  }

  /**
   * 先用wordBreakI判断是不是有解，有的话再dfs去找剩下的单词 注意一定要判断单词是否在wordDict中
   */
    /*public List<String> wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        boolean[] dp = new boolean[n + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (dp[j] && wordDict.contains(sub)) {
                    dp[i] = true;
                    break;
                }
            }
            printArray(dp);
        }
        if (dp[n])
            dfs(res, "", s, wordDict, 0);
        return res;
    }*/
  private void dfs(List<String> res, String part, String s, Set<String> set, int pos) {
    if (pos > s.length()) {
      return;
    }
    if (pos == s.length()) {
      // 去掉第一个空格
      part = part.substring(1);
      res.add(part);
      return;
    }

    for (int i = pos; i < s.length(); i++) {
      if (set.contains(s.substring(pos, i + 1))) {
        String newPart = part + " " + s.substring(pos, i + 1);
        dfs(res, newPart, s, set, i + 1);
      }
    }
  }
}
