public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        ListNode head = ListNode.create(new int[]{1, 2, 3, 4, 5});
        //ListNode result = removeNthFromEnd(head, 2);

        ListNode test = ListNode.create(new int[]{1,2});
        ListNode res = removeNthFromEnd(test, 1);
        ListNode.printListNode(res);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        
        /*
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy, fast = dummy;
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
        //getLevelOfList(dummy);
        return dummy.next;
        */

        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        res.next = head;
        int level = getLevelOfList(head);
        res = dummy;
        int j = 0;
        while (j < level - n) {
            res = res.next;
            //System.out.println(res.val);
            j++;
        }
        res.next = res.next.next;
        return dummy.next;

    }

    private static int getLevelOfList(ListNode head) {
        ListNode res = head;
        int level = 0;
        while (res != null) {
            res = res.next;
            level++;
        }
        return level;
    }

}

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}
