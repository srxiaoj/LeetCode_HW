import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Permutations obj = new Permutations();
        int[] nums = new int[]{1, 2, 3};
//        int[] nums = new int[]{1, 2, 1};
        printArray(obj.permute2(nums));
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) return list;

        collectPermutations(nums, 0, new ArrayList<>(), list);
        return list;
    }

    private void collectPermutations(int[] nums, int start, List<Integer> part, List<List<Integer>> list) {
        if (part.size() == nums.length) {
            list.add(part);
            return;
        }
        for (int i = 0; i <= part.size(); i++) {
            List<Integer> newPermutation = new ArrayList<>(part);
            newPermutation.add(i, nums[start]);
            collectPermutations(nums, start + 1, newPermutation, list);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
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
//        printArray(res);
//        System.out.println("************");
        List<List<Integer>> permutation = new ArrayList<List<Integer>>();
        for (int i = 0; i < res.size(); i++) {
            List<Integer> subRes = new ArrayList<>();
            for (int j = 0; j < res.get(i).size(); j++) {
                subRes.add(nums[res.get(i).get(j)]);
            }
            /**
             * if want no repeat arrays
             */
            if (!permutation.contains(subRes)) {
                permutation.add(subRes);
            }
//            permutation.add(subRes);
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
