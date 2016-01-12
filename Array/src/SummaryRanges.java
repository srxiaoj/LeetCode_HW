import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {0, 1, 2, 4, 5, 7};
        int[] test2 = {};
        
        System.out.println(summaryRanges(test));
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        StringBuilder sbRes = new StringBuilder();
        int start = 0;
        int end = 1;
        while (start < nums.length) {
            while (end < nums.length
                    && nums[end] - nums[start] == end - start) {
                end++;
            }
            int preEnd = end - 1;
            if (preEnd > start) {
                sbRes = new StringBuilder(nums[start] + "->" + nums[preEnd]);
            } else {
                sbRes = new StringBuilder(nums[start] + "");
            }
            res.add(sbRes.toString());
            start = end;
            end = end + 1;
        }
        return res;
    }
}
