/**
 * Created by thanksgiving on 1/18/16.
 */
public class OddEvenLinkedList {
    public static void main(String[] args) {
        OddEvenLinkedList obj = new OddEvenLinkedList();
        int[] a = {1,2,3,4,5,6,7};
        ListNode l = ListNode.create(a);
        ListNode.printListNode(l);
        ListNode res = obj.oddEvenList(l);
        ListNode.printListNode(res);
    }
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
