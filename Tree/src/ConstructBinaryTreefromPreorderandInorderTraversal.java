import java.util.HashMap;
import java.util.Stack;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] preorder = {15, 8, 5, 20, 17, 16};
        int[] inorder = {5, 8, 15, 16, 17, 20};
//        TreeNode res = buildTreeDivideAndConquer(preorder, inorder);
        TreeNode res = buildTree(preorder, inorder);
    }
    /**
     * Iterative.
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        if (preorder.length != inorder.length)
            return root;

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();

        for (int i = 0; i < preorder.length; i++) {
            int temp = map.get(preorder[i]);
            TreeNode node = new TreeNode(preorder[i]);
            if (stack.isEmpty()) {
                root = node;
                stack.add(node);
                current = root;
            } else {
                if (temp < map.get(stack.peek().val)) {
                    current.left = node;
                    current = current.left;
                } else {
                    while (!stack.isEmpty() && temp > map.get(stack.peek().val))
                        current = stack.pop();
                    current.right = node;
                    current = current.right;
                }
            }
            stack.add(node);
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
