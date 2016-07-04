import java.util.Stack;

/**
 * Created by thanksgiving on 7/4/16.
 */
public class TwoSumInBST {
    public static void main(String[] args) {
        TreeNode node = TreeNode.deserializeLevelorder("10, 6, 20, 4, 9, 15, 27, 1, null, 7, null");
        System.out.println(bst2sum(node, 11));
    }

    /**
     * O(n) time, O(logn) space
     */
    public static boolean bst2sum(TreeNode root, int target) {
        TreeNode left, right;
        TreeNode curl = root, curr = root;
        Stack<TreeNode> stack0 = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        /*
         * Init, find the most-left and most-right node
         */
        stack0.add(root);
        stack1.add(root);
        while (curl != null) {
            stack0.push(curl);
            curl = curl.left;
        }
        curl = stack0.pop();
        left = curl;

        while (curr != null) {
            stack1.push(curr);
            curr = curr.right;
        }
        curr = stack1.pop();
        right = curr;

        /*while (curl != null || !stack0.isEmpty()) {
            if (curl != null) {
                stack0.push(curl);
                curl = curl.left;
            } else {
                curl = stack0.pop();
                left = curl;
                curl = curl.right;
                break;
            }
        }
        while (curr != null || !stack1.isEmpty()) {
            if (curr != null) {
                stack1.push(curr);
                curr = curr.right;
            } else {
                curr = stack1.pop();
                right = curr;
                curr = curr.left;
                break;
            }
        }*/
        while (right.val > left.val) {
            System.out.println("left: "+left.val + ", right: "+right.val);
            if (left.val + right.val == target) {
                System.out.println(left.val + ", " + right.val);
                return true;
            } else if (left.val + right.val < target) { // move left
                while (curl != null || !stack0.isEmpty()) {
                    if (curl != null) {
                        stack0.push(curl);
                        curl = curl.left;
                    } else {
                        curl = stack0.pop();
                        left = curl;
                        curl = curl.right;
                        break;
                    }
                }
            } else if (left.val + right.val > target) { // move right
                while (curr != null || !stack1.isEmpty()) {
                    if (curr != null) {
                        stack1.push(curr);
                        curr = curr.right;
                    } else {
                        curr = stack1.pop();
                        right = curr;
                        curr = curr.left;
                        break;
                    }
                }
            }
        }
        System.out.println("the target has not been found");
        return false;
    }


    /**
     * O (nlog(n))
     */
    public static boolean twoSumInBST(TreeNode root, int target) {
        if (root == null) return false;
        if (findVal(root, target - root.val, root)) {
            return true;
        }
        Boolean left = twoSumInBST(root.left, target);
        Boolean right = twoSumInBST(root.right, target);
        return left || right;
    }

    private static boolean findVal(TreeNode node, int t, TreeNode firstNode) {
        while (node != null) {
            if (node.val == t && node.val != firstNode.val) {
                return true;
            }
            if (node.val > t) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }
}
