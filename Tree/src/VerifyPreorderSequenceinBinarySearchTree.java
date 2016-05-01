import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class VerifyPreorderSequenceinBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserializeLevelorder("15,8,20,5,null,17,null,null,null,16,null");
        TreeNode.printNode(root);
        
        int[] test = new int[]{15, 8, 9, 5, 20, 17, 16};
        System.out.println(verifyPreorder(test));
    }
    public static boolean verifyPreorder(int[] preorder) {
        int[] inorder = preorder.clone();
        Arrays.sort(inorder);
        TreeNode res = getTree(preorder, inorder);
//        TreeNode.printNode(res);
        List<Integer> list = inorderTraversalIterate(res);
        int[] revInorder = toIntArray(list);
//        printArray(revInorder);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] != revInorder[i]) {
                return false;
            }
        }
        return true;
    }
    
    private static TreeNode getTree(int[] preorder, int[] inorder) {
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
     * Iterative.
     * @param root
     * @return
     */
    private static List<Integer> inorderTraversalIterate(TreeNode root) {
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

    private static int[] toIntArray(List<Integer> list) {
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = list.get(i);
        return ret;
    }
    
  //print array
    public static void printArray(int[] A)
    {
        for(int i = 0; i < A.length; i++)
        {
            if(i != A.length-1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("");
    }
}
