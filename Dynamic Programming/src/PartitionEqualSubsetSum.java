/**
 * Created by thanksgiving on 10/14/16.
 */
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
    }

    /**
     * dp[i] 表示 nums array能够组成和为i, 因此如果dp[sum] = true
     * 说明有组成总和一半的解存在
     */
    public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 != 0) return false;
        sum /= 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        // replace nums[i-1] with nums[i]
        for (int i = 0; i < nums.length; ++i) {
            for (int j = sum; j >= nums[i]; --j) {
                dp[j] = dp[j] || dp[j - nums[i]];
                if (dp[sum]) return true;
            }
        }
        return dp[sum];
    }
}
