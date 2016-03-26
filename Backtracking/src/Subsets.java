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
        System.out.println(obj.subsets(nums));
    }

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
