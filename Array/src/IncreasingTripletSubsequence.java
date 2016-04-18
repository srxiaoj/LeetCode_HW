/**
 * Created by thanksgiving on 4/16/16.
 */
public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        IncreasingTripletSubsequence obj = new IncreasingTripletSubsequence();
        int[] nums = new int[]{0, 4, 2, 1, 0, -1, -3};
        int[] nums2 = new int[]{2, 1, 5, 0, 4, 6};
        System.out.println(obj.increasingTriplet(nums));
        System.out.println(obj.increasingTriplet(nums2));
    }

    /**
     * 利用if else特性，进入第三个else的条件一定为已经不满足前两个的条件
     * 那么说明最小以及第二小数已经被找到
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int i = 0;
        int min = Integer.MAX_VALUE;
        int secondmin = Integer.MAX_VALUE;
        while (i < nums.length) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= secondmin) { // 进入这一步说明nums[i]之前一定找到了min
                secondmin = nums[i];
            } else { // 进入这一步说明nums[i]之前一定找到了min, second min
                return true;
            }
            i++;
        }
        return false;
    }
}
