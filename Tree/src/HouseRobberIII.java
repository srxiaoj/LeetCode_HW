

/**
 * Created by thanksgiving on 4/25/16.
 */
public class HouseRobberIII {
    public static void main(String[] args) {
        HouseRobberIII obj = new HouseRobberIII();

        TreeNode root = TreeNode.deserializeLevelorder("3,2,3,null,3,null,1");
        TreeNode.printNode(root);
        System.out.println(obj.rob(root));

        TreeNode root2 = TreeNode.deserializeLevelorder("3,4,5,1,3,null,1");
        TreeNode.printNode(root2);
        System.out.println(obj.rob(root2));

    }

    class ResultSet {
        int maxWithRoot;
        int maxNoRoot;

        public ResultSet() {
            maxWithRoot = 0;
            maxNoRoot = 0;
        }

        public ResultSet(int a, int b) {
            maxWithRoot = a;
            maxNoRoot = b;
        }
    }
    public int rob(TreeNode root) {
        ResultSet res = helper(root);
        return Math.max(res.maxWithRoot, res.maxNoRoot);
    }

    private ResultSet helper(TreeNode root) {
        if (root == null) return new ResultSet(0, 0);
        ResultSet res = new ResultSet();
        res.maxWithRoot = Math.max(Math.max(helper(root.left).maxNoRoot + helper(root.right).maxNoRoot + root.val, res.maxWithRoot), res.maxNoRoot);
        res.maxNoRoot = Math.max(helper(root.left).maxWithRoot + helper(root.right).maxWithRoot, res.maxNoRoot);
        return res;
    }
}
