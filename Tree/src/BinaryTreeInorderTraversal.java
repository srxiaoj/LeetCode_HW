import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserializeLevelorder("15,8,20,5,null,17,null,null,null,16,null");
        TreeNode.printNode(root);
//        System.out.println(inorderTraversalIterate(root));
    }
    /**
     * Iterative.
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversalIterate(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
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
                list.add(curNode.val);
                stack.pop();
                if (curNode.right != null) {
                    stack.add(curNode.right); // add right value
                }
            }
        }
        return list;
    }
    /**
     * recursive.
     * @param root
     * @return list of in order elements
     */
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
    /**
     * recursive, no return.
     * @param root
     */
    public static void inOrderRecursive(TreeNode root) {
        if (root != null) {
            inOrderRecursive(root.left);
            System.out.print(root.val + " ");
            inOrderRecursive(root.right);
        }
    }
}
