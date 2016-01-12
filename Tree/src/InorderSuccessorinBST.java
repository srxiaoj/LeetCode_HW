import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 */
public class InorderSuccessorinBST {
    public static void main(String args[]) {
/**
 *               15
 *              / \
 *             8   20
 *            / \  /
 *           5  9 17
 *               / \
 *              16  18
 */
//        TreeNode root2 = new TreeNode(2);
//        TreeNode root = new TreeNode(15);
//        root.left = new TreeNode(8);
//        root.right = new TreeNode(20);
//        root.left.left = new TreeNode(5);
//        root.left.right = new TreeNode(9);
//        root.right.left = new TreeNode(17);
//        root.right.left.left = new TreeNode(16);
//        root.right.left.right = new TreeNode(18);
//        root2.right = root;
//        TreeNode next = inorderSuccessor(root2, root);
//        TreeNode.printNode(next);
        TreeNode target = new TreeNode(2);
        target.left = new TreeNode(0);
        target.right = new TreeNode(4);
        target.right.left = new TreeNode(3);
        target.right.right = new TreeNode(5);

        TreeNode test = new TreeNode(6);
        test.left = target;
        test.right = new TreeNode(8);
        test.right.left = new TreeNode(7);
        test.right.right = new TreeNode(9);
        TreeNode res = inorderSuccessor(test, target);
        TreeNode.printNode(res);

    }
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> list = new ArrayList<>();
        boolean isEqual = false;
        if (root == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.lastElement();
            if (curNode.left != null) {
                stack.add(curNode.left); // add left value, so the final element in this stack would be the left most element
                // since the curNode.left has been stored to stack, this has to set to null
                // otherwise will create infinite loop
                curNode.left = null;
            } else {
                list.add(curNode);
                if (isEqual) {
                    return list.get(list.size() - 1);
                }
                if (curNode.equals(p)) {
                    isEqual = true;
                }
                stack.pop();
                if (curNode.right != null) {
                    if (isEqual) {
                    }
                    stack.add(curNode.right); // add right value
                }
            }
        }
        return null;
    }
}
