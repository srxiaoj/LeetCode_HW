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
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow;
        pre.next = null;
        ListNode first = head;
        ListNode dummy = new ListNode(0);
        ListNode copy = dummy;
        second = reverse(second);
        while (first != null) {
            copy.next = first;
            first = first.next;
            copy.next.next = second;
            copy = copy.next.next;
            second = second.next;
        }
        head = dummy.next;
    }

    private ListNode reverse(ListNode node) {
        ListNode cur = node;
        ListNode pre = null;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
