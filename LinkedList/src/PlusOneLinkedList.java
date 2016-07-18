/**
 * Created by thanksgiving on 7/17/16.
 */
public class PlusOneLinkedList {
    public static void main(String[] args) {
        ListNode head = ListNode.create(new int[]{1, 2, 3});
        ListNode.printListNode(plusOne(head));
        ListNode head2 = ListNode.create(new int[]{9, 9, 9});
        ListNode.printListNode(plusOne(head2));
    }

    public static ListNode plusOne(ListNode head) {
        if (head == null) return new ListNode(1);
        ListNode cur = reverse(head);
        ListNode reverse = cur;
        int sum = 1;
        ListNode pre = null;
        while (cur != null) {
            pre = cur;
            cur.val += sum;
            if (cur.val > 9) {
                cur.val = 0;
                sum = 1;
            } else {
                sum = 0;
                break;
            }
            cur = cur.next;

        }
        if (sum == 1) {
            pre.next = new ListNode(1);
        }
        return reverse(reverse);
    }

    private static ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
