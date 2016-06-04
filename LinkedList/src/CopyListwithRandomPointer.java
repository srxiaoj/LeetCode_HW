/**
 * Created by thanksgiving on 2/28/16.
 */
public class CopyListwithRandomPointer {
    public static void main(String[] args) {

    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            RandomListNode nxt = cur.next;
            cur.next = clone;
            clone.next = nxt;
            cur = nxt;
        }

        cur = head;
        while (cur != null) {
            RandomListNode nxt = cur.next;
            if (cur.random != null)
                nxt.random = cur.random.next;
            else
                nxt.random = null;
            cur = cur.next.next;
        }

        //detach list
        cur = head;
        RandomListNode res = head.next;
        RandomListNode resCur = head.next;
        while (cur != null) {
            cur.next = cur.next.next;
            if (resCur.next == null) {
                break;
            }
            resCur.next = resCur.next.next;

            resCur = resCur.next;
            cur = cur.next;
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
