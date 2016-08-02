/**
 * Created by thanksgiving on 3/26/16.
 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode root = TreeNode.deserializeLevelorder("1, 2, null");
        PathSum obj = new PathSum();
        System.out.println(obj.hasPathSum(root, 2));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return helper(root, sum);
    }

    private boolean helper(TreeNode node, int sum) {
        if (node == null) return false;
        if (node.left == null && node.right == null && sum == node.val) {
            return true;
        }
        boolean left = helper(node.left, sum - node.val);
        boolean right = helper(node.right, sum - node.val);
        return left || right;
    }


    /*public boolean hasPathSum(TreeNode root, int sum) {
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
    }*/
}
