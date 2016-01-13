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
        private int[] array;
        public NumArray(int[] nums) {
            sum = new int[nums.length + 1];
            array = new int[nums.length];
            sum[0] = 0;
            for (int i = 1; i < nums.length + 1; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
//                System.out.print(sum[i] + " ");
            }
            System.out.println(" ");
            for (int i = 0; i < nums.length; i++) {
                array[i] = nums[i];
//                System.out.print(array[i] + " ");
            }
            System.out.println(" ");
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i + 1] + array[i];
        }
    }
}
