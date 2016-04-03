/**
 * Created by thanksgiving on 3/31/16.
 */
public class RotateArray {

    public static void main(String[] args) {
        RotateArray obj = new RotateArray();
        int[] a1 = {1, 2, 3, 4, 5, 6, 7};
        obj.rotate(a1, 3);
        obj.print(a1);
    }

  /*  public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return;
        int n = nums.length;
        if (k >= n) {
            k = k % n;
        }

        int[] first = Arrays.copyOfRange(nums, 0, n - k);
        int[] second = Arrays.copyOfRange(nums, n - k, n);
        for (int i = 0; i < n; i++) {
            if (i < k) {
                nums[i] = second[i];
            } else {
                nums[i] = first[i - k];
            }
        }
    }*/


    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return;
        int n = nums.length;
        if (k >= n) {
            k = k % n;
        }

        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);

    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }

    private void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }
}
