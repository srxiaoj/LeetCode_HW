import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
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
//        printTwoDArrayList(levelOrderTraversal(root2));
//        root2.inorderRecursive(root2);
//        System.out.println("");
//        root2.preorderRecursive(root2);
//        System.out.println("");
    }
    /**
     * Iterative, BFS.
     * @param root
     * @return
     */
    public static List<List<Integer>>levelOrderTraversal(TreeNode root) {
        List<List<Integer>> intRes = new ArrayList<>();
        if (root == null) return intRes;
        List<Integer> intRoot = new ArrayList<>();
        intRoot.add(root.val);
        intRes.add(intRoot);
        
        Stack<List<TreeNode>> stack = new Stack<>();
        List<List<TreeNode>> res = new ArrayList<>();
        List<TreeNode> onedList = new ArrayList<>();
        onedList.add(root);
        stack.add(onedList);
        boolean hasNextLevelValue = false; // assume there is no element in next level
        
        while (!stack.isEmpty()) {
            List<TreeNode> currentList = stack.pop();
            List<TreeNode> treeToAddList = new ArrayList<>();
            List<Integer> valueToAddList = new ArrayList<>();
            if (!currentList.isEmpty()) {
                for (TreeNode node : currentList) {
                    if (node.left != null) {
                        treeToAddList.add(node.left);
                        valueToAddList.add(node.left.val);
                        hasNextLevelValue = true;
                    }
                    if (node.right != null) {
                        treeToAddList.add(node.right);
                        valueToAddList.add(node.right.val);
                        hasNextLevelValue = true;
                    }
                }
                if (hasNextLevelValue) {
                    res.add(treeToAddList);
                    stack.add(treeToAddList);
                    intRes.add(valueToAddList);
                    hasNextLevelValue = false; // reset next level element to be null
                }
            }
        }
        return intRes;
        
    }
    /**
     * Recursive, DFS.
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res =  new LinkedList<List<Integer>>();
        int level = 0;
        helper(root, res, level);
        return res;
    }
    private static void helper(TreeNode root, List<List<Integer>> res, int level){
        if (root == null)
            return;
        if (level > res.size() - 1)
            res.add(new LinkedList<Integer>());
        res.get(level).add(root.val);
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }
    //print two dimensional array list, which can also be replaced by simply System.out.println(A)
    public static void printTwoDArrayList(List<List<Integer>> A)
    {
        for(int i = 0; i < A.size(); i++)
        {
            
            System.out.print(A.get(i) + "");
            System.out.println("");
        }
        
    }
}
