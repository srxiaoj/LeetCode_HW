import java.util.Arrays;


public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest obj = new ThreeSumClosest();
        int[] test1 = new int[] {-1, -5, -3, -4, 2, -2};
        System.out.println(obj.threeSumClosest(test1, 0));
    }

    /**
     * O(n^2) 复杂度
     * 如果 min > Math.abs(nums[i] + nums[r] + nums[l] - target) 则更新min
     * 注意要返回 nums[i] + nums[r] + nums[l]
     */
    public int threeSumClosest(int[] nums, int target) {
        int l;
        int r;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];
            l = i + 1;
            r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] <= needed) {
                    if (min > Math.abs(nums[i] + nums[r] + nums[l] - target)) {
                        min = Math.abs(nums[i] + nums[r] + nums[l] - target);
                        res = nums[i] + nums[r] + nums[l];
                    }
                    l++;
                } else {
                    if (min > Math.abs(nums[i] + nums[r] + nums[l] - target)) {
                        min = Math.abs(nums[i] + nums[r] + nums[l] - target);
                        res = nums[i] + nums[r] + nums[l];
                    }
                    r--;
                }
            }
        }
        return res;
    }
}
