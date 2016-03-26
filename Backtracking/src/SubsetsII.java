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
    }

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
