
public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /**
         *                 6
         *              /    \
         *             2      8
         *            / \    /  \
         *           0   4  7    9
         *              / \
         *             3   5 
         */
        TreeNode root = TreeNode.deserializeLevelorder("6,2,8,0,4,7,9,null,null,3,5");
//        System.out.println(nodeTotalSum(root));
        BinaryTreeMaximumPathSum obj = new BinaryTreeMaximumPathSum();
        System.out.println(obj.maxPathSum(root));
    }
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        // 2 possible choices
        // 1.Already calculated in left or right child
        // 2.left max path + right max path + root
        int lMax = dfs(root.left);
        int rMax = dfs(root.right);
        if (lMax + rMax + root.val > max) {
            max = lMax + rMax + root.val; // continuing update max while calculating lMax and rMax
        }
        // if the below path is negative, just make it 0 so that we could 'ignore' it
        return Math.max(0, root.val + Math.max(lMax, rMax));
    }
    /**
     * return the sum of all the children value including the root
     * @param root
     * @return
     */
    private static int nodeTotalSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + nodeTotalSum(root.left) + nodeTotalSum(root.right);
    }
}
