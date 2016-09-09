import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 7/15/16.
 */
public class PrintDiagonalMatrix {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
//        printLeftDiagonal(a);
        System.out.println(printRightDiagonal(a));

        int[][] b = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(printRightDiagonal(b));
//        printLeftDiagonal(b);
    }

    public static List<Integer> printRightDiagonal(int[][] a) {
        List<Integer> res = new ArrayList<>();
        int m = a.length, n = a[0].length;
        for (int k = 0; k <= m + n - 1; k++) {
            int iStart = Math.max(0, k - n + 1);
            int iEnd = Math.min(k, m - 1);

            for (int i = iStart; i <= iEnd; i++) {
                int j = k - i;
                res.add(a[i][j]);
            }
        }
        return res;
    }


    public static void printLeftDiagonal(int[][] a) {
        int m = a.length, n = a[0].length;
        for (int k = 0; k <= m + n; k++) {
            int istart = Math.min(k, m - 1);
            int iEnd = Math.max(0, k - n + 1);
//            System.out.println("istart " + istart + ", iEnd " + iEnd);
            for (int i = istart; i >= iEnd; i--) {
                int j = k - i;
                System.out.print(a[i][j] + " ");
            }
        }
        System.out.println();
    }

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
