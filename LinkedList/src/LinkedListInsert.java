/**
 * Created by Administrator on 2016/10/10.
 */
public class LinkedListInsert {
    public static void main(String[] args) {

    }

    public static ListNode insert(ListNode head, int val) {
        if (head == null) {
            ListNode newNode = new ListNode(val);
            newNode.next = newNode;
            return newNode;
        }

        ListNode cur = head;
        do {
            if (cur.val < val && cur.next.val > val) break;
            if (cur.val > cur.next.val && (cur.val < val || cur.next.val > val)) break;
            cur = cur.next;
        } while (cur != head);
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;
        return newNode;
    }
}
