import java.util.Arrays;
import java.util.List;

public class ThreeSumSmaller {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = new int[] {2, 0, 0, 2, -2};
        System.out.println(threeSumSmaller(test, 2));
    }
    
    public static int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        int len = nums.length;

        for(int i=0; i<len-2; i++) {
            int left = i+1, right = len-1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] < target) {
                    count += right-left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
    //print two dimensional array list, which can also be replaced by simply System.out.println(A)
    public static void printTwoDArrayList(List<List<Integer>> A)
    {
        for(int i = 0; i < A.size(); i++)
        {
            
            System.out.print(A.get(i) + " ");
            System.out.println("");
        }
        
    }

    public static class SearchIn2DMatrix {

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
            System.out.println(searchMatrix(test3, 2));
        }

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
}
