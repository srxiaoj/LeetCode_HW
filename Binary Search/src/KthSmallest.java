import java.util.Stack;


public class KthSmallest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
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
    }
    private static int number = 0;
    private static int count = 0;
    public static int kthSmallest(TreeNode root, int k) {
        //method 3: DFS recursive
        // better keep these two variables in a wrapper class
        
            count = k;
            helper(root);
            return number;

        /*
        //method 2: DFS in-order iterate
        Stack<TreeNode> st = new Stack<>();

        while (root != null) {
            st.push(root);
            root = root.left;
        }

        while (k != 0) {
            TreeNode n = st.pop();
            k--;
            if (k == 0) return n.val;
            TreeNode right = n.right;
            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }
        return -1; // never hit if k is valid
        */
        //method 1: Binary Search (dfs): O(h), h is the height of tree
        /*
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k-count-1);
        } else {
            return root.val;
        }
        */
    }
    private static int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return countNodes(node.left)+ countNodes(node.right) + 1; 
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
     TreeNode(int x) { val = x; }
 }