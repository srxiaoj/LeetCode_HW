/**
 * Created by thanksgiving on 8/7/16.
 */
public class FindMinimuminRotatedSortedArrayII {
    public static void main(String[] args) {
        System.out.println(findMin(new int[] {2, 3, 3, 1, 2}));
        System.out.println(findMin(new int[] {2, 2, 1}));
    }

    /**
     * When num[mid] == num[end], we couldn't sure the position of minimum in mid's left or right
     * so just let upper bound reduce one.
     */
    public static int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[end] < nums[mid]) {
                start = mid;
            } else if (nums[end] > nums[mid]) {
                end = mid;
            } else {
                end--;
            }
        }
        if (nums[start] < nums[end]) {
            return nums[start];
        } else {
            return nums[end];
        }
    }
}
