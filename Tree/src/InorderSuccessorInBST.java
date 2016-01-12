import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderSuccessorInBST {

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
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        
        TreeNode p = new TreeNode(2);
        p.left = new TreeNode(0);
        p.right = new TreeNode(4);
        p.right.left = new TreeNode(3);
        p.right.right = new TreeNode(5);
        root.left = p;
        
        TreeNode res = inorderSuccessor(root, p);
        TreeNode.printNode(res);
    }
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        boolean isEqual = false;
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.lastElement();
            if (curNode.left != null) {
                stack.add(curNode.left);
                curNode.left = null;
            } else {
                list.add(curNode);
                if (isEqual) {
                    return curNode;
                } else {
                    if (curNode.equals(p)) {
                        isEqual = true;
                    }
                }
                stack.pop();
                if (curNode.right != null) {
                    stack.add(curNode.right);
                }
            }
        }
        return null;
    }
}
