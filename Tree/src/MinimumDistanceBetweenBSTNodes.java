import java.util.Stack;

public class MinimumDistanceBetweenBSTNodes {

  public int minDiffInBST(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    int min = Integer.MAX_VALUE;
    stack.add(root);
    int last = Integer.MIN_VALUE;

    while (!stack.isEmpty()) {
      TreeNode cur = stack.peek();
      if (cur.left != null) {
        stack.add(cur.left);
        cur.left = null;
      } else {
        stack.pop();
        if (last != Integer.MIN_VALUE) {
          min = Math.min(min, cur.val - last);
        }
        last = cur.val;
        if (cur.right != null) {
          stack.add(cur.right);
        }
      }
    }
    return min;
  }

}
