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
         int[] array = new int[1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(matrix, i, j, Integer.MIN_VALUE, 0, array);
            }
        }
        return array[0];
    }

    private void dfs(int[][] matrix, int i, int j, int lastValue, int res, int[] array) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length
                || matrix[i][j] <= lastValue)
            return;
        res++;
        if (res > array[0]) {
            array[0] = res;
        }
        dfs(matrix, i + 1, j, matrix[i][j], res, array);
        dfs(matrix, i - 1, j, matrix[i][j], res, array);
        dfs(matrix, i, j + 1, matrix[i][j], res, array);
        dfs(matrix, i, j - 1, matrix[i][j], res, array);
    }
}