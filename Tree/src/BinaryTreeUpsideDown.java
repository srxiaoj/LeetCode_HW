import java.util.Stack;

public class BinaryTreeUpsideDown {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println("Before inverse");
        TreeNode.printNode(root);
        System.out.println("After inverse");
        TreeNode res = upsideDownBinaryTree(root);
        TreeNode.printNode(res);
        
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        System.out.println("Before inverse");
        TreeNode.printNode(root2);
        System.out.println("After inverse");
        TreeNode res2 = upsideDownBinaryTree(root2);
        TreeNode.printNode(res2);
    }

    public static TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode res = null;
        TreeNode temp = null;
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.lastElement();
            if (curNode.left != null) {
                stack.add(curNode.left);
                curNode.left = null;
            } else {
                if (res == null) {
                    res = new TreeNode(curNode.val);
                    temp = res;
                } else { // res != null
                    if (curNode.right != null) {
                        TreeNode left = new TreeNode(curNode.right.val);
                        temp.left = left;
                    } else {
                        temp.left = null;
                    }
                    TreeNode right = new TreeNode(curNode.val);
                    temp.right = right;
                    temp = temp.right;
                }
                stack.pop();
            }
        }
        return res;
    }
}
