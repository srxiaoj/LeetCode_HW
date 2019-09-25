/**
 * Created by thanksgiving on 5/5/16.
 */
public class SortColors {
    public static void main(String[] args) {
//        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 2, 1, 0};
        int[] nums = new int[]{1, 2, 1, 0, 3, 1, 2, 3, 0, 1};
        sort(nums);
//        printArray(nums);
    }

    /**
     * idx0, idx1 存的是下一个0或者1应该放的位置,如果发现一个新的0或者1，对应的idx++
     */
    public static void sort(int[] A) {
        int idx0 = 0, idx1 = 0, idx2 = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                A[i] = 3;
                A[idx2++] = 2;
                A[idx1++] = 1;
                A[idx0++] = 0;
            } else if (A[i] == 1) {
                A[i] = 3;
                A[idx2++] = 2;
                A[idx1++] = 1;
            } else if (A[i] == 2) {
                A[i] = 3;
                A[idx2++] = 2;
            }
            printArray(A);
            System.out.println("idx0: " + idx0 + ", idx1: " + idx1);
        }
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

    private int sortTwoColors2(int[] nums, int val, int m, int n) {
        int l = m, r = n;
        while (l <= r) {
            if (nums[l] == val) {
                l++;
            } else {
                swap(nums, l, r);
                r--;
            }
        }
        return l;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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
