
public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        //ListNode result = removeNthFromEnd(head, 2);
        
        ListNode test = new ListNode(1);
        //test.next = new ListNode(2);
        ListNode res = removeNthFromEnd(test, 1);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        
        /*
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;
        //getLevelOfList(slow);
        //move fast ahead so that the gap between slow and fast is n
        for (int i = 0; i < n+1; i++) {
            fast = fast.next;
        }
        //now move fast and slow at the same time, when fast reach null, the gap should still be n
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        //getLevelOfList(start);
        return start.next;
        */
        
        int level = 0;
        ListNode start = new ListNode(0);
        ListNode res = start;
        res.next = head;
        while (res != null) {
            //System.out.println(res.val);
            res = res.next;
            level++;
        }
        getLevelOfList(head);
        res = start;
        int j = 0;
        while (j < level-n-1) {
            res = res.next;
            //System.out.println(res.val);
            j++;
        }
        res.next = res.next.next;
        getLevelOfList(start.next);
        return start.next;
        
    }
    private static void getLevelOfList(ListNode head) {
        ListNode res = head;
        int level = 0;
        while (res != null) {
            System.out.println("level " + level + ": " + res.val);
            res = res.next;
            level++;
        }
        System.out.println("level is: " + level);     
    }

}

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}
