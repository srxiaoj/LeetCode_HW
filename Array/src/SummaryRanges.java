import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {
        int[] test = {0, 1, 2, 4, 5, 7};
        int[] test2 = {};
        
        System.out.println(summaryRanges(test));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        int n = nums.length;
        int start = 0;
        int i = 0;
        while (i < n) {
            while (i + 1 < n && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            // 如果是最后一个数字，并且比上一个大1
            if (i + 1 == n - 1 && nums[i + 1] == nums[i] + 1) {
                String s = String.valueOf(nums[start]);
                String e = String.valueOf(nums[i + 1]);
                res.add(s + "->" + e);
            } else {
                if (i == start) {
                    res.add(String.valueOf(nums[i]));
                } else {
                    String s = String.valueOf(nums[start]);
                    String e = String.valueOf(nums[i]);
                    res.add(s + "->" + e);
                }
            }
            i++;
            start = i;
        }
        return res;
    }
}
