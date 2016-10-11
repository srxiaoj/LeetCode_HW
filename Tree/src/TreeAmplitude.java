/**
 * Created by Administrator on 2016/10/10.
 */
public class TreeAmplitude {
    public static void main(String[] args) {
        TreeNode root = TreeNode.deserializeLevelorder("8, 5, 20, 1, 7, 12, null");
        TreeNode.printNode(root);
        System.out.println(getAmplitude(root));
    }

    public static int getAmplitude(TreeNode root) {
        if (root == null)   return 0;
        return helper(root, root.val, root.val);
    }

    private static int helper(TreeNode root, int min, int max) {
        if (root == null)   return max - min;

        if (root.val < min) min = root.val;
        if (root.val > max) max = root.val;

        return Math.max(helper(root.left, min, max), helper(root.right, min, max));
    }
}
