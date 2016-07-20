import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by thanksgiving on 12/26/15.
 */
public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        int[] test = new int[]{3, 6, 2, 7};
        printTwoDArrayList(obj.combinationSum(test, 8));
        int[] test2 = new int[]{3, 6, 1, 2, 7};
        printTwoDArrayList(obj.combinationSum(test2, 8));

    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(), candidates, 0, target);
        return res;
    }

    /**
     * 每个元素可以重复使用
     * 不能包含重复组合
     * 先对数组进行排序，然后不断的重复添加数组内各元素至大于target
     */
    private void helper(ArrayList<List<Integer>> res, ArrayList<Integer> part, int[] candidates, int start, int target) {
        if (target < 0) return;
        else if (target == 0) {
            res.add(part);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) break;
            ArrayList<Integer> newPart = new ArrayList<Integer>(part);
            newPart.add(candidates[i]);
            helper(res, newPart, candidates, i, target - candidates[i]);
        }
    }

    //print two dimensional array list, which can also be replaced by simply System.out.println(A)
    private static void printTwoDArrayList(List<List<Integer>> A) {
        for (int i = 0; i < A.size(); i++) {
            System.out.print(A.get(i) + " ");
        }
        System.out.println("");

    }
}
