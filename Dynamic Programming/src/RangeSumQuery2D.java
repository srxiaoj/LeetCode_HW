/**
 * Created by thanksgiving on 1/12/16.
 */
public class RangeSumQuery2D {
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

        int[][] matrix2 = {{}};
        NumMatrix obj2 = new NumMatrix(matrix);
        System.out.println(obj2.sumRegion(2, 1, 4, 3));
        System.out.println(obj2.sumRegion(1, 1, 2, 2));
        System.out.println(obj2.sumRegion(1, 2, 2, 4));
    }

    private static class NumMatrix {
        private int[][] sum;
        private int[][] colSum;
        private int[][] rowSum;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                rowSum = null;
                colSum = null;
                sum = null;
                return;
            }
            rowSum = new int[matrix.length][matrix[0].length + 1];
            colSum = new int[matrix.length + 1][matrix[0].length];
            sum = new int[matrix.length + 1][matrix[0].length + 1];
            rowSum[0][0] = 0;
            colSum[0][0] = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length + 1; j++) {
                    rowSum[i][j] = rowSum[i][j - 1] + matrix[i][j - 1];
                }
            }
            for (int j = 0; j < matrix[0].length; j++) {
                for (int i = 1; i < matrix.length + 1; i++) {
                    colSum[i][j] = colSum[i - 1][j] + matrix[i - 1][j];
                }
            }
            for (int i = 1; i < matrix.length + 1; i++) {
                for (int j = 1; j < matrix[0].length + 1; j++) {
                    sum[i][j] = sum[i - 1][j - 1] + rowSum[i - 1][j - 1] + colSum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }

            printArray(rowSum);
            printArray(colSum);
            printArray(sum);
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (sum == null) return 0;
            return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
        }

        /**
         * print 2D array.
         *
         * @param A array
         */
        public static void printArray(int[][] A) {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                    if (j != A[i].length - 1) {
                        System.out.print(A[i][j] + ", ");
                    } else {
                        System.out.print(A[i][j]);
                    }
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }
}
