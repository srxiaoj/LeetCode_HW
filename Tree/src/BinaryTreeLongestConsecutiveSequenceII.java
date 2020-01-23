public class BinaryTreeLongestConsecutiveSequenceII {

  public static void main(String[] args) {
    BinaryTreeLongestConsecutiveSequenceII obj = new BinaryTreeLongestConsecutiveSequenceII();
    /**
     *           1
     *          / \
     *         2   0
     *        /
     *       3
     */
    TreeNode root1 = TreeNode.deserializeLevelorder("1,2,0,3,null");
    // TreeNode.printNode(root1);
    System.out.println(obj.longestConsecutive2(root1));
  }


  int[] max;

  public int longestConsecutive2(TreeNode root) {
    if (root == null) {
      return 0;
    }
    max = new int[]{0};
    helper(root);
    return max[0];
  }

  private Node helper(TreeNode parent) {
    if (parent == null) {
      return null;
    }
    Node left = helper(parent.left);
    Node right = helper(parent.right);
    Node node = new Node();
    node.treeNode = parent;
    node.upMax = 1;
    node.downMax = 1;

    if (left != null) {
      if (parent.val + 1 == left.treeNode.val) {
        node.downMax = Math.max(node.downMax, left.downMax + 1);
      }
      if (parent.val - 1 == left.treeNode.val) {
        node.upMax = Math.max(node.upMax, left.upMax + 1);
      }
    }

    if (right != null) {
      if (parent.val + 1 == right.treeNode.val) {
        node.downMax = Math.max(node.downMax, right.downMax + 1);
      }
      if (parent.val - 1 == right.treeNode.val) {
        node.upMax = Math.max(node.upMax, right.upMax + 1);
      }
    }

    // it could be like left.val + 1 = node = right.val - 1
    max[0] = Math.max(max[0], node.upMax + node.downMax - 1);
    return node;
  }

  class Node {

    int upMax;
    int downMax;
    TreeNode treeNode;
  }
}
