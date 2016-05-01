
public class LowestCommonAncestorofaBinarySearchTree {

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
        
        TreeNode p = root.left;
        TreeNode q = root.left.right;
        TreeNode res = lowestCommonAncestor(root, p, q);
        System.out.println(res.val);
        
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        TreeNode p2 = root2.left;
        TreeNode q2 = root2.right;
        System.out.println(lowestCommonAncestor(root2, p2, q2).val);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        if (root.val > p.val && root.val < q.val) {
            return root;
        }
        if (root.val < p.val && root.val > q.val) {
            return root;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }
}
