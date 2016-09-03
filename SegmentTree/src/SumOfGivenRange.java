public class SumOfGivenRange {
    public static void main(String[] args) {
        int nums[] = {1, 3, 5, 7, 9, 11};
        SumOfGivenRange obj = new SumOfGivenRange(nums);
        System.out.println(obj.sumRange(1, 3));
        obj.update(2, 10);
        System.out.println(obj.sumRange(1, 3));
    }

    class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }

    SegmentTreeNode root = null;

    public SumOfGivenRange(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            SegmentTreeNode segmentTreeNode = new SegmentTreeNode(start, end);
            if (start == end) {
                segmentTreeNode.sum = nums[start];
            } else {
                int mid = start + (end - start) / 2;
                segmentTreeNode.left = buildTree(nums, start, mid);
                segmentTreeNode.right = buildTree(nums, mid + 1, end);
                segmentTreeNode.sum = segmentTreeNode.left.sum + segmentTreeNode.right.sum;
            }
            return segmentTreeNode;
        }
    }

    void update(int i, int val) {
        update(root, i, val);
    }

    void update(SegmentTreeNode root, int i, int val) {
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (i <= mid) {
                update(root.left, i, val);
            } else {
                update(root.right, i, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    public int sumRange(SegmentTreeNode root, int i, int j) {
        if (root.end == j && root.start == i) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (j <= mid) {
                return sumRange(root.left, i, j);
            } else if (i > mid) {
                return sumRange(root.right, i, j);
            } else {
                return sumRange(root.right, mid + 1, j) + sumRange(root.left, i, mid);
            }
        }
    }
}