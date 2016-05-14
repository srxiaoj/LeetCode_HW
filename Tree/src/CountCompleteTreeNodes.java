
public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        /**
         *                6
         *             /     \
         *            2        8
         *          /  \     /   \
         *         0    4    7     9
         *        / \  / \  / \   / \
         *       22 6 2  3  1  5  
         */
        TreeNode root = TreeNode.deserializeLevelorder("6,2,8,0,4,7,9,22,6,2,3,1,5");
//        TreeNode root = TreeNode.deserializeLevelorder("6,2,8,0,4,7,9");
        System.out.println("number of nodes: " + countNodes(root));
    }

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        int n = 0;
        int h = getHeight(root);
        if (h == 1) return 1;
        int i = 2;
        while (root != null && i <= h) {
            if (getHeight(root.left) == getHeight(root.right)) {
                root = root.right;
//                n += Math.pow(2, h - i);
                n = n + (1 << h - i);
                i++;
            } else {
                root = root.left;
                i++;
            }
        }
//        return (int) Math.pow(2, h - 1) - 1 + n + 1;
        return (int) (1 << h - 1) - 1 + n + 1;

       /* if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        else if (root.left != null && root.right == null) return 2;
        
        int right = getHeight(root.right);
//        System.out.println("right getHeight is:" + right + ", right value is: " + root.right.val);
        int left = getHeight(root.left);
//        System.out.println("left getHeight is: " + left + ", left value is: " + root.left.val);
        int result = 0;
        if (right == left) {
//            result = (int) Math.pow(2, left) - 1 + countNodes(root.right);
            result = (1 << left) - 1 + countNodes(root.right); //shift by one bit is faster than Math.pow
        } else {
//            result = (int) Math.pow(2, right) - 1 + countNodes(root.left);
            result = (1 << right) - 1 + countNodes(root.left);
        }
        return result + 1;*/
    }
    public static int getHeight(TreeNode root) {
        if (root == null) return 0;
        int level = 0;
        TreeNode current = root;
        while (current != null) {
            current = current.left;
            level++;
        }
        return level;
    }
}
