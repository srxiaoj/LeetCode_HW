import java.util.Stack;

/**
 * Created by thanksgiving on 1/29/16.
 */
public class FlattenBinaryTreetoLinkedList {
    public static void main(String[] args) {
        /**
         *                 6
         *              /    \
         *             2      8
         *            / \    /  \
         *           0   4  7    9
         *              / \
         *             3   5
         */
        TreeNode root = TreeNode.deserializeLevelorder("6,2,8,0,4,7,9,null,null,3,5");
        FlattenBinaryTreetoLinkedList obj = new FlattenBinaryTreetoLinkedList();
        obj.flatten(root);
        TreeNode.printTreeInOrder(root);
    }

    /**
     * 借用preorder思路，将stack中下一个node放入上一个node的右侧，并将上一个的left变为null
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode copy = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != root) {
                root.right = node;
                root.left = null;
                root = root.right;
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        root = copy;
    }
}
