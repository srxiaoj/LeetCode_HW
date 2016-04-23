import java.util.HashMap;
import java.util.Stack;

/**
 * Created by thanksgiving on 12/23/15.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
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
        ConstructBinaryTreefromInorderandPostorderTraversal obj = new ConstructBinaryTreefromInorderandPostorderTraversal();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        TreeNode.printNode(root);
        System.out.println("\nPost order");
        TreeNode.postorderRecursive(root);
        System.out.println("\nIn order");
        TreeNode.inorderRecursive(root);
        System.out.println("\nPre order");
        TreeNode.preorderRecursive(root);
        System.out.println("\nConstruct tree");
        int[] inorder = {0, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] postOrder = {0, 3, 5, 4, 2, 7, 9, 8, 6};
        TreeNode res = obj.buildTree(inorder, postOrder);
        TreeNode.printNode(res);

        int[] inorder2 = {3, 2, 1};
        int[] postOrder2 = {3, 2, 1};
        TreeNode res2 = obj.buildTree(inorder2, postOrder2);
        TreeNode.printNode(res2);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int len = postorder.length;
        TreeNode root = new TreeNode(postorder[len - 1]);
        stack.add(root);
        for (int i = len - 2; i >= 0; i--) {
            TreeNode curNode = stack.peek();
            TreeNode newNode = new TreeNode(postorder[i]);
            int pos = map.get(postorder[i]);
            if (pos > map.get(curNode.val)) {
                curNode.right = newNode;
            } else {
                while (!stack.isEmpty() && pos < map.get(stack.peek().val)) {
                    curNode = stack.pop();
                }
                curNode.left = newNode;
            }
            stack.add(newNode);
        }
        return root;
    }
}
