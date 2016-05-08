/**
 * Created by thanksgiving on 3/28/16.
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {7, 1, 4, 2, 4}
        };
        printArray(matrix);
        setZeroes(matrix);
        printArray(matrix);

    }

    /**
     * 从0行，1列开始遍历matrix，一旦发现matrix[i][j]为0
     * 则将该行首以及该列首设置为0，再进行二次遍历
     * 二次遍历时如果发现行首或者列首为0，则当前matrix[i][j]为0
     * 二次遍历时应该逆序遍历，防止出现二次影响效果（改数为０是因为别的数为０而变化为０）
     * 注意 j 的起点为1， j == 0的情况由col0IsZero来判断
     */
    public static void setZeroes(int[][] matrix) {
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
