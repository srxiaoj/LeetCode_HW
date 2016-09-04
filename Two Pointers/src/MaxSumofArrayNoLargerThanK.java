/**
 * Created by thanksgiving on 9/4/16.
 */
public class MaxSumofArrayNoLargerThanK {
    public static void main(String[] args) {
        MaxSumofArrayNoLargerThanK obj = new MaxSumofArrayNoLargerThanK();
        System.out.println(obj.maxSum(new int[] {1, 3, -1, 0, 2}, 4));
        System.out.println(obj.maxSum(new int[] {1, 3, -1, 0, 2}, 5));
        System.out.println(obj.maxSum(new int[] {1, 3, -1, 0, 4}, 7));
        System.out.println(obj.maxSum(new int[] {1, 3, -1, 0, 3}, 7));
        System.out.println(obj.maxSum(new int[]{1, 3, -1, 0, 5}, 7));
    }

    public int maxSum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0, j = 0;
        int sum = 0, max = 0;
        while (j <= nums.length) {
            while (i <= j && sum > k) {
                sum -= nums[i];
                i++;
            }

            if (sum <= k) {
                max = Math.max(max, sum);
            }

            if (j < nums.length) sum += nums[j];
            j++;
        }
        return max;
    }

    /**
     * wrong anwer because segment tree doesn't cover all range sums
     */
    public SegTree build(int[] nums, int start, int end) {
        if (start > end) return null;
        SegTree root = new SegTree(start, end);
        if (start == end) {
            root.sum = nums[start];
            return root;
        } else {
            int mid = start + (end - start) / 2;
            root.left = build(nums, start, mid);
            root.right = build(nums, mid + 1, end);
            root.sum = root.left.sum + root.right.sum;
        }
        return root;
    }

    private int getMax(SegTree node, int k) {
        if (node == null) return 0;
        int max = 0;
        if (node.sum <= k) {
            max = Math.max(max, node.sum);
        }
        return Math.max(Math.max(getMax(node.left, k), getMax(node.right, k)), max);
    }

    class SegTree {
        int start, end;
        SegTree left, right;
        int sum;

        public SegTree(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
        }

        public String toString() {
            return "[" + this.start + "~" + this.end + "]: " + this.sum;
        }
    }
}
