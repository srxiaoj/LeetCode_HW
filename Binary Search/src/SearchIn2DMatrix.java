/**
 * Created by thanksgiving on 5/5/16.
 */
public class SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] test = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        int[][] test2 = new int[][]{{1, 4}, {2, 5}};
        int[][] test3 = new int[][]{{-5, 3}};
        System.out.println(searchMatrix(test, 17));
    }

    /**
     * 2D中所用对比值为 matrix[mid / column][mid % column]
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0, end = m * n - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int num = matrix[mid / n][mid % n];
            if (num == target) {
                return true;
            } else if (num > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (matrix[start / n][start % n] == target) {
            return true;
        }
        if (matrix[end / n][end % n] == target) {
            return true;
        }
        return false;
    }
}
