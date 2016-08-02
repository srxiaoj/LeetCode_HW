/**
 * Created by thanksgiving on 6/10/16.
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive obj = new FirstMissingPositive();
//        System.out.println(obj.firstMissingPositive(new int[]{1, 2, 3, 4, 4, 9}));
        System.out.println(obj.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(obj.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(obj.firstMissingPositive(new int[]{1}));
        System.out.println(obj.firstMissingPositive(new int[]{0}));
    }

    /**
     * nums[nums[i] - 1] != nums[i]这个条件很重要，防止无限循环swap
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void printArray(int[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }
}
