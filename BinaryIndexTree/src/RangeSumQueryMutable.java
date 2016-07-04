/**
 * Created by thanksgiving on 7/4/16.
 */
public class RangeSumQueryMutable {
    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[]{1, 3, 5});
        System.out.println(obj.sumRange(0, 2));
        obj.update(1, 2);
        System.out.println(obj.sumRange(0, 2));
        obj.update(2, 10);
        System.out.println(obj.sumRange(0, 2));

        NumArray obj2 = new NumArray(new int[]{-1});
        System.out.println(obj2.sumRange(0, 0));
        obj2.update(0, 1);
        System.out.println(obj2.sumRange(0, 0));

        NumArray obj3 = new NumArray(new int[]{7, 2, 7, 2, 0});
        obj3.update(4, 6);
        obj3.update(0, 2);
        obj3.update(0, 9);
        System.out.println(obj3.sumRange(4, 4));
        obj3.update(3, 8);
        System.out.println(obj3.sumRange(0, 4));
        obj3.update(4, 1);
        System.out.println(obj3.sumRange(0, 3));
        System.out.println(obj3.sumRange(0, 4));
        obj3.update(0, 4);
    }

    static class NumArray {

        private int[] tree;
        private int[] original;

        public NumArray(int[] nums) {
            tree = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                build(tree, i, nums[i - 1]);
            }
            original = nums;
        }

        void update(int i, int val) {
            int diff = val - original[i];
            original[i] = val;
            build(tree, i + 1, diff);
        }

        public int sumRange(int i, int j) {
            int val1 = getSum(tree, i);
            int val2 = getSum(tree, j + 1);
            return val2 - val1;
        }

        private void build(int[] tree, int i, int val) {
            while (i < tree.length) {
                tree[i] += val;
                i = i + (i & (-i));
            }
        }

        private int getSum(int[] tree, int i) {
            int num = 0;
            while (i > 0) {
                num += tree[i];
                i = i - (i & (-i));
            }
            return num;
        }
    }
}
