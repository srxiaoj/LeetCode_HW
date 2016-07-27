import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 7/26/16.
 */
public class CombinationSumIV {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4};

    }

    public static int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[target + 1];
        if (target < 4) {
            return combine(nums, target);
        }
        dp[1] = combine(nums, 1);
        dp[2] = combine(nums, 2);
        dp[3] = combine(nums, 3);
        for (int i = 4; i <= target; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        return dp[target];
    }

    public static int combine(int[] nums, int n) {
        if (nums == null || nums.length == 0) return 0;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        helper(nums, res, part, n);
        return res.size();
    }

    private static void helper(int[] nums, List<List<Integer>> res, List<Integer> part, int target) {
        if (target < 0) return;
        if (target == 0) {
            res.add(part);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] < 0) break;
            List<Integer> newPart = new ArrayList(part);
            newPart.add(nums[i]);
            helper(nums, res, newPart, target - nums[i]);
        }
    }
}
