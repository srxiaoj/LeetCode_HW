/**
 * Created by thanksgiving on 10/10/16.
 */
public class MaximumSumLessThanK {
    public static void main(String[] args) {

    }

    public static int getMax(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0, j = 0, sum = 0, max = Integer.MIN_VALUE;
        while (j < nums.length) {
            while (i < j && sum > k) {
                sum -= nums[i++];
            }
            if (sum <= k) {
                max = Math.max(sum, max);
            }
            sum += nums[j];
            j++;
        }
        if (sum <= k) {
            max = Math.max(sum, max);
        }
        return max;

    }
}
