/**
 * Created by thanksgiving on 2/28/16.
 */
public class CopyListwithRandomPointer {
    public static void main(String[] args) {

    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode cur = head;
        // duplicate each node
        while (cur != null) {
            RandomListNode nxt = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = nxt;
            cur = nxt;
        }
        // copy random pointer
        cur = head;
        while (cur != null) {
            if (cur.random == null) {
                cur.next.random = null;
            } else {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // extract duplicated list and recover original list
        cur = head;
        RandomListNode res = cur.next;
        RandomListNode copy = res;
        while (cur != null) {
            cur.next = cur.next.next;
            if (copy.next == null) break;

            copy.next = copy.next.next;
            cur = cur.next;
            copy = copy.next;
        }

        return res;
    }

    private class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) {
            this.label = x;
        }
    }
}
