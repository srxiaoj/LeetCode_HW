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
        Arrays.sort(candidates);
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        add(res, new ArrayList<Integer>(), candidates, 0, target);
        return res;
    }

    /**
     * 每个元素只能使用一次
     * 不能包含重复组合
     * 先对数组进行排序，然后添加当前位置后(start + 1)的数组内各元素至大于target
     * @param res
     * @param list
     * @param candidates
     * @param start
     * @param target
     */
    private void add(ArrayList<List<Integer>> res, ArrayList<Integer> list, int[] candidates, int start, int target) {
        if (target < 0) return;
        else if (target == 0) {
            if (!res.contains(list))
                res.add(list);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>(list);
            temp.add(candidates[i]);
            add(res, temp, candidates, i + 1, target - candidates[i]);
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
