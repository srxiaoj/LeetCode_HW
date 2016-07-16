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
        printDiagonal(a);

        int[][] b = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
//        printDiagonal(b);
    }

    public static void printDiagonal(int[][] a) {
        int m = a.length, n = a[0].length;
        for (int k = 0; k <= m + n; k++) {
            int temp = Math.min(k, m - 1);
            int temp2 = Math.max(0, k - n + 1);
//            System.out.println("temp " + temp + ", temp2 " + temp2);
            for (int i = temp; i >= temp2; i--) {
                int j = k - i;
                System.out.println(a[i][j]);
            }
        }
    }

}
