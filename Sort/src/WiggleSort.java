
public class WiggleSort {
    public static void main(String[] args) {
        int[] test1 = new int[]{1, 5, 1, 1, 6, 4};
        int[] test2 = new int[]{4, 5, 5, 6};
        int[] test3 = new int[]{1, 3, 2, 2, 3, 1};
        WiggleSort obj = new WiggleSort();
        obj.wiggleSort(test1);
        obj.wiggleSort(test2);
        obj.wiggleSort(test3);
        printArray(test1);
        printArray(test2);
        printArray(test3);
    }

    /**
     * O(n)， 两两交换，需要交换的情况： 奇数时nums[i] < nums[i - 1], 偶数时nums[i] > nums[i - 1]
     */
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }

    public void swap(int[] n, int i, int j) {
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
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
