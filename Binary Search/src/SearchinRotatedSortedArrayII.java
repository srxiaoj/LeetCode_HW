/**
 * Created by thanksgiving on 8/7/16.
 */
public class SearchinRotatedSortedArrayII {
    public static void main(String[] args) {
        SearchinRotatedSortedArrayII obj = new SearchinRotatedSortedArrayII();
        int[] num = {1, 3, 5, 1, 1};
        System.out.println(obj.search(num, 3));

    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > nums[end]) {
                if (nums[mid] > target && nums[start] <= target) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (nums[mid] < nums[end]) {
                if (nums[mid] < target && nums[end] >= target) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                end--;
            }
        }

        if (nums[start] == target || nums[end] == target) {
            return true;
        } else {
            return false;
        }
    }
}
