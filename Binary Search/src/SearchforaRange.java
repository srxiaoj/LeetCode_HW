/**
 * Created by thanksgiving on 4/30/16.
 */
public class SearchforaRange {
    public static void main(String[] args) {
        SearchforaRange obj= new SearchforaRange();
        int[] a = {1, 2, 5, 7, 7, 8};
        System.out.println(obj.searchRange(a, 7)[0]);
        System.out.println(obj.searchRange(a, 7)[1]);
    }

    /**
     * 先找到range左boundary， 然后再找range右boundary
     * nums[mid] == target时: 找左boundary时用end = mid, 右boundary用start = mid
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int start = 0;
        int end = nums.length - 1;
        // left bound
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            res[0] = start;
        } else if (nums[end] == target) {
            res[0] = end;
        } else {
            return new int[]{-1,-1};
        }

        //right bound
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                start = mid;
            }
        }

        if (nums[end] == target) {
            res[1] = end;
        } else {
            res[1] = start;
        }
        return res;
    }
}
