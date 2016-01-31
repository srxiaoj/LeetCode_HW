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
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> trueResult = new ArrayList<>();
        if (root == null) return res;
        helper(root, new ArrayList<>(), res);
        for (List<Integer> sub : res) {
            if (isMatch(sub, sum)) {
                trueResult.add(sub);
            }
        }
        return trueResult;
    }

    private boolean isMatch(List<Integer> sub, int sum) {
        if (sub == null) return false;
        int res = 0;
        for (Integer i : sub) {
            res += i;
        }
        return res == sum;
    }

    private void helper(TreeNode node, List<Integer> part, List<List<Integer>> res) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            part.add(node.val);
            List<Integer> newList = new ArrayList<>(part);
            res.add(newList);
            return;
        }
        part.add(node.val);
        List<Integer> newList = new ArrayList<>(part); // create new arraylist to avoid modify old result
        List<Integer> newList2 = new ArrayList<>(part);
        helper(node.left, newList, res);
        helper(node.right, newList2, res);
    }
}
