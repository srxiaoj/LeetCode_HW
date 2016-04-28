import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by thanksgiving on 2/29/16.
 */
public class SubsetsII {
    public static void main(String[] args) {
        SubsetsII obj = new SubsetsII();
        int[] nums = {1, 2, 2, 2};
        System.out.println(obj.subsetsWithDup(nums));
        int[] copy = Arrays.copyOfRange(nums, 1, nums.length);
        for (int i = 0; i < copy.length; i++) {
            System.out.print(copy[i] + " ");
        }
    }



    /**
     * 每次在上一次结果基础上添加nums中一个新元素，要排序，如果有重复元素则从上一个结果(startIndex = size.get(i - 1))后开始添加，而不是从0位开始添加
     * start: []
     * add 1: [1]
     * add 2: [2],[1,2]
     * add 2: [2,2],[1,2,2]
     * add 2: [2,2,2],[1,2,2,2]
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        Arrays.sort(nums);
        int startIndex = 0;
        List<Integer> size = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            size.add(res.size());
            List<List<Integer>> tmp = new ArrayList<>();
            // start the next add index of i as size.get(i - 1)
            if (i > 0 && nums[i] == nums[i - 1]) {
                startIndex = size.get(i - 1);
            } else {
                startIndex = 0;
            }
            for (int j = startIndex; j < res.size(); j++) {
                List<Integer> oneD = new ArrayList<>(res.get(j));
                oneD.add(nums[i]);
                tmp.add(oneD);
            }
            res.addAll(tmp);
        }
        return res;
    }
}
