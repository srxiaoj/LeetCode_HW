/**
 * Created by thanksgiving on 7/26/16.
 */
public class CombinationSumIV {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4};
        System.out.println(combinationSum4(nums, 4));
    }

    public static int combinationSum4(int[] nums, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[n];
    }

}
