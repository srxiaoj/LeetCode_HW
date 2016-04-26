import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by thanksgiving on 4/26/16.
 */
public class FindMinimuminRotatedSortedArray {
    public static void main(String[] args) {
        FindMinimuminRotatedSortedArray obj = new FindMinimuminRotatedSortedArray();
        int[] num = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(obj.findMin(num));
    }

    /**
     * 只需要对num[end] 与num[mid]进行比较，如果num[mid] > num[end] 则最小点肯定在mid右边，否则则在左边
     */
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] < nums[end]) {
            return nums[start];
        } else {
            return nums[end];
        }
    }
}
