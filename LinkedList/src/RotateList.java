/**
 * Created by thanksgiving on 12/27/15.
 */
public class RotateList {
    public static void main(String[] args) {
        int[] array = {1, 2};
        ListNode test = ListNode.create(array);
        ListNode.printListNode(test);
        RotateList obj = new RotateList();
        ListNode res = obj.rotateRight(test, 2);
        ListNode.printListNode(res);
    }
    public ListNode rotateRight(ListNode head, int k) {
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
    }
}
