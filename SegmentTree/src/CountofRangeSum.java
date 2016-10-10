import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://discuss.leetcode.com/topic/43615/segment-tree-solution-c-with-brief-explain
 */
public class CountofRangeSum {
    public static void main(String[] args) {
        CountofRangeSum obj = new CountofRangeSum();
        System.out.println(obj.countRangeSum(new int[]{-2, 5, -1}, -2, 2));
//        System.out.println(obj.countRangeSum(new int[]{0, -3, -3, 1, 1, 2}, 3, 5));
//        System.out.println(obj.countRangeSum(new int[]{0, 0}, 0, 0));
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
            /**
             * Core part 1 : "updateTree" function will update nodes cnt value by plusing 1 if this node cotains range [sum(0, i)].
             * How?
             * Each leafe of the segment tree contains range [sum[0, i], sum[0,i]] where i starts from 1 to nums.length
             * so, we will definitely find the leafe if we search from the root of the tree;
             * And during the process of finding this leafe, update every node's count value by 1
             * because it must contains the leafe's range by definition.
             */
            update(root, sum);
            /**
             * Core part 2 : why subtract nums[i] here ?
             * because of its usage in the next part;
             */
            sum -= (long) nums[i];
            /**
             * Core part 3 :
             * why sum + lower and sum + upper
             * In core part 2, sum is now the sum of range (0, i - 1), and it serves as a base now.
             * What base?
             * getCount method is trying to return how many valid subranges under [sum + lower, sum + upper]
             * we plus "sum" to range[lower, upper] is because we want it to search the ranges formed by all
             * ranges which starts from i - 1;
             * why ?
             * To understand this, let's imagine sum is 0, and it will be getCount(root, 0 + lower, 0 + upper)
             * this will return number of valid ranges formed by sum(0, j)
             * Oh yeah. Hope you accept this.
             * but we still need the number of valid of ranges formed by sum(i, j) where i is not 0
             * that is what "base" is doing now
             * sum serves as a base here which makes ranges must start from sum(0, i - 1)
             */
            ans += getCount(root, (long) lower + sum, (long) upper + sum);
        }
        return ans;
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

    /**
     * 把所有node.start < val < node.end的node的count加一
     */
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
}
