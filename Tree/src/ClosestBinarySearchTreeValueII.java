import java.util.List;

public class ClosestBinarySearchTreeValueII {

    public static void main(String[] args) {
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
    }
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        return null;
    }
}
