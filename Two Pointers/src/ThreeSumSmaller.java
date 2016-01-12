import java.util.ArrayList;
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
}
