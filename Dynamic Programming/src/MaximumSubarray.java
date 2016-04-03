/**
 * Created by thanksgiving on 1/31/16.
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray obj = new MaximumSubarray();
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] b = {-1, -2, 3, 4, -5, 6};
        System.out.println(obj.maxSubArray(a));
        System.out.println(obj.maxSubArray(b));
    }

    /**
     * 当前local最大为累计最大和当前值比较
     * 全局最大为local最大和全局最大比较
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0], maxCur = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            maxCur = Math.max(maxCur + nums[i], nums[i]);
            max = Math.max(max, maxCur);
        }
        return max;

        /*if (nums == null || nums.length == 0) return 0;
        int maxCur = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (maxCur < 0) {
                maxCur = nums[i];
            } else {
                maxCur += nums[i];
            }
            if (maxCur > max) {
                max = maxCur;
            }
        }
        return max;*/
    }
}
