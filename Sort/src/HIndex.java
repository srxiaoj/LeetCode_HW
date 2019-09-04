import java.util.Arrays;
public class HIndex {
    public static void main(String[] args) {
        System.out.println("The h index is: " + hIndex3(new int[]{3, 0, 6, 1, 5}));
        System.out.println("The h index is: " + hIndex3(new int[]{1, 1}));
        System.out.println("The h index is: " + hIndex3(new int[]{0, 0, 0}));
        System.out.println("The h index is: " + hIndex3(new int[]{11, 15}));
    }

    /**
     * binary search 找到第一个 citations[i] >= n - i的数，返回 n - i
     */
    public static int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        int n = citations.length;
        int l = 0, r = citations.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (citations[mid] >= n - mid) {
                r = mid;
            } else {
                l = mid;
            }
        }
        System.out.println(l + " " + r);
        if (citations[l] >= n - l) {
            return n - l;
        } else if (citations[r] >= n - r) {
            return n - r;
        } else {
            return 0;
        }
    }

    /**
     * 标准解法，先排序
     *
     * citations[i] >= n - i 代表有 h 个高于或等于 h 的值, citations[i - 1] <= n - i 代表剩下的n - h个小于等于h的值
     * 注意corner case, i == 0 时, 如果citations[0] >= n， 则说明所有值都大值n
     */
    public static int hIndex3(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int n = citations.length;
        Arrays.sort(citations);

        for (int i = n - 1; i > 0; i--) {
            if (citations[i] >= n - i && citations[i - 1] <= n - i) {
                return n - i;
            }
        }
        if (citations[0] >= n) return n;
        return 0;
    }

   /* public static int hIndex2(int[] citations) {
        // method 1: 排序再数大于citation[i]的个数
        *//*Arrays.sort(citations);
        int n = citations.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int k = n - i;
            if (k <= citations[i]) {
                max = Math.max(k, max);
            }
        }
        return max;*//*

        *//**
         * method2: Basically we iterate the array for two rounds.
         * In first round we count how many citation in each bucket and
         * in the second round we traverse back to find the maximum h.
         *//*
        int n = citations.length;
        int[] count = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int index = Math.min(n, citations[i]);
            count[index]++;
        }
        printArray(count);

        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += count[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }*/
}