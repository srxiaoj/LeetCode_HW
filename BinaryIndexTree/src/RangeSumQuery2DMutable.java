/**
 * Created by thanksgiving on 8/13/16.
 */
public class RangeSumQuery2DMutable {

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
        obj.update(1, 2, 8);
        System.out.println(obj.sumRegion(1, 2, 2, 4));
    }


    static class NumMatrix {
        int[][] tree;
        int[][] origin;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            origin = matrix;
            tree = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    buildTree(i, j, matrix[i - 1][j - 1]);
                }
                printArray(tree);
            }
        }

        private void buildTree(int row, int col, int val) {
            for (int i = row; i < tree.length; i += i & (-i)) {
                for (int j = col; j < tree[0].length; j += j & (-j)) {
                    tree[i][j] += val;
                }
            }
        }

        private int get(int row, int col) {
            int sum = 0;
            for (int i = row; i > 0; i -= i & (-i)) {
                for (int j = col; j > 0; j -= j & (-j)) {
                    sum += tree[i][j];
                }
            }
            return sum;
        }

        public void update(int row, int col, int val) {
            int diff = val - origin[row][col];
            origin[row][col] = val;
            buildTree(row + 1, col + 1, diff);
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int res = get(row2 + 1, col2 + 1) + get(row1, col1) - get(row2 + 1, col1) - get(row1, col2 + 1);
            return res;
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
