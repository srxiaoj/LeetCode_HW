import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class FourSum {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] test = new int[]{-1,-5,-5,-3,2,5,0,4};
        List<List<Integer>> res = new ArrayList<>();
        res = fourSum(test, -7);
        System.out.println(res);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        //printArray(nums);
        for (int i = 0; i < nums.length; i++) {
            int[] newNums = Arrays.copyOfRange(nums, i+1, nums.length);
            List<List<Integer>> need = threeSum(newNums, target-nums[i]);
            //System.out.println(need);
            if (need.size() != 0) {//result has been found
                for(int j = 0; j < need.size(); j++) {
                    need.get(j).add(0, nums[i]);
                    res.add(need.get(j));
                }
            }
            //Processing duplicates for nums[i], don't need to worry about the 3 sum part
            //because it has been taken care in threeSum method
            while (i < nums.length - 1 && nums[i] == nums[i+1]) i++;
        }
        return res;
    }
    private static List<List<Integer>> threeSum(int[] num, int k) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(num);//sort the array
        
        //if(num.length <3)
        //  return res;
        for(int i = 0; i < num.length-2; i++){//note the num.length-2 boundary
            int target = k-num[i];//get the target value so that target+num[i] = 0
            int l = i+1;
            int r = num.length-1;
            while(l < r){
                if(num[l] + num[r] < target) l++;
                else if(num[l] + num[r] > target) r--;
                else{
                    List<Integer> oned = new ArrayList<Integer>();
                    oned.add(num[i]);
                    oned.add(num[l]);
                    oned.add(num[r]);
                    res.add(oned);
                    // Processing duplicates of Number 2
                    // Rolling the front pointer to the next different number forwards
                    while(l < r && num[l] == oned.get(1)) l++;
                    while(l < r && num[r] == oned.get(2)) r--;
                }
            }
            // Processing duplicates of Number 1
            while(i < num.length-2 && num[i+1] == num[i]) i++;
        }
        return res;
    }
    //print array
    public static void printArray(int[] A)
    {
        for(int i = 0; i < A.length; i++)
        {
            if(i != A.length-1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("");
    }
}
