import java.util.HashMap;

/**
 * Created by thanksgiving on 1/21/16.
 */
public class MaximumSizeSubarraySumEqualsk {
    public static void main(String[] args) {
        MaximumSizeSubarraySumEqualsk obj = new MaximumSizeSubarraySumEqualsk();
        int[] nums = {1, -1, 5, -2, 3};
        System.out.println(obj.maxSubArrayLen(nums, 3));
        int[] nums2 = {-2, -1, 2, 1};
        System.out.println(obj.maxSubArrayLen(nums2, 1));
    }

    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, max = 0;
        // cache sum to maximum length
        HashMap<Integer, Integer> sumLengthMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                max = i + 1;
            } else if (sumLengthMap.containsKey(sum - k)) { // sum is already larger than k
                max = Math.max(max, i - sumLengthMap.get(sum - k));
            }
            // 只保存出现这个sum的最小的subarray
            if (!sumLengthMap.containsKey(sum)) {
                sumLengthMap.put(sum, i);
            }
        }
        return max;

        /*int n = nums.length;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int count = 0;
        for (int i = 0; i < n + 1; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                if (sum[j] - sum[i] == k) {
                    if (j - i > count) {
                        count = j - i;
                    }
                }
            }
        }
        return count;*/
    }
}
