
public class SortList {
    public static void main(String[] args) {
        ListNode a = ListNode.create(new int[]{9, 4, 6, 0, 10, 18});
        printList(a);
        ListNode res = sortList(a);
        printList(res);
    }

    /**
     * divide and conquer, 找到first half, second half, 分别sort, 然后再merge
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

          // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        // step 3. merge l1 and l2
        return merge(l1, l2);
    }
    /*returns a ListNode instead of void return in normal mergesort*/
    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode result = res;
        while (l1 != null & l2 != null) {
            if (l1.val <= l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
            if (l1 != null)
                res.next = l1;

            if (l2 != null)
                res.next = l2;
        }
        return result.next;
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
