/**
 * Created by thanksgiving on 7/12/16.
 */
public class BurstBalloons {
    public static void main(String[] args) {
        int[] a = {3, 1, 5, 8};
        System.out.println(maxCoins(a));
    }

    /**
     * dp[i][j] 代表去掉(i, j)区间能得到的最大值
     * or the example [3, 1, 5, 8], the dp matrix is updated like this
     0    3    0    0    0
     0    0    15   0    0
     0    0    0    40   0
     0    0    0    0    40
     0    0    0    0    0
     0    0    0    0    0
     then

     0    3    30   0    0
     0    0    15   135  0
     0    0    0    40   48
     0    0    0    0    40
     0    0    0    0    0
     0    0    0    0    0
     at last

     0    3    30   159  167
     0    0    15   135  159
     0    0    0    40   48
     0    0    0    0    40
     0    0    0    0    0
     0    0    0    0    0
     */
    public static int maxCoins(int[] nums) {
        int[] count = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) {
            if (x > 0) count[n++] = x;
        }
        count[0] = count[n++] = 1;


        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k) {
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    // left 和 right 的最大值由 left到i 以及 i到right的分别的最大值加上 最后剩下的[left,i,right]的乘积加起来
                    dp[left][right] = Math.max(dp[left][right], count[left] * count[i] * count[right] + dp[left][i] + dp[i][right]);
            }
            printArray(dp);
        }
        return dp[0][n - 1];
    }

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
