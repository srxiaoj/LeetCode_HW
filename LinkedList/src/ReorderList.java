/**
 * Created by thanksgiving on 12/29/15.
 */
public class ReorderList {
    public static void main(String[] args) {
        ReorderList obj = new ReorderList();
        int[] array = {1, 2, 3, 4, 5};
        ListNode head = ListNode.create(array);
        obj.reorderList(head);
        ListNode.printListNode(head);
//        obj.printSLowAndFast(head);
    }

    public void printSLowAndFast(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode.printListNode(slow);
    }

    /**
     * 分成两段,second half reverse, 然后把first, second half 合并
     * @param head
     */
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        fast = reverse(fast);
        slow = head;
        ListNode.printListNode(slow);
        ListNode.printListNode(fast);

        while (fast != null) {
            ListNode fastNext = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            fast = fastNext;
            slow = slow.next.next;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
