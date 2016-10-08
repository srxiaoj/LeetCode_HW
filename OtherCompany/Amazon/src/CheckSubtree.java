/**
 * Created by Administrator on 2016/10/7.
 */
public class CheckSubtree {
    // SOL 1
    // time O(nm) or O(n + km) k is the number of occurrences of T2's root in T1
    // space O(log n + log m) recursion
    public static int check1(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return 1;
        }
        if (subTree(t1, t2)) {
            return 1;
        } else return -1;
    }

    public static boolean subTree(TreeNode r1, TreeNode r2) {
        if (r1 == null) {
            return false;
        } else if (r1.val == r2.val && matchTree(r1, r2)) {
            return true;
        }
        return (subTree(r1.left, r2) || subTree(r1.right, r2));
    }

    public static boolean matchTree(TreeNode r1, TreeNode r2) {
        if (r2 == null && r1 == null) {
            return true;
        } else if (r1 == null || r2 == null) {
            return false;
        } else if (r1.val != r2.val) {
            return false;
        } else {
            return (matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right));
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}
