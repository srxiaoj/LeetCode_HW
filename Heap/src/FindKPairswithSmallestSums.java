import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by thanksgiving on 7/3/16.
 */
public class FindKPairswithSmallestSums {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 6};
        int[] b = {3, 5, 7, 9};
        printDensityVector(kSmallestPairsPQ(a, b, 10));

        int[] a1 = {1, 1, 2};
        int[] b1 = {1, 2, 3};
//        printDensityVector(kSmallestPairsPQ(a1, b1, 10));
    }


    /**
     * PriorityQueue 方法
     */
    public static List<int[]> kSmallestPairsPQ(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        List<int[]> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        for (int i = 0; i < nums1.length && i < k; i++) queue.offer(new int[]{nums1[i], nums2[0], 0});
        while (k-- > 0 && !queue.isEmpty()) {
            int[] cur = queue.poll();
            res.add(new int[]{cur[0], cur[1]});
            if (cur[2] == nums2.length - 1) continue;
            queue.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return res;
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

    public static void printDensityVector(List<int[]> lists) {
        System.out.print("[");
        for (int j = 0; j < lists.size(); j++) {
            int[] temp = lists.get(j);
            System.out.print("[" + temp[0] + "," + temp[1] + "]");
        }
        System.out.println("]");
    }
}
