/**
 * Created by thanksgiving on 9/17/16.
 */
public class ReversePrintListNode {
    public static void main(String[] args) {
        ListNode head = ListNode.create(new int[]{1, 2, 3, 4});
        printList(head);
    }

    /**
     * 实现linkedList，
     * follow up:  不用额外空间逆向打印linkedlist, 要求［1. no extra space,  2. can not reverse it］, 我用了two pointer和recursion来做了［都要写代码念给他］
     */
    public static void printList(ListNode head) {
        if (head == null) return;
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (cur.next != null) {
            pre = cur;
            cur = cur.next;
        }
        System.out.println(cur.val);
        pre.next = null;
        printList(dummy.next);
    }
}
