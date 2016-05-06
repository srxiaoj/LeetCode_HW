import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 5/6/16.
 */
public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        BinaryTreeRightSideView obj = new BinaryTreeRightSideView();
        TreeNode root = TreeNode.deserializeLevelorder("1,2,3,null,5,null,4");
        System.out.println(obj.rightSideView(root));
    }


    public List<Integer> rightSideView(TreeNode root) {
        // dfs
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res, 0);
        return res;

        // bfs
       /* List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<List<TreeNode>> stack = new Stack<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        stack.push(list);

        while (!stack.isEmpty()) {
            List<TreeNode> level = stack.pop();
            List<TreeNode> newLevel = new ArrayList<>();
            res.add(level.get(level.size() - 1).val);
            for (TreeNode node : level) {
                if (node.left != null) {
                    newLevel.add(node.left);
                }
                if (node.right != null) {
                    newLevel.add(node.right);
                }
            }
            if (!newLevel.isEmpty()) {
                stack.push(newLevel);
            }
        }
        return res;*/
    }

    public void dfs(TreeNode root, List<Integer> res, int level) {
        if (root == null) return;
        if (res.size() == level) {
            res.add(root.val);
        }
        if (root.right != null) {
            dfs(root.right, res, level + 1);
        }
        if (root.left != null) {
            dfs(root.left, res, level + 1);
        }
    }
}
