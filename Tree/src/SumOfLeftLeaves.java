/**
 * Created by thanksgiving on 10/4/16.
 */
public class SumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode root = TreeNode.deserializeLevelorder("1, 2, 3, 4, 5");
        SumOfLeftLeaves obj = new SumOfLeftLeaves();
        System.out.println(obj.sumOfLeftLeaves(root));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        int[] res = new int[1];
        helper(root, false, res);
        return res[0];
    }

    private void helper(TreeNode root, boolean isLeft, int[] res) {
        if (root == null) return;
        if (isLeft && root.left == null && root.right == null) {
            res[0] += root.val;
        }
        helper(root.left, true, res);
        helper(root.right, false, res);
    }
}
