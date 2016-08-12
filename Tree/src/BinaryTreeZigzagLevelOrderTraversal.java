import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

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
        printTwoDArrayList(zigzagLevelOrder(root));
    }

    /**
     * recursive, dfs
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        helper(res, root, 0);
        return res;
    }

    private static void helper(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) return;
        if (res.size() == level) {
            res.add(new LinkedList<>());
        }

        if (level % 2 == 0) {
            res.get(level).add(root.val);
        } else {
            res.get(level).add(0, root.val);
        }
        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);
    }

  /*  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        boolean lastIsReadLeft = true;

        while (!stack.isEmpty()) {
            List<TreeNode> currentList = stack.pop();
            List<TreeNode> treeToAddList = new ArrayList<>();
            List<Integer> valueToAddList = new ArrayList<>();
            if (!currentList.isEmpty()) {
                if (!lastIsReadLeft) {
                    for (int i = currentList.size() - 1; i >= 0; i--) {
                        if (currentList.get(i).left != null) {
                            treeToAddList.add(currentList.get(i).left);
                            valueToAddList.add(currentList.get(i).left.val);
                            hasNextLevelValue = true;
                        }
                        if (currentList.get(i).right != null) {
                            treeToAddList.add(currentList.get(i).right);
                            valueToAddList.add(currentList.get(i).right.val);
                            hasNextLevelValue = true;
                        }
                    }
                    lastIsReadLeft = true;
                } else {
                    for (int i = currentList.size() - 1; i >= 0; i--) {
                        // add right element first
                        if (currentList.get(i).right != null) {
                            treeToAddList.add(currentList.get(i).right);
                            valueToAddList.add(currentList.get(i).right.val);
                            hasNextLevelValue = true;
                        }
                        // then add left element
                        if (currentList.get(i).left != null) {
                            treeToAddList.add(currentList.get(i).left);
                            valueToAddList.add(currentList.get(i).left.val);
                            hasNextLevelValue = true;
                        }
                    }
                    lastIsReadLeft = false;
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
    }*/

    //print two dimensional array list, which can also be replaced by simply System.out.println(A)
    public static void printTwoDArrayList(List<List<Integer>> A) {
        for (int i = 0; i < A.size(); i++) {

            System.out.print(A.get(i) + "");
            System.out.println("");
        }

    }
}
