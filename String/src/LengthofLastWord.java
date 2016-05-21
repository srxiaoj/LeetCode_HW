/**
 * Created by thanksgiving on 5/21/16.
 */
public class LengthofLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("abc "));
        System.out.println(lengthOfLastWord(" a "));
        System.out.println(lengthOfLastWord(" a"));
        System.out.println(lengthOfLastWord("a "));
        System.out.println(lengthOfLastWord("  "));
        System.out.println(lengthOfLastWord(" b  a  "));
        System.out.println(lengthOfLastWord("day  "));
    }

    /**
     * 先找到最后一个空格，如果不存在则返回 s.length()
     * 如果这个空格不是在最后一位，那么之后的string长度则为last word的长度
     * 如果空格在最后一位，则要往前看前一个单词
     * 如果存在前一个单词，则要找到这个单词前的空格和之后的空格之间的差
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        // 如果单词出现在空格之后
        int lastSpace = s.lastIndexOf(" ");
        if (lastSpace == -1) return n;
        if (lastSpace != n - 1) {
            return n - lastSpace - 1;
        }

        // 如果单词出现在空格之前
        int i = lastSpace - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        if (i < 0) return 0;
        int secondLastSpace = s.substring(0, i).lastIndexOf(" ");
        if (secondLastSpace == -1) return i + 1;
        return i - secondLastSpace;
    }
}
