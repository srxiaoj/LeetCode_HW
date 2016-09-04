/**
 * Created by thanksgiving on 9/3/16.
 * 找到一个array不能组合成出来的sum中的最小的一个
 */
public class SmallestNumberFromSumOfArray {
    public static void main(String[] args) {
        System.out.println(getSmallest(new int[]{1, 5, 10}));
        System.out.println(getSmallest(new int[]{1, 2, 4, 13}));
        System.out.println(getSmallest(new int[]{1, 2, 31, 33}));
        System.out.println(getSmallest(new int[]{2}));
    }

    private static int getSmallest(int[] nums) {
        int miss = 1;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                return miss;
            }
        }
        return nums[nums.length - 1] + 1;
    }


}
