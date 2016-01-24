import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

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
        System.out.println(isValidBST(root));

        TreeNode root2 = null;
        System.out.println(isValidBST(root2));
    }
    public static boolean isValidBST(TreeNode root) {
        List<Integer> list = inorderTraversal(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversalHelper(root, list);
        return list;
    }
    private static void inorderTraversalHelper(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorderTraversalHelper(root.left, list);
            list.add(root.val);
            inorderTraversalHelper(root.right, list);
        }
    }
}
