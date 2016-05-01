
public class SameTree {

    public static void main(String[] args) {
        TreeNode root1 = TreeNode.deserializeLevelorder("15, 8, 20");
        TreeNode root2 = TreeNode.deserializeLevelorder("15, 8, 20");
        System.out.println(isSameTree(root1, root2));
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
