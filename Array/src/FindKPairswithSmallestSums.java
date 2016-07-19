import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by thanksgiving on 7/3/16.
 */
public class FindKPairswithSmallestSums {
    public static void main(String[] args) {
//        int[] a = {1, 2, 4, 5, 6};
//        int[] b = {3, 5, 7, 9};
//        System.out.println(topKSmall(a, b, 20));
//        System.out.println(topKSmall2(a, b, 20));

        int[] a1 = {1, 1, 2};
        int[] b1 = {1, 2, 3};
        System.out.println(topKSmall(a1, b1, 10));
        System.out.println(topKSmall2(a1, b1, 10));
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
        if (k > a.length * b.length) k = a.length * b.length;
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
        if (a == null || b == null || a.length == 0 || b.length == 0) return new ArrayList<>();
        if (k > a.length * b.length) k = a.length * b.length;
        int next;
        if (a.length > 1)
            next = a[1] + b[0];
        else
            next = Integer.MAX_VALUE;
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
                if (len + 1 < a.length) {
                    next = a[len + 1] + b[0];
                } else {
                    next = Integer.MAX_VALUE;
                }
                if (len >= a.length) {
                    len--;
                } else {
                    dp[len]++;
                }
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

    /**
     * output int[] list
     */
    public static List<int[]> kSmallestPairs(int[] a, int[] b, int k) {
        if (a == null || b == null || a.length == 0 || b.length == 0) return new ArrayList<>();
        if (k > a.length * b.length) k = a.length * b.length;
        int next;
        int[] nextSet;
        if (a.length > 1) {
            next = a[1] + b[0];
            nextSet = new int[]{a[1], b[0]};
        } else {
            next = Integer.MAX_VALUE;
            nextSet = new int[]{Integer.MAX_VALUE, b[0]};
        }
        List<int[]> res = new ArrayList<>();
        int[] dp = new int[a.length];

        int index = 0, start = 0, len = 0;
        while (index < k) {
            int min = Integer.MAX_VALUE;
            int[] minSet = new int[2];
            int incrementIndex = 0;
            for (int i = start; i <= len; i++) {
                if (min > a[i] + b[dp[i]]) {
                    min = a[i] + b[dp[i]];
                    minSet = new int[]{a[i], b[dp[i]]};
                    incrementIndex = i;
                }
            }

            if (min > next) {
                len++;
                res.add(nextSet);
                if (len + 1 < a.length) {
                    next = a[len + 1] + b[0];
                    nextSet = new int[]{a[len + 1], b[0]};
                } else {
                    next = Integer.MAX_VALUE;
                }
                if (len >= a.length) {
                    len--;
                } else {
                    dp[len]++;
                }
            } else {
                res.add(minSet);
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
