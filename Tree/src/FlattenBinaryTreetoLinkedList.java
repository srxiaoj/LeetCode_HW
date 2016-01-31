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
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        FlattenBinaryTreetoLinkedList obj = new FlattenBinaryTreetoLinkedList();
        obj.flatten(root);
        TreeNode.printTreeInOrder(root);
    }
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode copy = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode parent = node;
            if (node != root) {
                root.right = node;
                root = root.right;
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
            parent.left = null;
        }
        root = copy;
    }
}
