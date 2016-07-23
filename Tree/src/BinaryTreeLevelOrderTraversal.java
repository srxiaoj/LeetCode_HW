import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        /**
         *              15
         *              / \
         *             8   20
         *            /    / 
         *           5    17
         *               /
         *              16
         */
        BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();
        TreeNode root = TreeNode.deserializeLevelorder("15,8,20,5,null,17,null,null,null,16,null");
        TreeNode.printNode(root);
        System.out.println(obj.levelOrder(root));
//        printTwoDArrayList(levelOrderTraversal(root));
//        root.inorderRecursive(root);
//        System.out.println("");
//        root.preorderRecursive(root);
//        System.out.println("");
//        System.out.println("************");

        /**
         *                 6
         *              /    \
         *             2      8
         *            / \    /  \
         *           0   4  7    9
         *              / \
         *             3   5 
         */
        TreeNode root2 = TreeNode.deserializeLevelorder("6,2,8,0,4,7,9,null,null,3,5");
        TreeNode.printNode(root2);
        printTwoDArrayList(levelOrderTraversal(root2));
//        root2.inorderRecursive(root2);
//        System.out.println("");
//        root2.preorderRecursive(root2);
//        System.out.println("");
    }

    /**
     * Iterative, BFS.
     */
    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res.add(new ArrayList<>());
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                res.get(res.size() - 1).add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

    /**
     * Recursive, DFS.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        int level = 0;
        dfs(root, res, level);
        return res;
    }

    private static void dfs(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (level == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        dfs(root.left, res, level + 1);
        dfs(root.right, res, level + 1);
    }

    //print two dimensional array list, which can also be replaced by simply System.out.println(A)
    public static void printTwoDArrayList(List<List<Integer>> A) {
        for (int i = 0; i < A.size(); i++) {
            System.out.print(A.get(i) + "");
            System.out.println("");
        }

    }
}
