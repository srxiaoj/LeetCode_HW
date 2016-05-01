import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 1/27/16.
 */
public class PathSumII {
    public static void main(String[] args) {
        PathSumII obj = new PathSumII();
        TreeNode root = TreeNode.deserializeLevelorder("5,4,8,11,null,13,4,7,2,null,null,5,1");
        TreeNode.printNode(root);
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
