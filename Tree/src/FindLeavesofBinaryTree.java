import java.util.LinkedList;
import java.util.List;

/**
 * Created by thanksgiving on 8/31/16.
 */
public class FindLeavesofBinaryTree {
    public static void main(String[] args) {
        FindLeavesofBinaryTree obj = new FindLeavesofBinaryTree();
        TreeNode root = TreeNode.deserializeLevelorder("1, 2, 3, 4, 5");
        TreeNode.printNode(root);
        System.out.println(obj.findLeaves(root));
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        helper(root, res);
        return res;
    }

    public Pair helper(TreeNode root, List<List<Integer>> res) {
        // 如果是 leaf， level为 0， 所以null的level = -1
        if (root == null) {
            return new Pair(null, -1);
        }

        Pair left = helper(root.left, res);
        Pair right = helper(root.right, res);
        int level = Math.max(left.level, right.level) + 1;
        if (res.size() <= level) {
            res.add(new LinkedList<>());
        }
        res.get(level).add(root.val);
        return new Pair(root, level);
    }

    private class Pair {
        int level;
        TreeNode node;
        public Pair(TreeNode node, int level) {
            this.level = level;
            this.node = node;
        }
    }
}
