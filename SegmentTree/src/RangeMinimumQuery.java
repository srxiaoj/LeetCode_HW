/**
 * Created by thanksgiving on 8/5/16.
 */
public class RangeMinimumQuery {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 4, 9, 3};
        RangeMinimumQuery obj = new RangeMinimumQuery(nums);
        System.out.println(obj.getMin(3, 5));
    }

    class SegTree {
        int start;
        int end;
        SegTree left;
        SegTree right;
        int min;

        public SegTree(int start, int end) {
            this.start = start;
            this.end = end;
            this.min = Integer.MAX_VALUE;
            this.left = null;
            this.right = null;
        }
    }

    SegTree root = null;
    public RangeMinimumQuery(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    private SegTree buildTree(int[] nums, int i, int j) {
        if (i > j) return null;
        SegTree root = new SegTree(i, j);
        if (i == j) {
            root.min = Math.min(nums[i], nums[j]);
            return root;
        }
        int mid = i + (j - i) / 2;
        SegTree left = buildTree(nums, i, mid);
        SegTree right = buildTree(nums, mid + 1, j);
        root.left = left;
        root.right = right;
        root.min = Math.min(left.min, right.min);
        return root;
    }

    private int getMin(int i, int j) {
        return getMin(root, i, j);
    }

    private int getMin(SegTree root, int i, int j) {
        if (root.start == i && root.end == j) {
            return root.min;
        }

        int mid = root.start + (root.end - root.start) / 2;
        if (j <= mid) {
            return getMin(root.left, i, j);
        } else if (i > mid) {
            return getMin(root.right, i, j);
        } else {
            return Math.min(getMin(root.left, i, mid), getMin(root.right, mid + 1, j));
        }
    }
}
