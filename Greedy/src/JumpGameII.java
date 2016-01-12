import java.util.Arrays;

/**
 * Created by thanksgiving on 12/27/15.
 */
public class JumpGameII {
    public static void main(String[] args) {
        JumpGameII obj = new JumpGameII();
        int[] test = {2, 3, 1, 1, 1, 4, 5, 4};
        System.out.println(obj.jump(test));
    }

    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        // use an array to store minimum steps needed to reach it
        int[] pos = new int[nums.length];
        Arrays.fill(pos, Integer.MAX_VALUE);
        int start = 0;
        // if the last number is one larger then the next one, then ignore the last index
        while (start + 1 < nums.length && nums[start] - nums[start + 1] == 1) start++;
        if (start == nums.length - 1) return 1;
        pos[start] = 0;
        int tmp = start;
        for (int i = start + 1; i < nums.length; i++) {
            while (updatePos(nums, pos, tmp, i) == Integer.MAX_VALUE) tmp++;
            for (int j = tmp; j < i; j++) {
                int val = updatePos(nums, pos, j, i);
                if (pos[i] > val) {
                    pos[i] = val;
                }
            }
        }
        return pos[nums.length - 1];
    }

    private int updatePos(int[] nums, int[] pos, int start, int end) {
        if (nums[start] >= end - start) {
            return 1 + pos[start];
        } else {
            return Integer.MAX_VALUE;
        }
    }
}
