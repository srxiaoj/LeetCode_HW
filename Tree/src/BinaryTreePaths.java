import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
  public static void main(String[] args) {
    TreeNode root = TreeNode.deserializeLevelorder("1,2,3,null,5");
    TreeNode.printNode(root);
    System.out.println(binaryTreePaths(root));
  }

  public static List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();
    bfs(res, "", root);
    return res;
  }

  private static void bfs(List<String> res, String s, TreeNode node) {
    if (node == null) return;
    String newS = s + "->" + node.val;
    if (node.left == null && node.right == null) {
      res.add(newS.substring(2));
    }

    bfs(res, newS, node.left);
    bfs(res, newS, node.right);
  }
}
