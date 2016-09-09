
public class RecoverBinarySearchTree {

    public static void main(String[] args) {
        /**
         *                 6
         *              /    \
         *             8      2
         *            / \    /  \
         *           0   4  7    9
         */
        RecoverBinarySearchTree obj = new RecoverBinarySearchTree();
//        TreeNode root = TreeNode.deserializeLevelorder("6,8,2,0,4,7,9");
        TreeNode root = TreeNode.deserializeLevelorder("8,5,25,4,18,7,30,null,null,6,null");
        obj.recoverTree(root);
        TreeNode.printNode(root);
    }

    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode previous = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorderTraversal(root);

        // swap the two values
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    /**
     * 根据 inorder的特性，一定是从小到大进行traversal，错位的两个数，第一个一定是比后一个大，第二个一定是比前一个小
     * 所以选取两个变量 previous 和 root, 第一个数是当previous > next的时候取previous, 第二个数则是取next
     */
    public void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        // Start of "do some business",
        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if (first == null && previous.val > root.val) {
            first = previous; // the first element should be previous
        }
        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if (first != null && previous.val > root.val) {
            second = root; // the second element should be root
        }
        previous = root;
        inorderTraversal(root.right);
    }
}
