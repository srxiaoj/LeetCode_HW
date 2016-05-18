/**
 * Created by thanksgiving on 5/8/16.
 */
public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray obj = new RemoveDuplicatesfromSortedArray();
        int[] nums = {1,1,3,4};
        System.out.println(obj.removeDuplicates(nums));
    }

    /**
     * 注意要用num[j]与num[i - 1]比较, 只要nums[j] <= nums[i - 1]都要j++
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int i = 1;
        while (i < n) {
            if (nums[i] <= nums[i - 1]) {
                int j = i + 1;
                while (j < n && nums[j] <= nums[i - 1]) {
                    j++;
                }
                if (j == n) return i;
                swap(nums, i, j);
            }
            i++;
        }
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

   /* public int removeDuplicates(int[] nums) {
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
    }*/
}
