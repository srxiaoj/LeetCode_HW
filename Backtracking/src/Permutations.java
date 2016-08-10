import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        Permutations obj = new Permutations();
        int[] nums = new int[]{1, 2, 3};
        printArray(obj.permute2(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }
    /**
     * method 1
     * start: []
     * add 1: [1]
     * add 2: [2,1]                     [1,2]
     * add 3: [3,2,1],[2,3,1],[2,1,3]   [3,1,2],[1,3,2],[1,2,3]
     */
    private void helper(int[] nums, int start, List<Integer> part, List<List<Integer>> res) {
        if (part.size() == nums.length) {
            res.add(part);
            return;
        }
        for (int i = 0; i <= part.size(); i++) {
            List<Integer> newPermutation = new ArrayList<>(part);
            newPermutation.add(i, nums[start]);
            helper(nums, start + 1, newPermutation, res);
        }
    }

    /**
     * 方法2
     * 使用一个visit[] 记录已经访问过的node
     */
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        boolean[] visit = new boolean[n];

        dfs(res, new ArrayList<>(), nums, visit);
        return res;
    }

    private static void dfs(List<List<Integer>> res, List<Integer> part, int[] nums, boolean[] visit) {
        if (part.size() == nums.length) {
            res.add(part);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            List<Integer> newPart = new ArrayList<>(part);
            newPart.add(nums[i]);
            dfs(res, newPart, nums, visit);
            visit[i] = false;
        }
    }

    /**
     * method 3
     */
    public List<List<Integer>> permute3(int[] nums) {
        // record down the position of the numbers
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            res.add(Arrays.asList(i));
        }
//        printArray(res);
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            for (List<Integer> oned : res) {
                for (int j = 0; j < nums.length; j++) {
                    if (!oned.contains(j)) {
                        List<Integer> newList = new ArrayList<>(oned);
                        newList.add(j);
                        tmp.add(newList);
                    }
                }
            }
            if (!tmp.isEmpty()) {
                res = tmp;
            }
        }
        List<List<Integer>> permutation = new ArrayList<List<Integer>>();
        for (int i = 0; i < res.size(); i++) {
            List<Integer> subRes = new ArrayList<>();
            for (int j = 0; j < res.get(i).size(); j++) {
                subRes.add(nums[res.get(i).get(j)]);
            }
            if (!permutation.contains(subRes)) {
                permutation.add(subRes);
            }
        }
        return permutation;
    }



    public static void printArray(List<List<Integer>> A) {
        for (int i = 0; i < A.size(); i++) {
            System.out.print(A.get(i) + " ");
        }
        System.out.println("");
    }
}
