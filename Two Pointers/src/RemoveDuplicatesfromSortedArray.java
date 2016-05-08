/**
 * Created by thanksgiving on 5/8/16.
 */
public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray obj = new RemoveDuplicatesfromSortedArray();
        int[] nums = {1,1,3,4};
        System.out.println(obj.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int l = 1, r = 1;
        while (r < nums.length) {
            int last = nums[l - 1];
            if (nums[r] == last) {
                r++;
            } else {
                nums[l] = nums[r];
                r++;
                l++;
            }
        }
        return l;
    }
}
