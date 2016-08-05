/**
 * Created by thanksgiving on 12/27/15.
 */
public class RotateList {
    public static void main(String[] args) {
        RotateList obj = new RotateList();

//        int[] array = {1, 2};
//        ListNode test = ListNode.create(array);
//        ListNode res = obj.rotateRight(test, 2);
//        ListNode.printListNode(res);

        int[] array2 = {1, 2, 3};
        ListNode test2 = ListNode.create(array2);
        ListNode res2 = obj.rotateRight(test2, 1);
        ListNode.printListNode(res2);

        int[] array3 = {1};
        ListNode test3 = ListNode.create(array3);
        ListNode res3 = obj.rotateRight(test3,99);
        ListNode.printListNode(res3);

        int[] array4 = {1};
        ListNode test4 = ListNode.create(array4);
        ListNode res4 = obj.rotateRight(test4,0);
        ListNode.printListNode(res4);
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int len = len(head);
        k = k % len;
        if (k == 0) return head;
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        while (i < k + 1) {
            fast = fast.next;
            i++;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode cur = slow.next;
        fast = cur;
        slow.next = null;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return fast;
    }

    private int len(ListNode node) {
        ListNode cur = node;
        int res = 0;
        while (cur != null) {
            res++;
            cur = cur.next;
        }
        return res;
    }
}
