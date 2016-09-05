import java.util.Arrays;

/**
 * Created by thanksgiving on 9/4/16.
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {
                {'0', '0', '1', '0', '0'},
                {'1', '1', '1', '1', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '1', '0', '0'}
        };

        char[][] matrix2 = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'}
//                {'1', '1', '1', '1', '1'},
//                {'1', '0', '0', '1', '0'}
        };

        char[][] matrix3 = {
                {'0', '0', '0', '1', '0', '0', '0'},
                {'0', '0', '1', '1', '1', '0', '0'},
                {'0', '1', '1', '1', '1', '1', '0'}
        };
        System.out.println(maximalRectangle(matrix2));
    }

    /**
     * height counts the number of successive '1's above (plus the current one).
     * The value of left & right means the boundaries of the rectangle which contains the current point with a height of value height
     */
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int left[] = new int[n], right[] = new int[n], height[] = new int[n];
        Arrays.fill(right, n); //left and height will be default having values 0
        int maxA = 0;
        for (int i = 0; i < m; i++) {
            int leftBoundary = 0, rightBoundary = n - 1;

            for (int j = 0; j < n; j++) { // compute height (can do this from either side)
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }

            for (int j = 0; j < n; j++) { // compute left (from left to right)
                if (matrix[i][j] == '1') {
                    // 左边界和上一行边界比较取较大的
                    left[j] = Math.max(left[j], leftBoundary);
                } else {
                    left[j] = 0;
                    leftBoundary = j + 1;
                }
            }

            // compute right (from right to left)
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    // 右边界的上一行比较取较小的
                    right[j] = Math.min(right[j], rightBoundary);
                } else {
                    right[j] = n - 1;
                    rightBoundary = j - 1;
                }
            }

            // compute the area of rectangle (can do this from either side)
            for (int j = 0; j < n; j++)
                maxA = Math.max(maxA, (right[j] - left[j] + 1) * height[j]);


            System.out.println("---");
            printArray(left);
            printArray(right);
            printArray(height);
        }
        return maxA;
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
