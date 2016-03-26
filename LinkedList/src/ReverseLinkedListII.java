
public class ReverseLinkedListII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode.printListNode(reverseBetween(head, 1, 2));
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int i = 0;
        ListNode cur = dummy;
        ListNode firstPre = dummy;
        while (i < m) {
            firstPre = cur;
            cur = cur.next;
            i++;
        }
        ListNode first = cur;

        ListNode secondPre = cur;
        while (i < n) {
            secondPre = cur;
            cur = cur.next;
            i++;
        }
        // ListNode firstNxt = first.next;
        ListNode second = cur;
        ListNode pre = second.next;
        cur = first;
        i = 0;
        while (cur != null && i <= n - m) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
            i++;
        }
        firstPre.next = pre;
        return dummy.next;

        /*ListNode res = new ListNode(0);
        res.next = head;
        ListNode start = res;
        int i = 0;
        while (i < m-1) {
            start = start.next;
            i++;
        }
        //store the start reverse node
        ListNode startReverse = start;
        //System.out.println("at m-1");
        //printList(startReverse);
        start = start.next;
        //reverse the node
        while (i < n) {
            start = start.next;
            i++;
        }
        ListNode endReverse = start;
        //System.out.println("at n+1");
        //printList(endReverse);
        //move start back to start reverse the list
        start = startReverse.next;
        //System.out.println("at m");
        //printList(start);
        ListNode pre = endReverse;
        i = m;
        while (i <= n) {
            ListNode nxt = start.next;
            start.next = pre;
            pre = start;
            start = nxt;
            i++;
        }
        startReverse.next = pre;
        return res.next;*/
    }

    //print out list
    private static void printList(ListNode res) {
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println("");
    }
}

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}