import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = new int[]{1, 2, 1};
        printArray(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        // record down the position of the numbers
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            res.add(Arrays.asList(i));
        }
//        printArray(res);
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            for (List<Integer> oned : res) {
                for (int j = 0; j < nums.length; j++) {
                    if (!oned.contains(j)) {
                        List<Integer> newList = new ArrayList<>(oned);
                        newList.add(j);
                        tmp.add(newList);
                    }
                }
            }
            if (!tmp.isEmpty()) {
                res = tmp;
            }
        }
//        printArray(res);
//        System.out.println("************");
        List<List<Integer>> permutation = new ArrayList<List<Integer>>();
        for (int i = 0; i < res.size(); i++) {
            List<Integer> subRes = new ArrayList<>();
            for (int j = 0; j < res.get(i).size(); j++) {
                subRes.add(nums[res.get(i).get(j)]);
            }
            /**
             * if want no repeat arrays
             */
             if (!permutation.contains(subRes)) {
                 permutation.add(subRes);
             }
//            permutation.add(subRes);
        }
        return permutation;
    }
    
    public static void printArray(List<List<Integer>> A)
    {
        for(int i = 0; i < A.size(); i++)
        {
            System.out.print(A.get(i) + " ");
        }
        System.out.println("");
    }
}
