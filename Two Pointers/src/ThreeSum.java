import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[] {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
        int[] B = new int[] {1,1,2};
        int[] D = new int[] {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> C = new ArrayList<Integer>();
        C.add(-1);
        C.add(0);
        C.add(1);
        res = threeSum(D);
        System.out.println(res);
        //System.out.println("res contains B: " + containsArray(res,C));
    }
    public static List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(num);//sort the array
        
        //if(num.length <3)
        //  return res;
        for(int i = 0; i < num.length-2; i++){//note the num.length-2 boundary
            int target = -num[i];//get the target value so that target+num[i] = 0
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
    //return true if parent contains child
    /*
    private static boolean containsArray(List<List<Integer>> parent, List<Integer> child){
        boolean res = false;
        for(List<Integer> tmp : parent){
            for(int i = 0; i < tmp.size(); i++){
                if(tmp.get(i) == child.get(i) && tmp.size() == child.size()){
                    res = true;
                }
                else{
                    res = false;
                    break;
                }
            }
            if(res)
                return true;
        }
        return res;
    }
    */
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
