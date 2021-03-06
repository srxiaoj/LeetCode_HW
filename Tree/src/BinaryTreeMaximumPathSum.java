
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
        // root == null 时 max = Integer.MIN_VALUE 防止全部为负数时 pathSum = 0
        if (node == null) return new Result(0, Integer.MIN_VALUE);
        Result left = helper(node.left);
        Result right = helper(node.right);
        // pathMax 必须 >= 0
        int path = Math.max(Math.max(left.pathMax, right.pathMax) + node.val, 0);
        // totalMax 为左右totalMax与pathMax + node.val三个之间对比
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
