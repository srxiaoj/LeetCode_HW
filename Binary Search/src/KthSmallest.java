public class KthSmallest {
    public static void main(String[] args) {
        /*
         * http://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
         */
        TreeNode node = new TreeNode(20);
        node.left = new TreeNode(8);
        node.right = new TreeNode(22);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(12);
        node.left.right.left = new TreeNode(10);
        node.left.right.right = new TreeNode(14);
        System.out.println(kthSmallest(node, 3));

        TreeNode node2 = new TreeNode(1);
        node2.right = new TreeNode(2);
        System.out.println(kthSmallest(node2, 2));
    }

    private static int number = 0;
    private static int count = 0;

    /**
     * 借用一个方法count一个节点下共有多少个节点
     * 如果
     */
    public static int kthSmallest(TreeNode root, int k) {
        //method 3: DFS in-order recursive
        // better keep these two variables in a wrapper class
//        count = k;
//        helper(root);
//        return number;
        /*
        //method 2: DFS in-order iterate
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null) {
                stack.push(node.left);
                node.left = null;
            } else {
                k--;
                stack.pop();
                if (k == 0) {
                    return node.val;
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return -1;
        */

        //method 1: Binary Search (dfs): O(h), h is the height of tree
        int left = countNodes(root.left);
        if (left > k - 1) {
            return kthSmallest(root.left, k);
        } else if (left < k - 1) {
            return kthSmallest(root.right, k - left - 1);
        } else {
            return root.val;
        }
    }

    private static int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return countNodes(node.left) + countNodes(node.right) + 1;
        }
    }

    public static void helper(TreeNode n) {
        if (n.left != null) helper(n.left);
        count--;
        if (count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null) helper(n.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}