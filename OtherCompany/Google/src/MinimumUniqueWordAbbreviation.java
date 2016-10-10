import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 10/10/16.
 */
public class MinimumUniqueWordAbbreviation {
    public static void main(String[] args) {
        MinimumUniqueWordAbbreviation obj = new MinimumUniqueWordAbbreviation();
        System.out.println(obj.minAbbreviation("apple", new String[]{"blade"}));
        System.out.println(obj.minAbbreviation("apple", new String[]{"plain", "amber", "blade"}));

    }

    int n, cand, bn, minlen, minab;
    List<Integer> list = new ArrayList<>();

    public String minAbbreviation(String target, String[] dictionary) {
        n = target.length();
        bn = 1 << n;
        cand = 0;
        minlen = Integer.MAX_VALUE;
        String res = new String();

        // Preprocessing with bit manipulation
        for (String w : dictionary) {
            int cur = 0;
            if (w.length() != n) continue;
            int bit = 1;
            for (int i = n - 1; i >= 0; --i) {
                if (target.charAt(i) != w.charAt(i)) cur += bit;
                bit <<= 1;
            }
            list.add(cur);
            cand |= cur;
        }
        dfs(1, 0);

        // Reconstruct abbreviation from bit sequence
        for (int i = n - 1, pre = i; i >= 0; --i, minab >>= 1) {
            if ((minab & 1) != 0) {
                if (pre - i > 0) res = String.valueOf(pre - i) + res;
                pre = i - 1;
                res = target.charAt(i) + res;
            } else if (i == 0) {
                res = String.valueOf(pre - i + 1) + res;
            }
        }
        return res;
    }

    // DFS backtracking
    private void dfs(int bit, int mask) {
        int len = abbrLen(mask, n, bn);
        if (len >= minlen) return;
        boolean match = true;
        for (int d : list) {
            if ((mask & d) == 0) {
                match = false;
                break;
            }
        }
        if (match) {
            minlen = len;
            minab = mask;
        } else
            for (int b = bit; b < bn; b <<= 1)
                if ((cand & b) != 0) dfs(b << 1, mask + b);
    }

    // Return the length of abbreviation given bit sequence
    private int abbrLen(int mask, int n, int bn) {
        // 1 2 3 3 3 4 4 4 3 4 5 5 4 5 5 5
        int count = 0;
        int b = 1;
        while (b < bn) {
            if ((mask & b) == 0) {
                while (b < bn && (mask & b) == 0) {
                    b <<= 1;
                }
            } else {
                b <<= 1;
            }
            count++;
        }
        return count;
    }
}
