
public class MaximalSquare {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[][] test = {{'1', '0', '1', '0', '0'},
                         {'1', '0', '1', '1', '1'},
                         {'1', '1', '1', '1', '1'},
                         {'1', '0', '0', '1', '0'}};
        char[][] test2 = {{'1', '1'},
                          {'1', '1'}};
//        System.out.println(isSquare(test, 0, 1, 0, 1));
        System.out.println(maximalSquare(test2));
    }
    public static int maximalSquare(char[][] matrix) {
        
        //method 1: DP
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

          int max = 0, row = matrix.length, col = matrix[0].length;

          // dp(i, j) represents the length of the square 
          // whose lower-right corner is located at (i, j)
          // dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) }
          int[][] dp = new int[row + 1][col + 1];

          for (int i = 1; i < row+1; i++) {
            for (int j = 1; j < col+1; j++) {
              if (matrix[i - 1][j - 1] == '1') {
                //core step: unless dp[i-1][j-1] == dp[i-1][j] == dp[i][j-1], dp[i][j] will not be a larger square
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1; 
                max = Math.max(max, dp[i][j]);
              }
            }
          }

          // return the area
          return max * max;
        
        /*
        //method 2: non DP
        int max = 0;
        int localMax = 0;
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    localMax = 1;
                    int rowMover = i;
                    int colMover = j;
                    while (isSquare(matrix, i, rowMover+1, j, colMover+1)) {
                        rowMover++;
                        colMover++;
                    }
                    localMax = Math.max(localMax, rowMover - i + 1);
                    max = Math.max(max, rowMover - i + 1);
                }
            }
        }       
        return max * max;
        */
    }
    private static boolean isSquare(char[][] num, int rowBegin, int rowEnd, int colBegin, int colEnd) {
        if ((rowEnd - rowBegin) != (colEnd - colBegin)) {
            return false;
        }
        if (rowBegin < 0 || rowEnd >= num.length || colBegin < 0 || colEnd >= num[0].length) {
            return false;
        }
        for (int i = rowBegin; i <= rowEnd; i++) {
            for (int j = colBegin; j <= colEnd; j++) {
                if (num[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
}
