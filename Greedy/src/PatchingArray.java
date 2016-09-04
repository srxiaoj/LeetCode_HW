import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 5/11/16.
 */
public class PatchingArray {
    public static void main(String[] args) {
        PatchingArray obj = new PatchingArray();
        System.out.println(obj.minPatches(new int[] {1, 2, 4, 13, 43}, 100));
        System.out.println(obj.minPatches(new int[] {1, 5, 10}, 20));
        System.out.println(obj.minPatches(new int[] {1, 3}, 6));
//        System.out.println(obj.minPatches(new int[] {1, 2, 31, 33}, 2147483647));


//        System.out.println(obj.patchArray(new int[] {1, 2, 4, 13, 43}, 100));
//        System.out.println(obj.patchArray(new int[] {1, 5, 10}, 20));
//        System.out.println(obj.patchArray(new int[] {1, 3}, 6));
//        System.out.println(obj.patchArray(new int[] {1, 2, 31, 33}, 2147483647));

    }

    // 衍生题目: CombinationsSumLessThanANumber, SmallestNumberFromSumOfArray
    /**
     * https://leetcode.com/discuss/82822/solution-explanation
     */
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int count = 0, i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                System.out.println("add " + miss);
                miss += miss;
                count++;
            }
            System.out.println("miss: " + miss);
        }
        return count;
    }


    private List<Long> patchArray(int[] nums, int n) {
        List<Long> res = new ArrayList<>();
        long miss = 1;
        int i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                res.add(miss);
                miss += miss;
            }
        }
        return res;
    }

    // slow, memory cost
   /* public int minPatches(int[] nums, int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }
        helper(set, 0 ,nums, 0, n);
        int count = 0;
        while (set.size() != 0) {
            count++;
            List<Integer> resList = new ArrayList<>();
            resList.addAll(set);
            Collections.sort(resList);

            nums = Arrays.copyOfRange(nums, 0, nums.length + 1);
            nums[nums.length - 1] = resList.get(0);
            helper(set, 0 ,nums, 0, n);
        }
        return count;
    }

    private static List<Integer> getCombinations(int[] nums, int upper) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(set, 0 ,nums, 0, upper);
        List<Integer> resList = new ArrayList<>();
        resList.addAll(set);
        Collections.sort(resList);
        return resList;
    }

    private static void helper(Set<Integer> set, int pos, int[] nums, int sum, int upper) {
        if (sum > upper) return;
        for (int i = pos; i < nums.length; i++) {
            sum += nums[i];
            if (sum <= upper && set.contains(sum)) {
                set.remove(sum);
            }
            helper(set, i + 1, nums, sum, upper);
            sum -= nums[i];
        }
    }*/
}
