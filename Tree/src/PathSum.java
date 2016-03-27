/**
 * Created by thanksgiving on 3/26/16.
 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(-2);
        root.left.left.left = new TreeNode(-1);
        TreeNode.printNode(root);
        PathSum obj = new PathSum();
        System.out.println(obj.hasPathSum(root, -3));
    }


    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return helper(root, 0, sum);

    }

    public boolean helper(TreeNode node, int total, int sum) {
        if (node.left == null && node.right == null) {
            total += node.val;
            if (total == sum) {
                return true;
            }
            return false;
        }
        total += node.val;
        boolean left = false, right = false;
        if (node.left != null)
            left = helper(node.left, total, sum);
        if (node.right != null)
            right = helper(node.right, total, sum);
        return left || right;
    }
}
