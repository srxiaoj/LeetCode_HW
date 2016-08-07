import java.util.Arrays;

/**
 * Created by thanksgiving on 12/27/15.
 */
public class JumpGameII {
    public static void main(String[] args) {
        JumpGameII obj = new JumpGameII();
        System.out.println(obj.jump(new int[] {2, 3, 1, 1, 1, 4, 5, 4}));
        System.out.println(obj.jump(new int[] {2, 3, 1, 1, 4}));
        System.out.println(obj.jump(new int[] {1, 2, 3}));
    }

    /**
     * 每到一个点，去追溯这个点所能reach的最远的点，并把那个点的最小值更新，如果达到了终点，则直接返回
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if (n == 1) return 0;
        if (nums[0] >= n - 1) return 1;
        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1] - 1) {
                continue;
            }
            if (nums[i] + i >= n - 1) {
                return dp[i] + 1;
            }
            for (int j = i + 1; j <= nums[i] + i; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return 0;
       /* if (nums.length <= 1) return 0;
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
        return pos[nums.length - 1];*/
    }

    private int updatePos(int[] nums, int[] pos, int start, int end) {
        if (nums[start] >= end - start) {
            return 1 + pos[start];
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static void printArray(int[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }
}
