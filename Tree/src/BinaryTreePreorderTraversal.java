import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserializeLevelorder("15,8,20,5,null,17,null,null,null,16,null");
        preorderRecursive(root);
        System.out.println("");
        System.out.println(preorderTraversalIterate(root));
    }
    /**
     * Iterative.
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversalIterate(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            list.add(curNode.val);
            // need to add right first, so that when pop(), left is the first getting pop out
            if (curNode.right != null) {
                stack.add(curNode.right);
            }
            if (curNode.left != null) {
                stack.add(curNode.left);
            }
        }
        return list;
    }
    /**
     * recursive.
     * @param root
     * @return list of pre order elements
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversalHelper(root, list);
        return list;
    }
    private static void preorderTraversalHelper(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            preorderTraversalHelper(root.left, list);
            preorderTraversalHelper(root.right, list);
        }
    }
    /**
     * recursive, no return.
     * @param root
     */
    public static void preorderRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    }
}
