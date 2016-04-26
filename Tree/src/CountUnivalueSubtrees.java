public class CountUnivalueSubtrees {

    public static void main(String[] args) {
        CountUnivalueSubtrees obj = new CountUnivalueSubtrees();
        TreeNode root = TreeNode.deserializeLevelorder("5,1,5,5,5,null,5");
        TreeNode.printNode(root);
        System.out.println("number of uni subtree: " + obj.countUnivalSubtrees(root));

    }
    public int countUnivalSubtrees(TreeNode root) {
        return helper(root).count;
    }

    public ResultSet helper(TreeNode node) {
        if (node == null) return new ResultSet(true, 0);
        if (node.left == null && node.right == null) return new ResultSet(true, 1);
        ResultSet left = helper(node.left);
        ResultSet right = helper(node.right);
        int count = left.count + right.count;
        if (left.isUniValue && right.isUniValue) {
            if (node.left != null && node.left.val != node.val){
                return new ResultSet(false, count);
            } else if (node.right != null && node.right.val != node.val) {
                return new ResultSet(false, count);
            } else {
                count++;
                return new ResultSet(true, count);
            }
        }
        return new ResultSet(false, count);
    }

    class ResultSet {
        boolean isUniValue;
        int count;
        public ResultSet(boolean a, int b) {
            isUniValue = a;
            count = b;
        }
    }

    /*
    public static int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }

    private static boolean helper(TreeNode node, int[] count) {
        if (node == null) {
            return true;
        }
        boolean left = helper(node.left, count);
        boolean right = helper(node.right, count);
        if (left && right) {
            if (node.left != null && node.val != node.left.val) {
                return false;
            }
            if (node.right != null && node.val != node.right.val) {
                return false;
            }
            // either node.left == node.val or node.right == node.val or node.left/right == null
            count[0]++;
            return true;
        }
        return false;
    }
    */
}
