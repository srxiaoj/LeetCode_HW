import java.util.Arrays;

/**
 * Created by thanksgiving on 5/5/16.
 */
public class MinimumPathSum {

  public static void main(String[] args) {
    MinimumPathSum obj = new MinimumPathSum();
    int[][] grid = new int[][]{
        {1, 3, 1},
        {1, 5, 1},
        {4, 2, 1},
    };
    System.out.println(obj.minPathSum(grid));
  }

  public int minPathSum(int[][] grid) {
        /*if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = grid[0][0];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (!(i == 1 && j == 1))
                    dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i - 1][j - 1];
            }
        }
        return dp[n];*/
    if (grid == null) {
      return 0;
    }
    int m = grid.length;
    int n = grid[0].length;

    int[][] dp = new int[m][n];
    dp[0][0] = grid[0][0];

    for (int i = 1; i < m; i++) {
      dp[i][0] = dp[i - 1][0] + grid[i][0];
    }
    for (int i = 1; i < n; i++) {
      dp[0][i] = dp[0][i - 1] + grid[0][i];
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
      }
    }
    return dp[m - 1][n - 1];
  }
}
