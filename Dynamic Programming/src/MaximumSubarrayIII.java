import java.util.Arrays;

public class MaximumSubarrayIII {
    public static void main(String[] args) {
        int[] a = {-1, 4, -2, 3, -2, 3};
        System.out.println(maxSubArrayDP(a, 2));
    }

    /**
     *       Index     0    1     2       3     4     5      6
     *        nums         -1,    4,     -2,    3,    -2,    3
     *  localMax[0]  -Inf -Inf   -Inf   -Inf  -Inf   -Inf  -Inf
     *  localMax[1]  -Inf  -1     4       2     5     3      6
     *  localMax[2]  -Inf -Inf    3       2     7     5      8
     *
     *  globalMax[0]  0    0      0       0     0     0      0
     *  globalMax[1] -Inf  -1     4       4     5     5      6
     *  globalMax[2] -Inf  -Inf   3       3     7     7      8
     */
    public static int maxSubArrayDP(int[] nums, int k) {
        if (nums.length < k) return 0;
        int n = nums.length;
        int[][] localMax = new int[n + 1][k + 1];
        for (int[] sub : localMax) {
            Arrays.fill(sub, Integer.MIN_VALUE);
        }
        int[][] globalMax = new int[n + 1][k + 1];
        for (int[] sub : globalMax) {
            Arrays.fill(sub, Integer.MIN_VALUE);
        }
        for (int i = 0; i <= n; i++) {
            globalMax[i][0] = 0;
        }

        for (int j = 1; j <= k; j++) {
            for (int i = j; i <= n; i++) {
                localMax[i][j] = Math.max(localMax[i - 1][j], globalMax[i - 1][j - 1]) + nums[i - 1];
                globalMax[i][j] = Math.max(localMax[i][j], globalMax[i - 1][j]);
            }
        }
        return globalMax[n][k];
    }

    /**
     * 每次从i - 1往回找到j - 1来找到dp[i][j]的最大值
     * O(n^3)
     */
    public static int maxSubArray(int[] nums, int k) {
        if (nums.length < k) return 0;
        int len = nums.length;
        //dp[i][j]: select j subarrays from the first i elements, the max sum we can get.
        int[][] dp = new int[len + 1][k + 1];
        for (int i = 0; i <= len; i++) dp[i][0] = 0;

        for (int j = 1; j <= k; j++)
            for (int i = j; i <= len; i++) {
                dp[i][j] = Integer.MIN_VALUE;
                //Initial value of curMax and max should be taken care very very carefully.
                int curMax = 0;
                int max = Integer.MIN_VALUE;
                for (int p = i - 1; p >= j - 1; p--) {
                    curMax = Math.max(nums[p], curMax + nums[p]);
                    max = Math.max(curMax, max);
                    if (dp[i][j] < dp[p][j - 1] + max)
                        dp[i][j] = dp[p][j - 1] + max;
                }
            }

        return dp[len][k];
    }

    //print array
    public static void printArray(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (j != A[i].length - 1) {
                    System.out.print(A[i][j] + ", ");
                } else
                    System.out.print(A[i][j]);

            }
            System.out.println("");
        }
        System.out.println("");
    }
}
