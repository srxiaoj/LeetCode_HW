
public class ReverseLinkedListII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printList(reverseBetween(head, 1, 5));
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res = new ListNode(0);
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
        return res.next;
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