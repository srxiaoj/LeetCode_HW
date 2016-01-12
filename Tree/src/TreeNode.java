import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x) { val = x; }
    
    /**
     * print tree with in order traversal.
     */
    public void printTreeInOrder(TreeNode root) {
        if (root != null) {
            printTreeInOrder(root.left);
            System.out.print(root.val + " ");
            printTreeInOrder(root.right);
        }
    }
    public int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    
    /**
     * recursive, no return.
     * @param root
     */
    public void inorderRecursive(TreeNode root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.val + " ");
            inorderRecursive(root.right);
        }
    }
    
    /**
     * recursive, no return.
     * @param root
     */
    public void preorderRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    }
    
    /**
     * recursive, no return.
     * @param root
     */
    public void postorderRecursive(TreeNode root) {
        if (root != null) {
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.print(root.val + " ");
        }
    }
    
}
