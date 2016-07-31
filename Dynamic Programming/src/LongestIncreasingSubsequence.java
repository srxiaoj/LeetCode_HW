
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] test = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] test2 = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        int[] test3 = {10, 9, 2, 5, 3, 4};
        int[] test4 = {2, 2};
        System.out.println(lengthOfLIS(test));
        System.out.println(lengthOfLIS(test2));
        System.out.println(lengthOfLIS(test3));
        System.out.println(lengthOfLIS(test4));
    }


    /**
     * method 2: binary search
     * https://leetcode.com/discuss/91624/fast-java-binary-search-solution-with-detailed-explanation
     */
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = nums[0];
        int len = 0;
        for (int i = 1; i < n; i++) {
            int pos = find(res, 0, len, nums[i]);
            if (pos > len) {
                res[pos] = nums[i];
                len++;
            } else {
                res[pos] = nums[i];
            }
        }
        return len + 1;
    }

    /**
     * 找到现有dp数组中第一个比val大的位置，如果所有值都比val小，则val放在len + 1位
     */
    private static int find(int[] res, int start, int end, int t) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (res[mid] > t) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (res[end] < t) {
            return end + 1;
        } else if (res[start] >= t) {
            return start;
        } else {
            return start + 1;
        }
    }

    /**
     * method 1: dp
     */
    public static int lengthOfLISDP(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[i - 1] > nums[j - 1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
