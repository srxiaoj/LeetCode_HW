
public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        /**
         *                 6
         *              /    \
         *             2      8
         *            / \    /  \
         *           0   4  7    9
         *              / \
         *             3   5 
         */
        TreeNode root = TreeNode.deserializeLevelorder("6,2,8,0,4,7,9,null,null,3,5");
//        System.out.println(nodeTotalSum(root));
        BinaryTreeMaximumPathSum obj = new BinaryTreeMaximumPathSum();
        System.out.println(obj.maxPathSum(root));
    }

    /**
     * 用一个pathMax记录单条path（包含当前node）的最大值
     * 用一个max记录该node所能达到的最大值
     */
    public int maxPathSum(TreeNode root) {
        return helper(root).max;
    }

    private Result helper(TreeNode node) {
        if (node == null) return new Result(0, Integer.MIN_VALUE);
        Result left = helper(node.left);
        Result right = helper(node.right);
        int path = Math.max(Math.max(left.pathMax, right.pathMax) + node.val, 0);
        int max = Math.max(left.pathMax + right.pathMax + node.val, Math.max(left.max, right.max));
        return new Result(path, max);
    }
    private class Result {
        int pathMax;
        int max;
        public Result(int pathMax, int max) {
            this.pathMax = pathMax;
            this.max = max;
        }
    }
}
