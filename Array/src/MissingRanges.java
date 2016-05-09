import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 5/9/16.
 */
public class MissingRanges {
    public static void main(String[] args) {
        MissingRanges obj = new MissingRanges();
        int[] nums = {0, 1, 3, 50, 75};
        System.out.println(obj.findMissingRanges(nums, 0, 99));
    }

    /**
     * 三种情况分别判断，并且处理好开头和结尾
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            if (lower == upper) {
                res.add(lower + "");
                return res;
            } else {
                res.add(lower + "->" + upper);
                return res;
            }
        }
        if (nums[0] != lower) {
            if (nums[0] == lower + 1) {
                res.add(lower + "");
            } else if (nums[0] > lower) {
                int end = nums[0] - 1;
                res.add("0->" + end);
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                // do nothing
            } else if (nums[i] == nums[i - 1] + 2) {
                res.add(String.valueOf(nums[i] - 1));
            } else {
                int start = nums[i - 1] + 1;
                int end = nums[i] - 1;
                res.add(start + "->" + end);
            }
        }

        if (nums[nums.length - 1] == upper - 1) {
            res.add(upper + "");
        } else if (nums[nums.length - 1] < upper - 1) {
            res.add((nums[nums.length - 1] + 1) + "->" + upper);
        }
        return res;
    }
}
