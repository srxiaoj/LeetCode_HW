/**
 * Created by thanksgiving on 12/24/15.
 */
public class WiggleSort {
    public static void main(String[] args) {
//        int[] test1 = new int[]{3, 5, 2, 1, 6, 4};
        int[] test2 = new int[]{1, 2, 3, 4, 5};
        WiggleSort obj = new WiggleSort();
//        obj.wiggleSort(test1);
        obj.wiggleSort(test2);
//        printArray(test1);
        printArray(test2);
    }

    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1) {
                if (nums[i - 1] > nums[i]) swap(nums, i);
            } else if (i != 0 && nums[i - 1] < nums[i]) {
                swap(nums, i);
            }
        }
        /*
        int i = 0;
        while (i < nums.length) {
            partialSort(nums, i, nums.length);
            i = i + 2;
        }
        */
    }

    /**
     * swap index i and i - 1
     * @param nums
     * @param i
     */
    public void swap(int[] nums, int i) {
        int tmp = nums[i];
        nums[i] = nums[i - 1];
        nums[i - 1] = tmp;
    }

    private void partialSort(int[] nums, int l, int r) {
        if (l == r) return;
        if (r - l == 1) return;
        for (int i = l; i < r; i++) {
            if (nums[i] < nums[l]) {
                swap(nums, i, l);
            }
            if (nums[i] > nums[l + 1]) {
                swap(nums, i, l + 1);
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //print array
    public static void printArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("");
    }
}
