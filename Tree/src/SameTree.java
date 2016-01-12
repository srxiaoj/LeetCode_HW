
public class SameTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root1 = new TreeNode(15);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(20);
        TreeNode root2 = new TreeNode(15);
        root2.left = new TreeNode(8);
        root2.right = new TreeNode(20);
        
        System.out.println(isSameTree(root1, root2));
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
