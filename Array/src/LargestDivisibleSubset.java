import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by thanksgiving on 7/18/16.
 */
public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8, 9, 72};
        System.out.println(largestDivisibleSubset(nums));
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1, maxElement = nums[0];
        outer:
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (max < dp[i]) {
                        max = dp[i];
                        maxElement = nums[i];
                        continue outer;
                    }
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (maxElement % nums[i] == 0 && dp[i] == max) {
                max--;
                res.add(0, nums[i]);
                maxElement = nums[i];
            }
        }
        return res;
    }
}
