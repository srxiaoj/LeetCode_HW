/**
 * Created by thanksgiving on 4/26/16.
 */
public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
        SearchinRotatedSortedArray obj = new SearchinRotatedSortedArray();
        int[] num = {1, 3, 5};
        System.out.println(obj.search(num, 1));

    }

    /**
     * 以 nums[end] 是否小于 nums[mid] 为分隔，再判断target应该在哪个连续区间
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[end]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        } else {
            return -1;
        }
       /* if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[start] < nums[mid]) {
                if (target <= nums[mid] && target >= nums[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;*/
    }
}
