/**
 * Created by thanksgiving on 3/28/16.
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0, 5},
                {4, 3, 1, 4},
                {0, 1, 1, 4},
                {1, 2, 1, 3},
                {0, 0, 1, 1}
        };
        printArray(matrix);
        setZero(matrix);
        printArray(matrix);

    }

    /**
     * 方法1
     */
    public static void setZero(int[][] matrix) {
        boolean row0 = false;
        boolean col0 = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = true;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                row0 = true;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row0) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (col0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }


    /**
     * 方法2
     * 从0行，1列开始遍历matrix，一旦发现matrix[i][j]为0
     * 则将该行首以及该列首设置为0，再进行二次遍历
     * 二次遍历时如果发现行首或者列首为0，则当前matrix[i][j]为0
     * 二次遍历时应该逆序遍历，防止出现二次影响效果（如果matrix[0][0] == 0，那么第一行所有结果变为0，然后所有结果都会为0）
     * 注意 j 的起点为1， j == 0的情况由col0IsZero来判断
     */
    public static void setZeroesBack(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean col0IsZero = false;
        // set the head of that row and that col as 0 if one element in that row/col is 0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) col0IsZero = true;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        System.out.println("Intermediate");
        printArray(matrix);

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0IsZero) {
                matrix[i][0] = 0;
            }
        }
    }

    /**
     * print 2D array.
     */
    public static void printArray(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (j != A[i].length - 1) {
                    System.out.print(A[i][j] + ", ");
                } else
                    System.out.print(A[i][j]);

            }
            System.out.println("");
        }
        System.out.println("");
    }
}
