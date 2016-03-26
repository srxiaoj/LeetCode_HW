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

//    public void reorderList(ListNode head) {
//        if (head == null || head.next == null) return;
//        ListNode fast = head.next;
//        ListNode slow = head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        //reverse the second half
//        ListNode cur = slow.next;
//        ListNode tail1 = slow.next;
//        ListNode next = cur.next;
//        ListNode pre = null;
//        while (cur != null) {
//            next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        //make the tail of first half as null
//        slow.next = null;
//        //merge two half lists
//        ListNode first = head;
//        ListNode second = pre;
//        ListNode firstNext = first.next;
//        ListNode secondNext = second.next;
//        while (first != null && second != null) {
//            firstNext = first.next;
//            secondNext = second.next;
//            first.next = second;
//            second.next = firstNext;
//            first = firstNext;
//            second = secondNext;
//        }

        /*
        // method 3
        if(head == null || head.next == null)
            return;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //reverse the second half
        ListNode p1 = slow.next;
        ListNode p2 = p1.next;
        ListNode temp = null;
        ListNode tail = p1;
        while(p2 != null){
            temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        tail.next = null;
        slow.next = null;

        //merge the first half and reversed second half
        ListNode curr = head;
        while(curr != null && p1 != null){
            temp = p1.next;
            p1.next = curr.next;
            curr.next = p1;
            curr = curr.next.next;
            p1 = temp;
        }
        */
//    }


//    private void swap(ListNode preA, ListNode a, ListNode b) {
//        a.next = b.next;
//        b.next = a;
//        preA.next = b;
//    }

}
