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

    /**
     * dynamic programming
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int[] maxVal = dpRob(root);
        return Math.max(maxVal[0], maxVal[1]);
    }
    public int[] dpRob(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        } else {
            //maxVal[0] store the max value without robing current node, maxVal[1] store the max value with robing current node,
            int[] maxVal = new int[2];
            int[] leftMax = dpRob(root.left);
            int[] rightMax = dpRob(root.right);
            maxVal[0] = Math.max(leftMax[0], leftMax[1]) + Math.max(rightMax[0], rightMax[1]);
            maxVal[1] = leftMax[0] + rightMax[0] + root.val;
            return maxVal;
        }
    }
}
