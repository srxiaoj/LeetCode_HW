import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 1/6/16.
 */
public class CombinationSumIII {
    public static void main(String[] args) {
        CombinationSumIII obj = new CombinationSumIII();
        System.out.println(obj.combinationSum3(3, 9));
    }

    /**
     * 外循环为 start - 9, 再在内部加一个判断size 是否大于k
     * 其他细节与1， 2相同
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        helper(res, part, n, k, 1);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> part, int target, int k, int start) {
        if (part.size() > k) return;
        if (part.size() == k && target == 0) {
            res.add(new ArrayList<>(part));
            return;
        }

        for (int i = start; i <= 9; i++) {
            List<Integer> newPart = new ArrayList<>(part);
            newPart.add(i);
            helper(res, newPart, target - i, k, i + 1);
        }
    }


    public List<List<Integer>> combinationSum(int k, int n) {
        List<List<Integer>> res = new ArrayList();
        if (n < 1)
            return res;
        List<Integer> part = new ArrayList();
        dfs(k, n, 1, part, res, 0);
        return res;
    }

    public void dfs(int k, int n, int i, List<Integer> part, List<List<Integer>> list, int sum) {
        if (sum == n && part.size() == k) {
            list.add(new ArrayList(part));
            return;
        }
        if (i > 9 || sum > n)
            return;
        dfs(k, n, i + 1, part, list, sum);
        part.add(i);
        sum += i;
        dfs(k, n, i + 1, part, list, sum);
        part.remove(part.size() - 1);
        sum -= i;
    }
}
