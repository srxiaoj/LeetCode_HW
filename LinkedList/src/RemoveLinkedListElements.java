/**
 * Created by thanksgiving on 5/1/16.
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        RemoveLinkedListElements obj = new RemoveLinkedListElements();
        ListNode head = ListNode.create(new int[]{1, 1});
        ListNode.printListNode(obj.removeElements(head, 1));
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null) {
            ListNode nxt = cur.next;
            if (nxt != null) {
                while (nxt != null && nxt.val == val) {
                    nxt = nxt.next;
                }
                cur.next = nxt;
                cur = cur.next;
            } else {
                cur = nxt;
            }
        }
        return dummy.next;
    }
}
