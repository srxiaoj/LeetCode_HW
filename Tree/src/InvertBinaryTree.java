
public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode newTree = invertTree(root);
        
        System.out.println(newTree.left.val);
        System.out.println(newTree.left.right.val);
    }

    /**
     * 将left child存为temp, 然后recursive call invertTree方法
     * root.left = invertTree(right)
     * root.right = invertTree(temp)
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
