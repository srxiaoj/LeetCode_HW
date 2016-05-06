/**
 * Created by thanksgiving on 5/5/16.
 */
public class SortColors {
    public static void main(String[] args) {
        SortColors obj = new SortColors();
        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 2, 1, 0};
        obj.sortColors(nums);
        obj.print(nums);
    }

    /**
     * 先以0分割排序，再以1分割排序
     * @param nums
     */
    public void sortColors(int[] nums) {
        int first = sortTwoColor(nums, 0, 0, nums.length - 1);
        int second = sortTwoColor(nums, 1, first, nums.length - 1);
    }

    public int sortTwoColor(int[] nums, int color, int l, int r) {
        while (l < r) {
            while (l < r && nums[l] == color) {
                l++;
            }
            while (l < r && nums[r] != color) {
                r--;
            }
            swap(nums, l, r);
        }
        return l;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void print(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
