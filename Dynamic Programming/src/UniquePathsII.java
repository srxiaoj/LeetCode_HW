
public class UniquePathsII {

	public static void main(String[] args) {
		int[][] A = {
		              {0,0,0},
                      {0,1,0},
		              {0,0,0},
		            };
		int res = uniquePathsWithObstacles(A);
		System.out.println("result is: " + res);
	}

    /**
     * 如果有障碍，那么障碍位置的count为0
     */
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (m == 0 && n == 0) return 0;
        int[][] sum = new int[m + 1][n + 1];
        if (obstacleGrid[0][0] == 1) sum [1][1] = 0;
        else sum[1][1] = 1;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (!(i == 1 && j == 1)) {
                    if (obstacleGrid[i - 1][j - 1] == 1) sum[i][j] = 0;
                    else sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
                }
            }
        }
        return sum[m][n];
    }
}
