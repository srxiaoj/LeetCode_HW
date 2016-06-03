
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] test = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] test2 = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        int[] test3 = {10, 9, 2, 5, 3, 4};
        int[] test4 = {2, 2};
        System.out.println(lengthOfLIS2(test));
        System.out.println(lengthOfLIS2(test2));
        System.out.println(lengthOfLIS2(test3));
        System.out.println(lengthOfLIS2(test4));
    }

    /**
     * method 1: dp
     */
    public static int lengthOfLIS(int[] nums) {
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

    /**
     * method 2: binary search
     * https://leetcode.com/discuss/91624/fast-java-binary-search-solution-with-detailed-explanation
     */
    public static int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int len = 0;
        for (int i = 1; i < nums.length; i++) {
            int pos = binarySearch(dp, len, nums[i]);
            if (nums[i] < dp[pos]) dp[pos] = nums[i];
            if (pos > len) {
                len = pos;
                dp[len] = nums[i];
            }
        }
        return len + 1;
    }

    private static int binarySearch(int[] dp, int len, int val) {
        int start = 0;
        int end = len;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (dp[mid] == val) {
                return mid;
            } else {
                if (dp[mid] < val) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (dp[end] < val) return len + 1;
        else if (dp[start] >= val) return start;
        else return end;
    }
}
