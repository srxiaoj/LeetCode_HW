import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by thanksgiving on 2/29/16.
 */
public class Subsets {
    public static void main(String[] args) {
        Subsets obj = new Subsets();
        int[] nums = {1, 2, 3};
        System.out.println(obj.subsets2(nums));
    }

    /**
     * recursive
     */
    public List<List<Integer>> subsets2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        int first = nums[nums.length - 1];
        int[] rest = Arrays.copyOfRange(nums, 0, nums.length - 1);
        List<List<Integer>> sub = subsets2(rest);
        res.addAll(sub);
        for (List<Integer> set : sub) {
            List<Integer> newSet = new ArrayList<>(set);
            newSet.add(first);
            res.add(newSet);
        }
        return res;
    }


    /**
     * 每次在上一次结果基础上添加nums中一个新元素，依次添加顺序为
     * start: []
     * add 1: [1]
     * add 2: [2],[1,2]
     * add 3: [3],[1,3],[2,3],[1,2,3]
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());

        Arrays.sort(nums);
        for(int i : nums) {
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> sub : res) {
                List<Integer> a = new ArrayList<>(sub);
                a.add(i);
                tmp.add(a);
            }
            res.addAll(tmp);
        }
        return res;
    }
}
