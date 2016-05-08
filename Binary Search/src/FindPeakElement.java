/**
 * Created by thanksgiving on 5/8/16.
 */
public class FindPeakElement {
    public static void main(String[] args) {
        FindPeakElement obj = new FindPeakElement();
        int[] nums = {1, 2, 3, 1};
        System.out.println(obj.findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        if (nums == null) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // in ascending slope
            if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                start = mid;
            } else if (nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                end = mid;
            } else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                start = mid;
            }

        }
        if (nums[start] < nums[end]) {
            return end;
        } else {
            return start;
        }
    }
}
