/**
 * Created by thanksgiving on 7/5/16.
 */
public class LongestIncreasingSequenceinaMatrix {
    public static void main(String[] args) {
        int[][] grid = {
                {7, 8, 1, 2},
                {6, 5, 4, 3}
        };
        System.out.println(longestIncreasingContinuousSubsequenceII(grid));
    }


    /**
     * 方法1：dfs + dp
     */
    public static int longestIncreasingContinuousSubsequenceII(int[][] A) {
        int max = 0;
        if (A == null || A.length == 0 || A[0].length == 0) {
            return max;
        }
        int[][] dp = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (dp[i][j] == 0) {
                    max = Math.max(max, dfs(A, dp, i, j));
                }
            }
        }
        return max;
    }

    private static int dfs(int[][] a, int[][] dp, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int left = 0, right = 0, up = 0, down = 0;
        if (j + 1 < a[0].length && a[i][j + 1] > a[i][j]) {
            right = dfs(a, dp, i, j + 1);
        }
        if (j > 0 && a[i][j - 1] > a[i][j]) {
            left = dfs(a, dp, i, j - 1);
        }
        if (i + 1 < a.length && a[i + 1][j] > a[i][j]) {
            down = dfs(a, dp, i + 1, j);
        }
        if (i > 0 && a[i - 1][j] > a[i][j]) {
            up = dfs(a, dp, i - 1, j);
        }
        dp[i][j] = Math.max(Math.max(up, down), Math.max(left, right)) + 1;
        return dp[i][j];
    }


    /**
     * 方法2: dfs
     */
    public static int longestSequence(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] res = new int[1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(grid, i, j, 0, res, Integer.MIN_VALUE);
            }
        }
        return res[0];
    }

    public static void dfs(int[][] grid, int i, int j, int level, int[] res, int last) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if (grid[i][j] <= last) return;
        level++;
        res[0] = Math.max(res[0], level);
        dfs(grid, i + 1, j, level, res, grid[i][j]);
        dfs(grid, i - 1, j, level, res, grid[i][j]);
        dfs(grid, i, j + 1, level, res, grid[i][j]);
        dfs(grid, i, j - 1, level, res, grid[i][j]);
    }
}
