/**
 * Created by thanksgiving on 2/25/16.
 */
public class LongestIncreasingPathinaMatrix {
    public static void main(String[] args) {
        LongestIncreasingPathinaMatrix obj = new LongestIncreasingPathinaMatrix();
        int[][] test = {
                {3,4,5},
                {3,2,6},
                {2,2,1}
        };
        int[][] test2 = {
                {7,8,9},
                {9,7,6},
                {7,2,3}
        };
        System.out.println(obj.longestIncreasingPath(test));
        System.out.println(obj.longestIncreasingPath(test2));
    }
    public int longestIncreasingPath(int[][] matrix) {
        int m  = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[] max = new int[1];
        int[][] len = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(matrix, i, j, Integer.MIN_VALUE, 0, max, len);
            }
        }
        return max[0];
    }

    private void dfs(int[][] matrix, int i, int j, int lastValue, int level, int[] max, int[][] len) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= lastValue) return;
        level++;
        // 利用这个条件筛去无意义dfs
        if (level > len[i][j]) {
            len[i][j] = level;
            max[0] = Math.max(max[0], level);
            dfs(matrix, i + 1, j, matrix[i][j], level, max, len);
            dfs(matrix, i - 1, j, matrix[i][j], level, max, len);
            dfs(matrix, i, j + 1, matrix[i][j], level, max, len);
            dfs(matrix, i, j - 1, matrix[i][j], level, max, len);
        }
    }
}
