/**
 * Created by thanksgiving on 1/12/16.
 */
public class RangeSumQueryImmutable {
    public static void main(String[] args) {
        int[] a = {-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(a);
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }

    private static class NumArray {
        private int[] sum;
        public NumArray(int[] nums) {
            sum = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }
}
