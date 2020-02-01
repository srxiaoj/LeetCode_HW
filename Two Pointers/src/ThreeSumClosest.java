import java.util.Arrays;


public class ThreeSumClosest {

  public static void main(String[] args) {
    ThreeSumClosest obj = new ThreeSumClosest();
    int[] test1 = new int[]{-1, -5, -3, -4, 2, -2};
    System.out.println(obj.threeSumClosest(test1, 0));
  }

  /**
   * O(n^2) 复杂度 如果 min > Math.abs(nums[i] + nums[r] + nums[l] - target) 则更新min 注意要返回 nums[i] +
   * nums[r] + nums[l]
   */
  public int threeSumClosest(int[] nums, int target) {
    if (nums == null || nums.length < 3) {
      return 0;
    }
    int max = nums[0] + nums[1] + nums[2];
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      int left = target - nums[i];
      int l = i + 1, r = nums.length - 1;
      while (l < r) {
        int sum = nums[i] + nums[r] + nums[l];
        if (Math.abs(sum - target) < Math.abs(max - target)) {
          max = sum;
        }
        if (nums[l] + nums[r] < left) {
          l++;
        } else {
          r--;
        }
      }
    }
    return max;
  }
}
