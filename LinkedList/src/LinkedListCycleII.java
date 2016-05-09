/**
 * Created by thanksgiving on 2/25/16.
 */
public class LinkedListCycleII {
    public static void main(String[] args) {
        LinkedListCycleII obj = new LinkedListCycleII();
        int[] a = {1};
        ListNode l1 = ListNode.create(a);
        int[] b = {2, 3, 4};
        ListNode l2 = ListNode.create(b);
        ListNode copy = l2;
        l1.next = l2;
        ListNode pre = copy;
        while (copy != null) {
            pre = copy;
            copy = copy.next;
        }

        pre.next = l1;
        System.out.println(obj.detectCycle(l1).val);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode cur = head;
        ListNode slow = head;
        ListNode fast = head;
        while (cur != null) {
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (fast == cur || slow == cur) {
                    return cur;
                }
                if (fast == null || fast.next == null) {
                    return null;
                }
                if (slow == fast) {
                    break;
                }
            }
            cur = cur.next;
        }
        return null;
    }
}
