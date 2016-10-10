/**
 * Created by thanksgiving on 10/9/16.
 */
public class IsSubtree {
    public static void main(String[] args) {
        TreeNode a = TreeNode.deserializeLevelorder("2, 1, 3");
        TreeNode b = new TreeNode(5);
        b.left = a;
        b.right = TreeNode.deserializeLevelorder("15, 6, null");
        System.out.println(isSubTree(b, a));
    }

    public static boolean isSubTree(TreeNode T1, TreeNode T2) {
        if (T2 == null) return true;
        if (T1 == null) return false;
        return sameTree(T1, T2) || isSubTree(T1.left, T2) || isSubTree(T1.right, T2);
    }

    private static boolean sameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        return sameTree(a.left, b.left) && sameTree(a.right, b.right);
    }
}
