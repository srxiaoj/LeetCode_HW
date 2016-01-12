/**
 * Created by thanksgiving on 12/28/15.
 */
public class RemoveDuplicatesfromSortedListII {
    public static void main(String[] args) {
        RemoveDuplicatesfromSortedListII obj = new RemoveDuplicatesfromSortedListII();
        int[] a = {1, 2, 3, 3, 4, 4, 5, 6, 6, 6};
        int[] b = {1, 1, 2, 2, 2, 3, 3, 4};
        ListNode l1 = ListNode.create(a);
        ListNode r1 = obj.deleteDuplicates(l1);
        ListNode.printListNode(r1);

        ListNode l2 = ListNode.create(b);
        ListNode r2 = obj.deleteDuplicates(l2);
        ListNode.printListNode(r2);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode last = fakeHead;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            // cur node has no duplicates
            if (last.next == cur) {
                last = last.next;
            } else {
                last.next = cur.next;
            }
            cur = cur.next;
        }
        return fakeHead.next;
    }
}
