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
        RandomListNode n = head;
        while (n != null) {
            RandomListNode n2 = new RandomListNode(n.label);
            RandomListNode tmp = n.next;
            n.next = n2;
            n2.next = tmp;
            n = tmp;
        }

        n = head;
        while (n != null) {
            RandomListNode n2 = n.next;
            if (n.random != null)
                n2.random = n.random.next;
            else
                n2.random = null;
            n = n.next.next;
        }

        //detach list
        RandomListNode n2 = head.next;
        n = head;
        RandomListNode head2 = head.next;
        while (n2 != null && n != null) {
            n.next = n.next.next;
            if (n2.next == null) {
                break;
            }
            n2.next = n2.next.next;

            n2 = n2.next;
            n = n.next;
        }
        return head2;
    }

    private class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) {
            this.label = x;
        }
    }

    ;
}
