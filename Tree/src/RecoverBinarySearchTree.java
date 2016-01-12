
public class RecoverBinarySearchTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /**
         *                 6
         *              /    \
         *             8      2
         *            / \    /  \
         *           0   4  7    9
         */
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        
        RecoverBinarySearchTree obj = new RecoverBinarySearchTree();
        obj.recoverTree(root);
    }
    private TreeNode firstElement = null;
    private TreeNode secondElement = null;
    private TreeNode previous = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        
        // swap the two values
        int tmp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = tmp;
    }
    public void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        if (firstElement == null && previous.val >= root.val) {
            firstElement = previous; // the first element should be previous
        }
        if (firstElement != null && previous.val >= root.val) {
            secondElement = root; // the second element should be root
        }
        previous = root;
        inorderTraversal(root.right);
    }
}
