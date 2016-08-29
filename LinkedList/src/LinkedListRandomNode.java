import java.util.Arrays;
import java.util.Random;

/**
 * Created by thanksgiving on 8/29/16.
 */
public class LinkedListRandomNode {
    public static void main(String[] args) {
        ListNode head = ListNode.create(new int[] {1, 2, 3});
        LinkedListRandomNode obj = new LinkedListRandomNode(head);
        System.out.println(obj.getRandom());
    }

    int[] array;
    Random r;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        int level = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            level++;
        }
        cur = head;
        array = new int[level];
        for (int i = 0; i < level; i++) {
            array[i] = cur.val;
            cur = cur.next;
        }
        r = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        if (array.length == 0) return -1;
        int[] copy = Arrays.copyOfRange(array, 0, array.length);
        for (int i = 1; i < copy.length; i++) {
            int next = r.nextInt(i + 1);
            swap(copy, i, next);
        }
        return copy[0];
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
