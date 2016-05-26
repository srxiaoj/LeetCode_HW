/**
 * Created by thanksgiving on 5/26/16.
 */
public class MinimumDepthofBinaryTree {
    public static void main(String[] args) {
        TreeNode node = TreeNode.deserializeLevelorder("1,2,null");
        MinimumDepthofBinaryTree obj = new MinimumDepthofBinaryTree();
        System.out.println(obj.minDepth(node));
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[1];
        res[0] = Integer.MAX_VALUE;
        dfs(root, res, 1);
        return res[0];
    }

    private void dfs(TreeNode node, int[] res, int level) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            res[0] = Math.min(res[0], level);
            return;
        }
        level++;
        if (node.left != null)
            dfs(node.left, res, level);
        if (node.right != null)
            dfs(node.right, res, level);
    }
}
