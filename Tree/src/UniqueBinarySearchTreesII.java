import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/21.
 */
public class UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        System.out.println(generateTrees(2));
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return gen(1, n);
    }

    private static List<TreeNode> gen(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++) {

            List<TreeNode> lefts = gen(start, i - 1);
            List<TreeNode> rights = gen(i + 1, end);

            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;

    }
}
