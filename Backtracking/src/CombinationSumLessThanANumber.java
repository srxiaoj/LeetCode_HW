import java.util.*;

/**
 * Created by thanksgiving on 9/3/16.
 */
public class CombinationSumLessThanANumber {
    public static void main(String[] args) {
        System.out.println(getCombinations(new int[] {1, 2, 5, 10}, 20));
        System.out.println(getCombinations(new int[] {1, 2, 4, 5, 10}, 20));
//        System.out.println(getCombinations(new int[] {1, 2, 2}, 5));
    }

    private static List<Integer> getCombinations(int[] nums, int upper) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(set, res, new ArrayList<>(), 0 ,nums, 0, upper);
        List<Integer> resList = new ArrayList<>();
        resList.addAll(set);
        Collections.sort(resList);
        return resList;
    }

    private static void helper(Set<Integer> resList, List<List<Integer>> res, List<Integer> part, int pos, int[] nums, int sum, int upper) {
        if (sum > upper) return;
        for (int i = pos; i < nums.length; i++) {
            List<Integer> newPart = new ArrayList<>(part);
            newPart.add(nums[i]);
            sum += nums[i];
            if (sum <= upper) {
                res.add(part);
                resList.add(sum);
            }
            helper(resList, res, newPart, i + 1, nums, sum, upper);
            sum -= nums[i];
        }
    }
}
