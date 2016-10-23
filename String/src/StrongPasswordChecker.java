import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2016/10/22.
 */
public class StrongPasswordChecker {
    public static void main(String[] args) {
//        System.out.println(strongPasswordChecker("aaa")); // 3
//        System.out.println(strongPasswordChecker("!!!")); // 3
//        System.out.println(strongPasswordChecker("aaaa")); // 2
//        System.out.println(strongPasswordChecker("!!!!")); // 3
//        System.out.println(strongPasswordChecker("aaaaa")); // 2
//        System.out.println(strongPasswordChecker("!!!!!")); // 3
//        System.out.println(strongPasswordChecker("aabca"));
//        System.out.println(strongPasswordChecker("A1aabca"));
//        System.out.println(strongPasswordChecker("a1aabca"));
//        System.out.println(strongPasswordChecker("a1aabca"));
        System.out.println(strongPasswordChecker("1Abababcaaaabababababa")); // 2
        System.out.println(strongPasswordChecker("aaaabbaaabbaaa123456A"));  // 3
    }

    public static int strongPasswordChecker(String s) {
        if (s == null || s.length() == 0) return 6;
        boolean lower = false, upper = false, digit = false;
        int distance = 0, len = s.length();

        List<Integer> repeating = new ArrayList<>();
        char prev = '\0';
        int count = 0;
        for (char c : s.toCharArray()) {
            lower |= c >= 'a' && c <= 'z';
            upper |= c >= 'A' && c <= 'Z';
            digit |= c >= '0' && c <= '9';
            if (c == prev) {
                count++;
            } else {
                if (count >= 3) {
                    repeating.add(count);
                }
                count = 1;
                prev = c;
            }
        }
        if (count >= 3) {
            repeating.add(count);
        }
        int required = (lower ? 0 : 1) + (upper ? 0 : 1) + (digit ? 0 : 1);
        int requiredLength = 0;
        int patch = 0;
        Collections.sort(repeating);
        int i = 0;
        while (i < repeating.size()) {
            int c = repeating.get(i);
            if (len > 20) {
                requiredLength = len - 20;
                int delta = Math.min(len - 20, c - 2);
                c -= delta;
                len -= delta;
                distance += delta;
            }

            // 移除重复的3个中的一个，既可以减少长度，又可以去掉重复
            if (len <= 20 && len >= 6) {
                distance += c / 3;
                patch += c / 3;
            } else if (len < 6) {
                requiredLength = 6 - len;
                patch += 1 + len - 6;
                distance += patch;
                len = 6;
            }
            i++;
        }
        if (len < 6) {
            distance += 6 - len;
            // 如果少于6个字符，则可以把这些缺少的字符用来补充少的大小写或是数字
            // 所以需要再从required中减去这个patch的部分
            patch += 6 - len;
        } else if (len > 20) {
            distance += len - 20;
        }
        required -= patch;
        // 需要同时满足最小长度为6，这个由requiredLength
        return Math.max(requiredLength, distance + Math.max(required, 0));
    }
}
