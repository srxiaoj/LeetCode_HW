/**
 * Created by thanksgiving on 12/28/15.
 */
public class RemoveDuplicatesfromSortedList {

  public static void main(String[] args) {
    RemoveDuplicatesfromSortedList obj = new RemoveDuplicatesfromSortedList();
    // int[] a = {1, 1, 2, 2};
    int[] b = {1, 1, 2, 3, 3};
    // ListNode l1 = ListNode.create(a);
    // ListNode r1 = obj.deleteDuplicates(l1);
    // ListNode.printListNode(r1);

    ListNode l2 = ListNode.create(b);
    ListNode r2 = obj.deleteDuplicates(l2);
    ListNode.printListNode(r2);
  }

  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode cur = head;
    cur = cur.next;
    ListNode pre = head;
    while (cur != null) {
      if (cur.val == pre.val) {
        pre.next = cur.next;
      } else {
        pre = pre.next;
      }
      cur = cur.next;

      System.out.println("cur is");
      ListNode.printListNode(cur);
    }
    return head;
  }
}
