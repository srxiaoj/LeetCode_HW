import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        /**
         *              15
         *              / \
         *             8   20
         *            /    / 
         *           5    17
         *               /
         *              16
         */
        ValidateBinarySearchTree obj = new ValidateBinarySearchTree();
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(8);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(5);
        root.right.left = new TreeNode(17);
        root.right.left.left = new TreeNode(16);
        System.out.println(obj.isValidBST(root));

        TreeNode root2 = null;
        System.out.println(obj.isValidBST(root2));
    }

    /**
     * 调用ResultType，存放isValid，以及左右子树最大，最小值
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        return isValid(root).isValid;
    }

    public static ResultType isValid(TreeNode root) {
        if (root == null) return new ResultType();
        ResultType left = isValid(root.left);
        ResultType right = isValid(root.right);

        if (!left.isValid || !right.isValid) {
            return new ResultType(false, 0, 0);
        }

        if (left.isValid && left.max >= root.val || right.isValid && right.min <= root.val) {
            return new ResultType(false, 0, 0);
        }

        return new ResultType(true, Math.max(root.val, right.max), Math.min(root.val, left.min));
    }

    private static class ResultType {
        boolean isValid;
        int max;
        int min;
        public ResultType(boolean isValid, int max, int min) {
            this.isValid = isValid;
            this.max = max;
            this.min = min;
        }

        public ResultType() {
            this.isValid = true;
            this.max = Integer.MIN_VALUE;
            this.min = Integer.MAX_VALUE;
        }
    }

    /**
     * in order traversal tree, 如果不是按顺序排序的，则不是bst, 时间O(n)， 空间O(n)
     * @param root
     * @return
     */
    /*public static boolean isValidBST(TreeNode root) {
        List<Integer> list = inorderTraversal(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }*/
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversalHelper(root, list);
        return list;
    }
    private static void inorderTraversalHelper(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorderTraversalHelper(root.left, list);
            list.add(root.val);
            inorderTraversalHelper(root.right, list);
        }
    }
}
