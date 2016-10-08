import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/7.
 */
public class WindowSum {
    public static List<Integer> getSum(List<Integer> arr, int k) {
        List<Integer> rst = new ArrayList<Integer>();
        if (arr == null || arr.size() == 0 || k == 0) {
            return rst;
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + arr.get(i);
        }
        rst.add(sum);
        for (int i = k; i <= arr.size() - 1; i++) {
            sum = sum + arr.get(i) - arr.get(i - k);
            rst.add(sum);
        }
        return rst;
    }
}
