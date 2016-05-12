import java.util.Arrays;

public class JumpGame {

	public static void main(String[] args) {
		 int [] test = new int[]{2, 3, 1, 1, 4};
		int [] test2 = new int[]{3, 2, 1, 0, 4};
		System.out.println("this can be done ? " + canJump(test));
		System.out.println("this can be done ? " + canJump(test2));
	}

	/**
	 * 注意 j 从 i-1 到 0 去loop，一旦是true则break， greedy approach
     */
	public static boolean canJump(int[] nums) {
		if (nums == null) return true;
		int n = nums.length;

		boolean[] dp = new boolean[n];
		Arrays.fill(dp, false);
		dp[0] = true;
		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (dp[j] && nums[j] >= i - j) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n - 1];
    }

}
