
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


    /**
     * n 记录最底层的node数
     * 如果getHeight(2) == getHeight(8)， 那么意味着2对应着的最底层的4个一定不是null，则最底层 n += 4
     * 计算当前node扩展到最底层的方法为，i: 当前层数，h： 总层数 num = 1 << (h - i)
     */
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
            } else {
                root = root.left;
            }
            i++;
        }
//        return (int) Math.pow(2, h - 1) - 1 + n + 1;
        return (int) (1 << h - 1) - 1 + n + 1;
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
