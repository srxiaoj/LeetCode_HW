
public class UniquePathsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {
		              {1,0},
		              {0,0},
		            };
		int res = uniquePathsWithObstacles(A);
		System.out.println("result is: " + res);
	}
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (m == 0 && n == 0) return 0;
        int[][] sum = new int[m + 1][n + 1];
        if (obstacleGrid[0][0] == 1) sum [1][1] = 0;
        else sum[1][1] = 1;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i != 1 || j != 1) {
                    if (obstacleGrid[i - 1][j - 1] == 1) sum[i][j] = 0;
                    else sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
                }
            }
        }
        return sum[m][n];

        /*int[][] result = new int [m][n];//used to store the previous results
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(obstacleGrid[i][j] == 1)
                {
                	result[i][j] = 0;
                }
                else if(i == 0 || j == 0)
                {
                	if(i == 0 && j == 0)
                	    result[i][j] = 1;
                	else if(i == 0)
                    {
                    	result[i][j] = result[i][j-1];//check the cell on the left
                    }
                	else if(j == 0)
                		result[i][j] = result[i-1][j];//check the cell on the top
                }
                else
                {
                	result[i][j] = result[i-1][j] + result[i][j-1];
                }
            }
        }
        return result[m-1][n-1];*/
    }

}
