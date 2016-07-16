import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *首先给一个字典，比如：{apple, people,...}
 再给一个misspelling word，比如：adple，返回它的正确拼写，即 apple
 还知道一个限制条件，misspelling word只跟原单词有一个字母的区别。如果输入是addle，返回null。如果字数不同，也返回null

 还是比较简单的一个题，一开始以为是warm up。结果发现这种简单题也是能扯出很多东西的，主要在问题的理解和交流上。
 比如：是不是需要返回所有的correction，如何降低一些时间复杂度。写完代码，又问了下我怎么测试。
 */
public class FindMissingSpelling {
    public static void main(String[] args) {
        Set<String> dict = new HashSet(Arrays.asList("apple", "people"));
        System.out.println(findMissSpelling(dict, "adple"));
    }

    /**
     * O(25 * k), k = str.length()
     */
    public static String findMissSpelling(Set<String> dict, String str) {
        if (dict == null || dict.size() == 0 || str == null || str.length() == 0) {
            return null;
        }
        int k = str.length();
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char ori = cs[i];
            for (char tmp = 'a'; tmp <= 'z'; tmp++) {
                if (ori == tmp) {
                    continue;
                }
                cs[i] = tmp;
                String tmpString = new String(cs);
                if (dict.contains(tmpString)) {
                    return tmpString;
                }
            }
            cs[i] = ori;
        }
        return null;
    }
}
