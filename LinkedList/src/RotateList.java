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
        if (head == null || k == 0) return head;
        ListNode first = head;
        ListNode second = head;
        int len = getLength(head);
        if (k > len) k = k % len;
        if (len - k == 0 || k == 0) return head;
        int t = len - k;
        int i = 1;
        while (i < t) {
            first = first.next;
            second = second.next;
            i++;
        }
        second = second.next;
        first.next = null;
        first = head;

        // rotate list
        ListNode cur = second;
        ListNode pre = second;
        while (cur != null) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = first;
        return second;
    }

    public int getLength(ListNode node) {
        ListNode copy = node;
        if (copy == null) return 0;
        int len = 0;
        while (copy != null) {
            len++;
            copy = copy.next;
        }
        return len;
    }

    /*public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int height = height(head);
        if (k >= height) k = k % height;
        int len = height - k;
        ListNode first = head, second = head;
        ListNode firstCopy = first;
        int interator = 0;
        while (interator < len - 1) {
            second = second.next;
            first = first.next;
            interator++;
        }
        ListNode secondCopy = second;
        while (interator < height(head) - 1) {
            secondCopy = secondCopy.next;
            interator++;
        }
        secondCopy.next = firstCopy;
        second = second.next;
        first.next = null;
        return second;
    }
    private int height(ListNode head) {
        ListNode copy = head;
        int count = 0;
        while (copy != null) {
            copy = copy.next;
            count++;
        }
        return count;
    }*/
}
