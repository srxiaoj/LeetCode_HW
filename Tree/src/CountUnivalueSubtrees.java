
public class CountUnivalueSubtrees {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CountUnivalueSubtrees obj = new CountUnivalueSubtrees();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        TreeNode.printNode(root);
        System.out.println("number of uni subtree: " + obj.countUnivalSubtrees(root));

    }
    private static int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return count;
    }

    private boolean helper(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (node.left == null && node.right == null) {
            count++;
            return true;
        }
        boolean left = helper(node.left);
        boolean right = helper(node.right);
        if (left && right) {
            if (node.left != null && node.right != null) {
                if (node.val == node.left.val && node.val == node.right.val) {
                    count++;
                    return true;
                } else {
                    return false;
                }
            } else if (node.left == null) {
                if (node.right.val == node.val) {
                    count++;
                    return true;
                } else {
                    return false;
                }
            } else {
                if (node.left.val == node.val) {
                    count++;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
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
