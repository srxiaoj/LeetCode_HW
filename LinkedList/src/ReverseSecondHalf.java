/**
 * Created by thanksgiving on 10/9/16.
 */
public class ReverseSecondHalf {
    public static void main(String[] args) {
        ListNode head = ListNode.create(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        ListNode.printListNode(reverseSecondHalfList(head));
    }

    public static ListNode reverseSecondHalfList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pre = slow.next;
        ListNode cur = pre.next;
        while (cur != null) {
            pre.next = cur.next;
            cur.next = slow.next;
            slow.next = cur;
            cur = pre.next;
        }
        return head;
    }
}
