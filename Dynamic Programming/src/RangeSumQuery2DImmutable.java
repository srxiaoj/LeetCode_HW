/**
 * Created by thanksgiving on 1/12/16.
 */
public class RangeSumQuery2DImmutable {
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5},
        };
        NumMatrix obj = new NumMatrix(matrix);
        System.out.println(obj.sumRegion(2, 1, 4, 3));
        System.out.println(obj.sumRegion(1, 1, 2, 2));
        System.out.println(obj.sumRegion(1, 2, 2, 4));
    }

    /**
     * https://segmentfault.com/a/1190000004238792
     * update time: O(n), space: O(1)
     * sumRegion time: O(m), space: O(1)
     */
    private static class NumMatrix {
        int[][] rowSums;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0) return;
            rowSums = new int[matrix.length][matrix[0].length];

            // 建rowSums矩阵
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    rowSums[i][j] = matrix[i][j] + (j == 0 ? 0 : rowSums[i][j - 1]);
                }
            }
        }

        public void update(int row, int col, int val) {
            // 求出新值与旧值的差
            int diff = val - (rowSums[row][col] - (col == 0 ? 0 : rowSums[row][col - 1]));

            // 更新该行受影响的sum
            for (int j = col; j < rowSums[0].length; j++) {
                rowSums[row][j] += diff;
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int res = 0;

            // 逐行求和，每行的相应和为两sum相减
            for (int i = row1; i <= row2; i++) {
                res += rowSums[i][col2] - (col1 == 0 ? 0 :rowSums[i][col1 - 1]);
            }
            return res;
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

    //print array
    public static void printArray(int[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }
}
