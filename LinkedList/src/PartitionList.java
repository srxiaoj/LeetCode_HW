
public class PartitionList {
    public static void main(String[] args) {
        PartitionList obj = new PartitionList();
        int[] a = {2, 1};
        ListNode test = ListNode.create(a);
        ListNode.printListNode(obj.partition(test, 2));
    }

    /**
     * 找到第一个比 x 大的node，然后进行swap
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy.next;
        ListNode pre = dummy;
        while (cur != null && cur.val < x) {
            pre = cur;
            cur = cur.next;
        }
        if (cur == null) return dummy.next;
        ListNode pivot = cur;
        ListNode preCur = cur;
        while (cur != null) {
            if (cur.val >= x) {
                preCur = cur;
                cur = cur.next;
            } else {
                ListNode nxt = cur.next;
                preCur.next = nxt;
                cur.next = pivot;
                pre.next = cur;
                pre = pre.next;
                cur = nxt;
            }
        }
        return dummy.next;
    }
}
