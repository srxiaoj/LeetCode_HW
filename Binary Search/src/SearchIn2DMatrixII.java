/**
 * Created by thanksgiving on 5/5/16.
 */
public class SearchIn2DMatrixII {
    public static void main(String[] args) {
        int[][] test = new int[][]{
                {1, 2, 3, 4, 5},
                {2, 7, 8, 9, 10},
                {6, 12, 13, 14, 15},
                {10, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        System.out.println(searchMatrix(test, 2));
    }

    /**
     * 从0行，n-1列开始搜索，如果target > matrix[row][col]则row++，否则col--
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length - 1;
        int row = 0;
        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}