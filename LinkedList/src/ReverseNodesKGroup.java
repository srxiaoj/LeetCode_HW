/**
 * Created by thanksgiving on 8/8/16.
 */
public class ReverseNodesKGroup {
    public static void main(String[] args) {
        ListNode head = ListNode.create(new int[] {1, 2, 3, 4, 5});
        ListNode.printListNode(reverseKGroup(head, 3));
        ListNode head2 = ListNode.create(new int[] {1, 2, 3, 4});
        ListNode.printListNode(reverseKGroup(head2, 2));
        ListNode head3 = ListNode.create(new int[] {1, 2});
        ListNode.printListNode(reverseKGroup(head3, 2));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int len = getLen(head);
        if (k > len || k == 1) return head;
        int n = len / k;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode nxt = cur.next;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k - 1; j++) {
                cur.next = nxt.next;
                nxt.next = pre.next;
                pre.next = nxt;
                nxt = cur.next;
            }
            pre = cur;
            cur = cur.next;
            if (nxt == null) break;
            nxt = cur.next;
        }
        return dummy.next;
    }

    private static int getLen(ListNode head) {
        int i = 0;
        while (head != null) {
            head = head.next;
            i++;
        }
        return i;
    }
}
