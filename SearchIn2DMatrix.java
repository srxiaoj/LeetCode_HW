public class SearchIn2DMatrix {

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,2,3,4,5}, 
                                         {6,7,8,9,10},
                                         {11,12,13,14,15}, 
                                         {16,17,18,19,20},
                                         {21,22,23,24,25}};
         int[][] test2 = new int[][]{{1,4},{2,5}};
         int[][] test3 = new int[][]{{-5,3}};
         System.out.println(searchMatrix(test3, 2));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length-1;
        int row = 0;
        while (col >= 0 && row <= matrix.length-1) {
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