/**
 * Created by Administrator on 2016/10/21.
 */
public class ThirdMaximumNumber {
    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{3, 2, 1}));
        System.out.println(thirdMax(new int[]{1, 2}));
        System.out.println(thirdMax(new int[]{2, 2, 3, 1}));
        System.out.println(thirdMax(new int[]{5, 2, 2}));
        System.out.println(thirdMax(new int[]{2, 2, 2, 1}));
        System.out.println(thirdMax(new int[]{1, -2147483648, 2}));
    }

    public static int thirdMax(int[] nums) {
        if (nums == null) return 0;
        Integer first = null, second = null, third = null;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (first != null && x == first || second != null && x == second || third != null && x == third) continue;

            if (first == null || x > first) {
                third = second;
                second = first;
                first = x;

            } else if (second == null || x > second) {
                third = second;
                second = x;

            } else if (third == null || x > third) {
                third = x;
            }
        }
        return third == null ? first : third;
    }
}
