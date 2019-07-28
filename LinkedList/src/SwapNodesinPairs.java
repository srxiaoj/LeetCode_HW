/**
 * Created by thanksgiving on 2/15/16.
 */
public class SwapNodesinPairs {

  public static void main(String[] args) {
    int[] list = {1, 2, 3, 4};
    ListNode head = ListNode.create(list);
    SwapNodesinPairs obj = new SwapNodesinPairs();
    ListNode.printListNode(obj.swapPairs(head));
  }

  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode res = new ListNode(0);
    res.next = head;
    ListNode pre = res;
    ListNode cur = head;
    while (cur != null && cur.next != null) {
      ListNode nxt = cur.next;
      cur.next = nxt.next;
      nxt.next = cur;
      pre.next = nxt;
      pre = cur;
      cur = cur.next;
      ListNode.printListNode(cur);
    }
    return res.next;
  }

  /**
   * recursive
   * @param head
   * @return
   */
  // public ListNode swapPairs(ListNode head) {
  //   if (head == null) {
  //     return null;
  //   }
  //   if (head.next == null) {
  //     return head;
  //   }
  //   ListNode next = head.next;
  //   ListNode nextToNext = head.next.next;
  //   ListNode dummy = new ListNode(0);
  //   ListNode res = dummy;
  //   dummy.next = head.next;
  //   dummy = dummy.next;
  //   dummy.next = head;
  //   dummy = dummy.next;
  //   dummy.next = swapPairs(nextToNext);
  //   return res.next;
  // }
}
