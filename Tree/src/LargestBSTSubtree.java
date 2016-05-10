/**
 * Created by thanksgiving on 5/9/16.
 */
public class LargestBSTSubtree {
    public static void main(String[] args) {
        LargestBSTSubtree obj = new LargestBSTSubtree();
        TreeNode root = TreeNode.deserializeLevelorder("10,5,15,1,8,null,7");
        System.out.println(obj.largestBSTSubtree(root));
    }

    public int largestBSTSubtree(TreeNode root) {
        return helper(root).count;
    }

    public ResultType helper(TreeNode node) {
        if (node == null) return new ResultType();
        if (node.left == null && node.right == null) return new ResultType(node.val, node.val, 1, true);

        ResultType left = helper(node.left);
        ResultType right = helper(node.right);
/*        if (!left.isValid || !right.isValid) {
            return new ResultType(-1, -1, 0, false);
        }*/

        int max = Math.max(node.val, right.max);
        int min = Math.min(node.val, left.min);
        if (left.isValid && right.isValid && node.val > left.max && node.val < right.min) {
            return new ResultType(max, min, left.count + right.count + 1, true);
        }

        int count = Math.max(left.count, right.count);
        return new ResultType(max, min, count,  false);
    }

    private class ResultType {
        int min;
        int max;
        int count;
        boolean isValid;
        public ResultType() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            count = 0;
            isValid = true;
        }

        public ResultType(int max, int min, int count, boolean isValid) {
            this.min = min;
            this.max = max;
            this.count = count;
            this.isValid = isValid;
        }
    }
}
