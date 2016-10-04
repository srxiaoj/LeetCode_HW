/**
 * 给一个数组，让写一个函数判断如果只swap数组里的两个元素一次能否使数组变成有序的（升序）。
 */
public class ascendingArrayOneSwap {
    public static void main(String[] args) {
        System.out.println(canSwap(new int[]{3, 2, 1}));
        System.out.println(canSwap(new int[]{1, 3, 2}));
        System.out.println(canSwap(new int[]{3, 1, 2}));
        System.out.println(canSwap(new int[]{6, 5, 4, 3, 2, 1}));
        System.out.println(canSwap(new int[]{3, 1, 2, 4, 5, 6}));
        System.out.println(canSwap(new int[]{1, 7, 3, 4, 5, 6, 2}));
    }

    public static boolean canSwap(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length <= 2) return nums[0] > nums[nums.length - 1];
        int n = nums.length;
        Integer wrongLarge = null, wrongSmall = null;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1] && wrongLarge == null) {
                wrongLarge = i;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1] && wrongSmall == null) {
                wrongSmall = i;
            }
        }
        if (wrongLarge == null || wrongLarge == null) return false;
        swap(nums, wrongLarge, wrongSmall);
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) return false;
        }

        return true;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
