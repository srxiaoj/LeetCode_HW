import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public static void main(String[] args) {
        int[] preorder = {15, 8, 5, 17, 16, 20};
        int[] inorder = {5, 8, 15, 16, 17, 20};
        int[] preorder2 = {1, 2, 3};
        int[] inorder2 = {2, 3, 1};
        int[] preorder3 = {15, 8, 5, 17, 16, 20};
        int[] inorder3 = {5, 17, 15, 16, 8, 20};
        TreeNode.printNode(buildTreeDivideAndConquer(preorder, inorder));
        TreeNode.printNode(buildTreeDivideAndConquer(preorder2, inorder2));
        TreeNode.printNode(buildTreeDivideAndConquer(preorder3, inorder3));
    }

    /**
     * Divide and conquer.
     */
    public static TreeNode buildTreeDivideAndConquer(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, inorder, 0, inorder.length - 1);
    }

    public static TreeNode buildTreeHelper(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd || preStart > preorder.length - 1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        // Find position of root value in inorder array, so that we can divide inorder array with root,
        // and divide preorder array with k. (left root right)
        int k = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                k = i;
                break;
            }
        }
        // 如果遍历完inorder都找不到preorder[preStart]，说明该inorder 为错误input
        if (k == 0 && inorder[k] != preorder[preStart]) {
            throw new AssertionError("invalid input array!!!!!!!");
        }
        int leftIndex = preStart + 1;
        int rightIndex = preStart + 1 + (k - inStart);
        root.left = buildTreeHelper(preorder, leftIndex, inorder, inStart, k - 1);
        root.right = buildTreeHelper(preorder, rightIndex, inorder, k + 1, inEnd);
        return root;
    }

    /**
     * Iterative.
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.add(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = stack.lastElement();
            int pos = map.get(node.val);
            int cur = map.get(preorder[i]);
            if (cur < pos) {
                TreeNode left = new TreeNode(preorder[i]);
                node.left = left;
                stack.add(left);
            } else {
                while (!stack.isEmpty() && cur > pos) {
                    node = stack.pop();
                    if (stack.isEmpty()) break;
                    pos = map.get(stack.peek().val);
                }
                TreeNode right = new TreeNode(preorder[i]);
                node.right = right;
                stack.add(right);
            }
            for (TreeNode key : stack) {
                System.out.print(key.val + " ");
            }
            System.out.println();
        }
        return root;

    }


}
