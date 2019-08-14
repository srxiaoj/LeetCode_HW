
public class ReverseLinkedListII {

    public static void main(String[] args) {
        ListNode head = ListNode.create(new int[]{1, 2, 3, 4, 5});
        ListNode.printListNode(reverseBetween(head, 2, 4));
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode nxt = cur.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, cur = 2, nxt = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for (int i = 0; i < n - m; i++) {
            ListNode.printListNode(dummy.next);
            cur.next = nxt.next;
            nxt.next = pre.next;
            pre.next = nxt;
            nxt = cur.next;
            ListNode.printListNode(dummy.next);
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, cur = 2, nxt = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, cur = 2, nxt = 5 (finish)

        return dummy.next;
    }
}
