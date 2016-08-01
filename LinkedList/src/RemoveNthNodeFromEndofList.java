public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        ListNode head = ListNode.create(new int[]{1, 2, 3, 4, 5});
        //ListNode result = removeNthFromEnd(head, 2);

        ListNode test = ListNode.create(new int[]{1,2});
        ListNode res = removeNthFromEnd(test, 1);
        ListNode.printListNode(res);
    }

    /**
     * 先移动fast n + 1 步，然后slow 赶上至 fast == null, 要注意移除第一个元素的可能
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // one pass
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;

        /*ListNode dummy = new ListNode(0);
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
        return dummy.next;*/

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
