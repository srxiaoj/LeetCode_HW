import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by thanksgiving on 7/3/16.
 */
public class topKSmallestInSumOfTwoArray {
    public static void main(String[] args) {
        int[] a = {1, 4, 7, 20, 70, 100};
        int[] b = {1, 3, 5, 8, 40};
        System.out.println(topKSmall(a, b, 20));
        System.out.println(topKSmall2(a, b, 20));
    }

    /**
     * brute force, O(m, n)
     */
    public static List<Integer> topKSmall2(int[] a, int[] b, int k) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                res.add(a[i] + b[j]);
            }
        }
        Collections.sort(res);
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            output.add(res.get(i));
        }
        return output;
    }

    /**
     * 只在start 和 len 之间找下一个最小值，len的大小由下一个可能出现的最小值next= a[i + 1] + b[0]决定
     */
    public static List<Integer> topKSmall(int[] a, int[] b, int k) {
        if (k > a.length * b.length) return null;
        int next = a[1] + b[0];
        List<Integer> res = new ArrayList<>();
        int[] dp = new int[a.length];

        int index = 0, start = 0, len = 0;
        while (index < k) {
            int min = Integer.MAX_VALUE;
            int incrementIndex = 0;
            for (int i = start; i <= len; i++) {
                if (min > a[i] + b[dp[i]]) {
                    min = a[i] + b[dp[i]];
                    incrementIndex = i;
                }
            }

            if (min > next) {
                len++;
                res.add(next);
                if (len + 1 < a.length)
                    next = a[len + 1] + b[0];
                dp[len]++;
            } else {
                res.add(min);
                dp[incrementIndex]++;
                if (dp[incrementIndex] == b.length) {
                    start++;
                }
            }
            index++;
        }
        return res;
    }
}
