
public class BalancedBinaryTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /**
         *              15
         *              / \
         *             8   20
         *            /    / 
         *           5    17
         *               /
         *              16
         */
        
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(8);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(5);
        root.right.left = new TreeNode(17);
        root.right.left.left = new TreeNode(16);
        System.out.println(isBalanced(root));
    }
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
//        if (root.left == null && root.right == null) return true; // don't need this line
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private static int getHeight(TreeNode root) {
        if (root == null) return 0;
//        if (root.left == null && root.right == null) return 1;// don't need this line
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
