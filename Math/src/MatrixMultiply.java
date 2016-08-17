/**
 * Created by thanksgiving on 5/30/16.
 */
public class MatrixMultiply {
    public static void main(String[] args) {
        int[][] a = {
                {2,3},
                {7,1},
                {2,1}
        };
        int[][] b = {
                {1,1,2},
                {0,2,3}
        };
        int[][] c = multiplyMatrix(a, b);
        printArray(c);


        int[][] a2 = {
                {1, 0, 0},
                {-1, 0, 3}
        };
        int[][] b2 = {
                {7, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        };
        int[][] c2 = multiplyMatrix(a2, b2);
        printArray(c2);
    }

    public static int[][] multiplyMatrix(int[][] a, int[][] b) {
        int m = a.length, l = a[0].length, nb = b[0].length;
        int[][] c = new int[m][nb];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < nb; j++) {
                for (int k = 0; k < l; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    /**
     * print 2D array.
     * @param A array
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
