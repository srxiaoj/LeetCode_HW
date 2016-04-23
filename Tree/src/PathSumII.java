import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 1/27/16.
 */
public class PathSumII {
    public static void main(String[] args) {
        PathSumII obj = new PathSumII();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
//        TreeNode.printNode(root);
        System.out.println(obj.pathSum(root, 22));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        helper(result, part, root, sum);
        return result;

    }

    public void helper(List<List<Integer>> result, List<Integer> part, TreeNode node, int target) {
        if (node == null) return;
        target -= node.val;
        part.add(node.val);
        if (node.left == null && node.right == null) {
            if (target == 0) {
                result.add(new ArrayList<>(part));
                return;
            }
        }
        helper(result, new ArrayList<>(part), node.left, target);
        helper(result, new ArrayList<>(part), node.right, target);
    }
}
