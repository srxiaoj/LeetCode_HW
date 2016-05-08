import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 1/24/16.
 */
public class SumRoottoLeafNumbers {
    public static void main(String[] args) {
        SumRoottoLeafNumbers obj = new SumRoottoLeafNumbers();
        TreeNode root = TreeNode.deserializeLevelorder("1,2,3");
//        TreeNode.printNode(root);
        System.out.println(obj.sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        List<String> list = new ArrayList<>();
        helper(root, "", list);
        int sum = 0;
        System.out.println("list is: " + list);
        for (int i = 0; i < list.size(); i++) {
            sum += Integer.parseInt(list.get(i));
        }
        return sum;
    }

    private void helper(TreeNode node, String part, List<String> list) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            String newRes = part + String.valueOf(node.val);
            list.add(newRes);
            return;
        }
        String newRes = part + String.valueOf(node.val);
        helper(node.left, newRes, list);
        helper(node.right, newRes, list);
    }
}
