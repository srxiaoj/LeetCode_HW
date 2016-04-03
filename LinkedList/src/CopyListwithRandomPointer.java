/**
 * Created by thanksgiving on 3/29/16.
 */
public class CopyListwithRandomPointer {

    private static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) {
            this.label = x;
        }
        RandomListNode(int x, RandomListNode aRandom) {
            this.label = x;
            this.random = aRandom;
        }
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.random = null;

        RandomListNode result = copyRandomList(head);
        System.out.println(head.next.label);
        System.out.println(head.next.random);
        System.out.println(result.next.label);
        System.out.println(result.next.random);
    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        // copy the whole list as A->A'->B->B'
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode nxt = cur.next;
            RandomListNode copy = new RandomListNode(cur.label);
            cur.next = copy;
            copy.next = nxt;
            cur = nxt;
        }

        // repoint random pointer
        cur = head;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        // remove original pointer, restore original list
        cur = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copy, copyCur = dummy;
        while (cur != null) {
            RandomListNode nxt = cur.next;


            copy = cur.next;
            copyCur.next = copy;
            copyCur = copy;


            cur.next = nxt;
            cur = cur.next;
        }
        return dummy.next;
    }
}
