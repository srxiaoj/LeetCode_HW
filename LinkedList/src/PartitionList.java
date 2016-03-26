/**
 * Created by thanksgiving on 2/17/16.
 */
public class PartitionList {
    public static void main(String[] args) {
        PartitionList obj = new PartitionList();
        int[] a = {2, 1};
        ListNode test = ListNode.create(a);
        ListNode.printListNode(obj.partition(test, 2));
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode smallInd = dummy;
        ListNode largeInd = dummy;
        ListNode cur = head.next;
        // find the first small index and large index
        if (head.val < x) {
            smallInd = head;
            while (cur != null && cur.val < x) {
                smallInd = cur;
                cur = cur.next;
            }
            if (cur == null) return head;
            largeInd = cur;
            cur = cur.next;
        } else {
            largeInd = head;
        }

        while (cur != null) {
            ListNode nxt = cur.next;
            if (cur.val < x) {
                largeInd.next = nxt;
                cur.next = smallInd.next;
                smallInd.next = cur;
                smallInd = cur;
            } else {
                largeInd = largeInd.next;
            }
            cur = nxt;
        }
        return dummy.next;
    }
}
