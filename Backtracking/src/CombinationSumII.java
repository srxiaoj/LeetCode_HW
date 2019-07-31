import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by thanksgiving on 12/27/15.
 */
public class CombinationSumII {
    public static void main(String[] args) {
        CombinationSumII obj = new CombinationSumII();
//        int[] test = {25,13,21,13,12,29,28,6,8,20,20,10,17,9,16,5,24,25,19,32,13,7,21,17,27,17,5,25,18,18,24,30,
//                26,10,9,25,5,32,26,30,9,33,27,13,7,8,14,26,28,20,23,29,15,31,11,7,6,12,19,19,25,9,14,9,6,10,29};
//        printTwoDArrayList(obj.combinationSum2(test, 23));

        int[] test2 = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(obj.combinationSum2(test2, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] visit = new boolean[candidates.length];
        helper(res, new ArrayList<>(), 0, candidates, target, visit);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> part, int index, int[] candidates, int target, boolean[] visit) {
        if (target < 0) return;
        if (target == 0) {
            res.add(part);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            // 如果上一个重复数字已经被遍历了说明, visit[i - 1]已经为true了，此时则不再遍历这个重复的数字
            if (i > 0 && candidates[i - 1] == candidates[i] && visit[i - 1]) continue;
            visit[i] = false;
            List<Integer> newPart = new ArrayList<>(part);
            newPart.add(candidates[i]);
            helper(res, newPart, i + 1, candidates, target - candidates[i], visit);
            visit[i] = true;
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
