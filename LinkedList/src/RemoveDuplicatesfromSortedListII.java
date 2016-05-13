/**
 * Created by thanksgiving on 12/28/15.
 */
public class RemoveDuplicatesfromSortedListII {
    public static void main(String[] args) {
        RemoveDuplicatesfromSortedListII obj = new RemoveDuplicatesfromSortedListII();
        int[] a = {1, 2, 3, 3, 4, 4, 5, 6, 6, 6};
        int[] b = {1, 1, 2, 2, 2, 3, 3, 4};
//        int[] a = {1, 1, 2, 2};
//        int[] b = {1, 1, 2, 2, 2, 3, 3, 4};
        ListNode l1 = ListNode.create(a);
        ListNode r1 = obj.deleteDuplicates(l1);
        ListNode.printListNode(r1);

        ListNode l2 = ListNode.create(b);
        ListNode r2 = obj.deleteDuplicates(l2);
        ListNode.printListNode(r2);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return dummy.next;

      /*  if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            // cur node has no duplicates
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;*/
    }
}
