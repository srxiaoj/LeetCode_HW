public class BalancedBinaryTree {

    public static void main(String[] args) {
        /**
         *              15
         *              / \
         *             8   20
         *            /    / 
         *           5    17
         *               /
         *              16
         */
        BalancedBinaryTree obj = new BalancedBinaryTree();
        TreeNode root = TreeNode.deserializeLevelorder("15,8,20,5,null,17,null,null,null,16,null");
        System.out.println(obj.isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private static int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
