import java.util.HashMap;
import java.util.Map;

/**
 * Created by thanksgiving on 7/5/16.
 */
public class LeftRightValueEqualTree {
    public static void main(String[] args) {
        TreeNode node = TreeNode.deserializeLevelorder("8, 1, 5, 4, 4, 2, 2");
        TreeNode.printNode(node);
        System.out.println(isValid2(node));
        TreeNode.printNode(node);
    }

    /**
     * 方法1
     */
    public static boolean isValid(TreeNode root) {
        if (root == null) return false;
        ResultType rs = helper(root);
        return isValid(rs);
    }

    public static boolean isValid(ResultType rs) {
        if (rs.node == null) return false;
        if (rs.left == null && rs.right == null) return true;
        if (rs.left == null || rs.right == null) return false;
        if (rs.left.sum != rs.right.sum) return false;
        return isValid(rs.left) && isValid(rs.right);
    }

    private static ResultType helper(TreeNode root) {
        ResultType rs = new ResultType(root, root.val);
        if (rs.node.left == null && rs.node.right == null) {
            rs.sum = rs.node.val;
//            rs.hasComputed = true;
            return rs;
        }

        ResultType left = helper(rs.node.left);
        ResultType right = helper(rs.node.right);
        rs.sum = root.val + left.sum + right.sum;
//        rs.hasComputed = true;
        rs.left = left;
        rs.right = right;
        return rs;
    }

    private static class ResultType {
//        boolean hasComputed;
        TreeNode node;
        ResultType left;
        ResultType right;
        int sum;
        public ResultType(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
//            hasComputed = false;
        }
    }

    /**
     * 方法2
     */
    public static boolean isValid2(TreeNode root) {
        Map<TreeNode, Integer> sumMap = new HashMap<>();
        Map<TreeNode, Boolean> isCompute = new HashMap<>();
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        getSum(root, sumMap, isCompute);
        if (sumMap.get(root.left) != sumMap.get(root.right)) return false;
        return isValid2(root.left) && isValid2(root.right);
    }

    private static void getSum(TreeNode root, Map<TreeNode, Integer> sumMap, Map<TreeNode, Boolean> isCompute) {
        if (root.left == null && root.right == null) {
            sumMap.put(root, root.val);
            isCompute.put(root, true);
            return;
        }
        if (isCompute.containsKey(root)) {
            return;
        }
        int left = 0, right = 0;
        if (root.left != null) {
            getSum(root.left, sumMap, isCompute);
            left = sumMap.get(root.left);
        }
        if (root.right != null) {
            getSum(root.right, sumMap, isCompute);
            right = sumMap.get(root.right);
        }

        sumMap.put(root, left + right + root.val);
        isCompute.put(root, true);
    }
}
