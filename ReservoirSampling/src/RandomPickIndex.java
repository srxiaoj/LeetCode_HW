import java.util.Random;

/**
 * Created by thanksgiving on 9/16/16.
 */
public class RandomPickIndex {
    public static void main(String[] args) {
        RandomPickIndex obj = new RandomPickIndex(new int[] {1, 2, 2, 3, 3, 3});
        System.out.println(obj.pick(3));
    }

    Random r;
    int[] nums;
    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.r = new Random();
    }

    public int pick(int target) {
        int res = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            // r.nextInt(++count) == 0 或者 count - 1都可以
            if (target == nums[i] && r.nextInt(++count) == count - 1) {
                res = i;
            }
        }
        return res;
    }
}
