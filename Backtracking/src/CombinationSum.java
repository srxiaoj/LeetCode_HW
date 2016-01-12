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

    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        add(res, new ArrayList<Integer>(), candidates, 0, target);
        return res;
    }

    private void add(ArrayList<List<Integer>> res, ArrayList<Integer> list, int[] candidates, int start, int target) {
        if (target < 0) return;
        else if (target == 0) {
            res.add(list);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>(list);
            temp.add(candidates[i]);
            add(res, temp, candidates, i, target - candidates[i]);
        }
    }

    //print two dimensional array list, which can also be replaced by simply System.out.println(A)
    private static void printTwoDArrayList(List<List<Integer>> A) {
        for (int i = 0; i < A.size(); i++) {
            System.out.print(A.get(i) + " ");
            System.out.println("");
        }

    }
}
