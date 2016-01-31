/**
 * find symmetric tree.
 * @author Administrator
 *
 */
public class SymmetricTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(8);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(5);
        root.right.left = new TreeNode(17);
        root.right.left.left = new TreeNode(16);
        System.out.println(isSymmetric(root));
        
        TreeNode root2 = new TreeNode(15);
        root2.left = new TreeNode(8);
        root2.right = new TreeNode(8);
        root2.left.left = new TreeNode(5);
        root2.right.right = new TreeNode(5);
        System.out.println(isSymmetric(root2));
        
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        System.out.println(isSymmetric(root3));
    }
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }
    private static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true; // both children are null
        if (left == null || right == null) return false; // one of the child is null
        // none of the children are null
        if (left.val != right.val) {
            return false;
        } else {
            return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
        }

//        if (left == null || right == null) {
//            return left == right;
//        } else { // left != null && right != null
//            if (left.val != right.val)
//                return false;
//        }
//        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }
}
