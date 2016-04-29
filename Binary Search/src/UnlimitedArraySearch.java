/**
 * Created by thanksgiving on 4/29/16.
 */
public class UnlimitedArraySearch {
    public static void main(String[] args) {
        UnlimitedArraySearch obj = new UnlimitedArraySearch();
        int[] nums = {1, 2, 3, 4, 5, 6, 9, 15, 16, 20, 22};
        System.out.println(obj.search(nums, 1));
        System.out.println(obj.search(nums, 2));
        System.out.println(obj.search(nums, 15));
        System.out.println(obj.search(nums, 20));
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int next = nums[(int) Math.pow(2, start) - 1];
        while (Math.pow(2, start) < nums.length && next <= target) {
            start++;
            if (Math.pow(2, start) >= nums.length) break;
            next = nums[(int) Math.pow(2, start) - 1];
        }
        int l = (int) Math.pow(2, start - 1) - 1;
        int r = (int) Math.pow(2, start) - 1;
        r = Math.min(r, nums.length - 1);
        System.out.println("start " + l);
        System.out.println("end " + r);
        int res = binarySearch(nums, l, r, target);
        System.out.println("res " + res);
        return nums[res];
    }

    public int binarySearch(int[] nums, int l, int r, int target) {
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid + 1;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid;
            }
        }

        if (nums[l] == target) {
            return l + 1;
        } else if (nums[r] == target) {
            return r + 1;
        } else {
            return l + 1;
        }
    }
}
