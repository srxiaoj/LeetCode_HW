/**
 * Created by thanksgiving on 10/9/16.
 */
public class RotateMatrix {
    public static void main(String[] args) {
        RotateMatrix obj = new RotateMatrix();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] res = obj.rotate(matrix, 0);
        Utils.printArray(res);

        int[][] res2 = obj.rotate(matrix, 1);
        Utils.printArray(res2);
    }

    public int[][] rotate(int[][] matrix, int flag) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix;
        int[][] rvalue = transpose(matrix);
        Utils.printArray(rvalue);
        flip(rvalue, flag);
        return rvalue;
    }

    private int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] rvalue = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                rvalue[i][j] = matrix[j][i];
        return rvalue;
    }

    private void flip(int[][] matrix, int flag) {
        int m = matrix.length, n = matrix[0].length;
        if (flag == 1) {    //clock wise
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n / 2; j++) {
                    matrix[i][j] ^= matrix[i][n - j - 1];
                    matrix[i][n - j - 1] ^= matrix[i][j];
                    matrix[i][j] ^= matrix[i][n - j - 1];
                }
        } else {
            for (int i = 0; i < m / 2; i++)
                for (int j = 0; j < n; j++) {
                    matrix[i][j] ^= matrix[m - i - 1][j];
                    matrix[m - i - 1][j] ^= matrix[i][j];
                    matrix[i][j] ^= matrix[m - i - 1][j];
                }
        }
    }
}
