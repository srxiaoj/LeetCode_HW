/**
 * Created by thanksgiving on 5/11/16.
 */
public class PatchingArray {
    public static void main(String[] args) {
        PatchingArray obj = new PatchingArray();
        int[] nums = {1, 2, 4, 13, 43};
        System.out.println(obj.minPatches(nums, 100));

    }

    /**
     * https://leetcode.com/discuss/82822/solution-explanation
     */
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int added = 0, i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                miss += miss;
                added++;
            }
        }
        return added;
    }
}
