/**
 * 给一个int[][]的matrix，对于一条从左上到右下的path p_i，p_i中的最小值是m_i，求所有m_i中的最大值。
 * 只能往下或右. from:比如：[8, 4, 7][6, 5, 9]有3条path：8-4-7-9 min: 4 8-4-5-9 min: 4 8-6-5-9 min: 5 return: 5✓
 */
public class MaximumMinimumPath {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{8, 4, 7}, {6, 5, 9}};
        System.out.println(maximumMinimumPath(matrix));

        int[][] matrix2 = new int[][]{{8, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(maximumMinimumPath(matrix2));
    }

    /**
     * solution 1
     */
    public static int maximumMinimumPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        // dp[i,j]路径中最小值 (不过下边有所不同)
        dp[0][0] = matrix[0][0];// [0,0] 肯定在考虑点中
        for (int i = 1; i < m; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], matrix[i][0]);
        }

        printArray(dp);
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.min(dp[0][i - 1], matrix[0][i]);
        }
        printArray(dp);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 每次选点的时候,因为路径只可能是从上或者从左, 所以选其中较大的, 再去合当前值比较.即可
                dp[i][j] = Math.min(Math.max(dp[i - 1][j], dp[i][j - 1]), matrix[i][j]);
            }
        }
        printArray(dp);
        return dp[m - 1][n - 1];
    }


    /**
     * solution 2
     */
    private int maxMin;

    public int maximumMinimumPath2(int[][] mat) {
        maxMin = Integer.MIN_VALUE;
        dfs(mat, 0, 0, Integer.MAX_VALUE);
        return maxMin;
    }

    private void dfs(int[][] mat, int i, int j, int minSofar) {
        if (mat.length == 0 || mat[0].length == 0) return;
        int M = mat.length, N = mat[0].length;
        if (i == M || j == N) return;

        minSofar = Math.min(minSofar, mat[i][j]);
        if (i == M - 1 && j == N - 1) {
            maxMin = Math.max(minSofar, maxMin);
        }

        dfs(mat, i + 1, j, minSofar);
        dfs(mat, i, j + 1, minSofar);
    }


    /**
     * print 2D array.
     */
    public static void printArray(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print("[");
            for (int j = 0; j < A[i].length; j++) {
                if (j != A[i].length - 1) {
                    System.out.print(A[i][j] + ", ");
                } else
                    System.out.print(A[i][j]);

            }
            System.out.println("]");
        }
        System.out.println("");
    }
}
