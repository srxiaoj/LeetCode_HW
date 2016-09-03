import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by thanksgiving on 9/2/16.
 */
public class CountofRangeSum {
    public static void main(String[] args) {
        CountofRangeSum obj = new CountofRangeSum();
//        int[] nums = {-2, 5, -1};
        int[] nums = {0, -3, -3, 1, 1, 2};
        System.out.println(obj.countRangeSum(nums, 3, 5));
    }

    class SegmentTreeNode {
        SegmentTreeNode left;
        SegmentTreeNode right;
        int count;
        long start;
        long end;

        public SegmentTreeNode(long start, long end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return "[" + this.start + "~" + this.end + "]: " + this.count;
        }
    }

    private SegmentTreeNode buildTree(Long[] nums, int start, int end) {
        if (start > end) return null;
        SegmentTreeNode node = new SegmentTreeNode(nums[start], nums[end]);
        if (start == end) return node;
        int mid = (start + end) / 2;
        node.left = buildTree(nums, start, mid);
        node.right = buildTree(nums, mid + 1, end);
        return node;
    }

    private void update(SegmentTreeNode node, Long val) {
        if (node == null) return;
        if (val >= node.start && val <= node.end) {
            node.count++;
            update(node.left, val);
            update(node.right, val);
        }
    }

    private int getCount(SegmentTreeNode node, long lower, long upper) {
        if (node == null) return 0;
        if (lower > node.end || upper < node.start) return 0;
        if (lower <= node.start && upper >= node.end) return node.count;
        return getCount(node.left, lower, upper) + getCount(node.right, lower, upper);
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;
        int ans = 0;
        Set<Long> set = new HashSet<Long>();
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (long) nums[i];
            set.add(sum);
        }

        Long[] array = set.toArray(new Long[0]);

        Arrays.sort(array);
        SegmentTreeNode root = buildTree(array, 0, array.length - 1);

        for (int i = nums.length - 1; i >= 0; i--) {
            update(root, sum);
            sum -= (long) nums[i];
            ans += getCount(root, (long) lower + sum, (long) upper + sum);
        }
        return ans;
    }
}
