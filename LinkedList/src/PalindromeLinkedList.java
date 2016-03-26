
public class PalindromeLinkedList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /**
         * slow: 1->2->3->2->1 -> 1->2->3->2->1 -> 1->2->3->2->1
         * fast: 1->3->1->2->2 -> 1->3->1->2->2 -> 1->3->1->2->2
         * 
         * slow: 1->2->3->3->2->1 -> 1->2->3->3->2->1 -> 1->2->3->3->2->1
         * fast: 1->3->2->1->3->2 -> 1->3->2->1->3->2 -> 1->3->2->1->3->2
         * 
         * slow: 1->2->3->5->6->1 -> 1->2->3->5->6->1 -> 1->2->3->5->6->1
         * fast: 1->3->6->1->3->6 -> 1->3->6->1->3->6 -> 1->3->6->1->3->6
         */
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(1);
        head.printListNode(head);
//        head.printListNode(head.reverse(head));
        System.out.println(isPalindrome(head));
    }
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode copy = head;
        ListNode cur = new ListNode(0);
        ListNode curCopy = cur;
        cur.next = new ListNode(-1);
        cur = cur.next;
        ListNode reverse = null;
        while (copy != null) {
            ListNode nxt = copy.next;
            cur.val = copy.val;

            copy.next = reverse;
            reverse = copy;
            copy = nxt;

            if (copy != null) {
                cur.next = new ListNode(-1);
                cur = cur.next;
            } else {
                cur.next = null;
                cur = cur.next;
            }
        }
        cur = curCopy.next;
        ListNode.printListNode(cur);
        while (cur != null) {
            // System.out.println(cur.val);
            if (cur.val != reverse.val) {
                return false;
            }

            reverse = reverse.next;
            cur = cur.next;
        }
        return true;


        /*ListNode slow = head;
        ListNode fast = head;
        
        // find the half of the list, and reverse half of that
        // then compare it to the other half
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) { // even number list
            slow = slow.next;
        }
        // reverse the second half
        slow = reverse(slow);
        // check if first half matches second half
        ListNode firstHalf = head;
        while (slow != null) {
            if (firstHalf.val != slow.val) {
                return false;
            }
            slow = slow.next;
            firstHalf = firstHalf.next;
        }
        return true;*/
    }
    public static ListNode reverse(ListNode head) {
        ListNode pre = null, next = head;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
