
public class ClosestBinarySearchTreeValue {

    public static void main(String[] args) {
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
        TreeNode.printNode(root);
        System.out.println("The closest value is: " + closestValue(root, 8.2));

        TreeNode root2 = TreeNode.deserializeLevelorder("15, 14, null");
        System.out.println("The closest value is: " + closestValue(root2, -15));
    }
    
    public static int closestValue(TreeNode root, double target) {

        int res = root.val;
        while (root != null) {
            if (root.val == target)
                return root.val;
            if (Math.abs(root.val - target) < Math.abs(res - target)) {
                res = root.val;
            }
            if (root.val > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
//        int closestVal = root.val;
//        while(root != null){ 
//            //update closestVal if the current value is closer to target
//            closestVal = (Math.abs(target - root.val) < Math.abs(target - closestVal))? root.val : closestVal;
//            if(closestVal == target){   //already find the best result
//                return closestVal;
//            }
//            root = (root.val > target)? root.left: root.right;   //binary search
//        }
//        return closestVal;
    }
}
