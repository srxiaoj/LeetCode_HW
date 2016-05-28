import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public static void main(String[] args) {
        int[] preorder = {15, 8, 5, 17, 16, 20};
        int[] inorder = {5, 8, 15, 16, 17, 20};
        int[] preorder2 = {1, 2, 3};
        int[] inorder2 = {2, 3, 1};
//        TreeNode res = buildTreeDivideAndConquer(preorder, inorder);
//        TreeNode res = buildTree(preorder, inorder);
//        TreeNode.printNode(res);
        TreeNode res2 = buildTree(preorder2, inorder2);
        TreeNode.printNode(res2);
    }
    /**
     * Iterative.
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        /*if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
//        Arrays.sort(inorder);
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.add(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = stack.peek();
            int lastNumPos = map.get(node.val);
            int curNumPos = map.get(preorder[i]);
            if (lastNumPos > curNumPos) {
                TreeNode newNode = new TreeNode(preorder[i]);
                node.left = newNode;
                stack.add(newNode);
            } else {
                while (!stack.isEmpty() && lastNumPos < curNumPos) {
                    node = stack.pop();
                    if (stack.isEmpty()) break;
                    lastNumPos = map.get(stack.peek().val);
                }
                TreeNode newNode = new TreeNode(preorder[i]);
                node.right = newNode;
                stack.add(newNode);
            }
        }
        return root;*/

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
        }
        return root;

    }
    /**
     * Divide and conquer.
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTreeDivideAndConquer(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, inorder, 0, inorder.length-1);
    }

    public static TreeNode buildTreeHelper(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd || preStart > preorder.length-1)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);// preorder: root->left->right
        // Find position of root value in inorder array, so that we can divide inorder array with root, and divide preorder array with inIndex. (left root right)   
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                inIndex = i;
                break;
            } 
        }

        root.left = buildTreeHelper(preorder, preStart + 1, inorder, inStart, inIndex - 1); 
        root.right = buildTreeHelper(preorder, preStart + inIndex - inStart + 1, inorder, inIndex + 1, inEnd);
        return root; 
    }
}
