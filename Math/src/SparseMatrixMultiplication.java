import java.util.ArrayList;
import java.util.List;

/**
 * https://discuss.leetcode.com/topic/30625/easiest-java-solution/2
 * 将 a 转变为非零ArrayList数组
 * [[0, 1]
 *  [0, -1], [2, 3]]
 */
public class SparseMatrixMultiplication {
    public static void main(String[] args) {
        int[][] a = {
                {1, 0, 0},
                {-1, 0, 3}
        };
        int[][] b = {
                {7, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        };
        int[][] c = multiply(a, b);
        printArray(c);

        int[][] a2 = {
                {1, -5}
        };
        int[][] b2 = {
                {12},
                {-1},
        };
        int[][] c2 = multiply(a2, b2);
        printArray(c2);
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int m = a.length, l = a[0].length, nb = b[0].length;
        int[][] c = new int[m][nb];
        List<int[]>[] aVec = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            aVec[i] = new ArrayList<>();
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < l; j++) {
                if (a[i][j] != 0) {
                    int[] temp = new int[2];
                    temp[0] = j;
                    temp[1] = a[i][j];
                    aVec[i].add(temp);
                }
            }
        }

        printDensityVector(aVec);
        for (int i = 0; i < aVec.length; i++) {
            for (int j = 0; j < aVec[i].size(); j++) {
                int colA = aVec[i].get(j)[0];
                int valA = aVec[i].get(j)[1];
                for (int k = 0; k < nb; k++) {
                    c[i][k] += valA * b[colA][k];
                }
            }
        }
        return c;
    }

    public static void printDensityVector(List<int[]>[] lists) {
        for (int i = 0; i < lists.length; i++) {
            System.out.print("[");
            for (int j = 0; j < lists[i].size(); j++) {
                int[] temp = lists[i].get(j);
                System.out.print("[" + temp[0] + "," +temp[1] + "]");
            }
            System.out.println("]");
        }
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
