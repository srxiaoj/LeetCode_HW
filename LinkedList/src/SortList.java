
public class SortList {

  public static void main(String[] args) {
    ListNode a = ListNode.create(new int[]{4, 2, 1, 3});
    printList(a);
    ListNode res = sortList(a);
    printList(res);
  }

  /**
   * divide and conquer, 找到first half, second half, 分别sort, 然后再merge
   */
  public static ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode second = slow.next;
    slow.next = null;
    printList(head);
    printList(second);
    return merge(sortList(head), sortList(second));
  }

  private static ListNode merge(ListNode a, ListNode b) {
    ListNode c = new ListNode(0);
    ListNode dummy = c;
    while (a != null && b != null) {
      if (a.val < b.val) {
        c.next = a;
        a = a.next;
      } else {
        c.next = b;
        b = b.next;
      }
      c = c.next;
    }

    if (a != null) {
      c.next = a;
    }
    if (b != null) {
      c.next = b;
    }
    return dummy.next;
  }

  //print out list
  private static void printList(ListNode res) {
    while (res != null) {
      System.out.print(res.val + " ");
      res = res.next;
    }
    System.out.println("");
  }
}
