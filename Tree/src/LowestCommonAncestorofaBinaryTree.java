import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorofaBinaryTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /**
         *                 3
         *              /    \
         *             5      1
         *            / \    /  \
         *           6   2  0    8
         *              / \
         *             7   4 
         */
        TreeNode root = TreeNode.deserializeLevelorder("3,5,1,6,2,0,8,null,null,7,4");

        TreeNode p = root.left;
        TreeNode q = root.right.right;
        System.out.println(lowestCommonAncestor(root, p, q).val);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q); // if not found, will return null
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        if(left != null) {
            System.out.println("right is null");
            return left;
        } else {
            System.out.println("left is null");
            return right;
        }
    }
    /**
     * Iterative.
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pAns = new ArrayList<TreeNode>();
        List<TreeNode> qAns = new ArrayList<TreeNode>();
        findAncestors(p, root, pAns);
        findAncestors(q, root, qAns);

        TreeNode anc = root;
        int i = 1;
        while (i<pAns.size() && i<qAns.size()){
            if (pAns.get(i) == qAns.get(i)){
                anc = pAns.get(i);
            }
            else{
                break;
            }
            i++;
        }
        return anc;
    }

    private boolean findAncestors(TreeNode toFind, TreeNode parent, List<TreeNode> ans){
        if (parent == null){
            return false;
        }
        if (toFind == parent){
            ans.add(parent);
            return true;
        }
        ans.add(parent);
        if (findAncestors(toFind,parent.left,ans)){
            return true;
        }
        if (findAncestors(toFind,parent.right,ans)){
            return true;
        }
        ans.remove(ans.size()-1);
        return false;
    }
}
