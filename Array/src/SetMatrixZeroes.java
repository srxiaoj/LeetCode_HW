/**
 * Created by thanksgiving on 3/28/16.
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 0, 1, 1},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 1, 0},
                {7, 8, 4, 2, 4}
        };
        printArray(matrix);
        setZeroes(matrix);
        printArray(matrix);

    }

    public static void setZeroes(int[][] matrix) {
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;
        }


        /*if (matrix == null) return;
        int row = matrix.length;
        if (row == 0) return;
        int col = matrix[0].length;
        if (col == 0) return;

        boolean[] zeroRow = new boolean[row];
        boolean[] zeroCol = new boolean[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    zeroRow[i] = true;
                    zeroCol[j] = true;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (zeroRow[i]) {
                    matrix[i][j] = 0;
                }
                if (zeroCol[j]) {
                    matrix[i][j] = 0;
                }
            }
        }*/

    }
    /**
     * print 2D array.
     * @param A array
     */
    public static void printArray(int[][] A)
    {
        for(int i = 0; i < A.length; i++)
        {
            for (int j = 0; j < A[i].length; j++) {
                if(j != A[i].length-1) {
                    System.out.print(A[i][j] + ", ");
                } else
                    System.out.print(A[i][j]);

            }
            System.out.println("");
        }
        System.out.println("");
    }
}
