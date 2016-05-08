/**
 * Created by thanksgiving on 5/8/16.
 */
public class RemoveDuplicatesfromSortedArrayII {
    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArrayII obj = new RemoveDuplicatesfromSortedArrayII();
//        int[] nums = {1, 1, 1, 1, 2, 2, 2, 3};
        int[] nums = {1, 1};
        System.out.println(obj.removeDuplicates(nums));
        printArray(nums);
    }

    /**
     * 判断两种情况：
     * 1. nums[r] == lastNumber -> (a. count == 2, b. count < 2)
     * 2. nums[r] != lastNumber
     */
    public int removeDuplicates(int[] nums) {
        int l = 1, r = 1;
        int count = 1;
        int len = 1;
        while (r < nums.length) {
            int last = nums[l - 1];
            if (nums[r] == last) {
                if (count == 2) {
                    r++;
                } else {
                    len++;
                    nums[l] = nums[r];
                    count++;
                    l++;
                    r++;
                }
            } else {
                len++;
                nums[l] = nums[r];
                l++;
                r++;
                count = 1;
            }
        }
        return len;
    }

    //print array
    public static void printArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("");
    }
}
