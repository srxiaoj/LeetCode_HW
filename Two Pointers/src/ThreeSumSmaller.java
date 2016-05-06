import java.util.Arrays;

public class ThreeSumSmaller {

    public static void main(String[] args) {
        int[] test = new int[] {2, 0, 0, 2, -2};
        System.out.println(threeSumSmaller(test, 2));
    }

    /**
     * 关键点为当 nums[l] + nums[r] < twoSum时，应该增加的符合条件的组数为 r - l 组
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            int l = i + 1, r = len - 1;
            while (l < r) {
                int twoSum = target - nums[i];
                if (nums[l] + nums[r] < twoSum) {
                    count += r - l;
                    l++;
                } else {
                    r--;
                }
            }
        }

        return count;
    }
}
