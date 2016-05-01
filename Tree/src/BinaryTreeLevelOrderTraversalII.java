import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {

    public static void main(String[] args) {

    }
    /**
     * Recursive, DFS.
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        int level = 0;
        helper(root, res, level);
        return res;
    }
    private void helper(TreeNode root, LinkedList<List<Integer>> res, int level)
    {
        if (root == null)
            return;
        // if the level is smaller than res size,
        // then it is still iterating upper points
        if (level > res.size() - 1) {
            res.add(0, new LinkedList<Integer>());
        }
        res.get(res.size() - 1 - level).add(root.val);
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }
}
