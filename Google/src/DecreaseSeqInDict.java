import java.util.HashSet;
import java.util.Set;

/**
 * 給一个单词和一个字典。每次删除单词里任何一个字母直到剩下一个字母，形成一个序列
 * 比如office->offce->ofce->ofc->oc->c。问是字典里否存在一个这种序列。
 */
public class DecreaseSeqInDict {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("office");
        dict.add("offce");
        dict.add("ofce");
        dict.add("ofc");
        dict.add("oc");
        dict.add("c");
        System.out.println(hasDecreaseSeq("office", dict));
    }

    public static boolean hasDecreaseSeq(String s, Set<String> dict) {
        if (s.equals("")) return true;
        if (!dict.contains(s)) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            String first = s.substring(0, i);
            String second = s.substring(i + 1);
            System.out.println(first + second);
            if (hasDecreaseSeq(first + second, dict)) {
                return true;
            }
        }
        return false;
    }
}
