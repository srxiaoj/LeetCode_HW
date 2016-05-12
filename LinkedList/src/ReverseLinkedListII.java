
public class ReverseLinkedListII {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode.printListNode(reverseBetween(head, 1, 2));
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        int i = 0;
        ListNode firstPre = dummy;
        while (i < m) {
            firstPre = cur;
            cur = cur.next;
            i++;
        }
        ListNode first = cur;
        while (i < n) {
            cur = cur.next;
            i++;
        }
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