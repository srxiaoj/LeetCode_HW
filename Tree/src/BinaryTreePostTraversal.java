import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostTraversal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(8);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(5);
        root.right.left = new TreeNode(17);
        root.right.left.left = new TreeNode(16);
        postorderRecursive(root);
        System.out.println("");
//        System.out.println(postorderTraversal(root));
        System.out.println(postorderTraversalIterate(root));
    }
    /**
     * Iterative.
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversalIterate(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.lastElement();
            if (curNode.left != null) {
                stack.add(curNode.left);
                curNode.left = null;
            } else if (curNode.right != null) {
                stack.add(curNode.right);
                curNode.right = null;
            } else {
                list.add(curNode.val);
                stack.pop();
            }
        }
        return list;
    }
    /**
     * recursive
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversalHelper(root, list);
        return list;
    }
    private static void postorderTraversalHelper(TreeNode root, List<Integer> list) {
        if (root != null) {
            postorderTraversalHelper(root.left, list);
            postorderTraversalHelper(root.right, list);
            list.add(root.val);
        }
    }
    /**
     * recursive, no return.
     * @param root
     */
    public static void postorderRecursive(TreeNode root) {
        if (root != null) {
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.print(root.val + " ");
        }
    }
}
