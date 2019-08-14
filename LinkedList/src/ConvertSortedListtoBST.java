/**
 * Created by thanksgiving on 2/25/16.
 */
public class ConvertSortedListtoBST {

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4};
    ListNode test = ListNode.create(a);
    ConvertSortedListtoBST obj = new ConvertSortedListtoBST();
    TreeNode res = obj.sortedListToBST(test);
    System.out.println(res.val);
    System.out.println(res.right.val);
//        System.out.println(res.left.val);
  }

  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return new TreeNode(head.val);
    }
    ListNode pre = null;
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    TreeNode root = new TreeNode(slow.val);
    pre.next = null;
    root.left = sortedListToBST(head);
    root.right = sortedListToBST(slow.next);
    return root;
  }

  private class TreeNode {

    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int a) {
      this.val = a;
    }
  }
}
