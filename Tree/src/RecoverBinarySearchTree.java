
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
        TreeNode root = TreeNode.deserializeLevelorder("6,8,2,0,4,7,9");
        obj.recoverTree(root);
        TreeNode.printNode(root);
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

    /**
     * 根据 inorder的特性，一定是从小到大进行traversal，错位的两个数，第一个一定是比后一个大，第二个一定是比前一个小
     * 所以选取两个变量 previous 和 next, 第一个数是当previous > next的时候取previous, 第二个数则是取next
     */
    public void inorderTraversal(TreeNode next) {
        if (next == null) return;
        inorderTraversal(next.left);
        // Start of "do some business",
        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if (firstElement == null && previous.val > next.val) {
            firstElement = previous; // the first element should be previous
        }
        // If first element is found, assign the second element to the next (refer to 2 in the example above)
        if (firstElement != null && previous.val > next.val) {
            secondElement = next; // the second element should be next
        }
        previous = next;
        inorderTraversal(next.right);
    }
}
