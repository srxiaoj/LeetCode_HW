/**
 * Created by thanksgiving on 12/25/15.
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        MergeTwoSortedLists obj = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(7);
        l1.next.next.next = new ListNode(15);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(7);
        l2.next.next.next = new ListNode(9);
        ListNode res = obj.mergeTwoLists(l1, l2);
        ListNode.printListNode(res);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode newNode = new ListNode(0);
        ListNode result = newNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                newNode.next = l1;
                l1 = l1.next;
            } else //l1.val > l2.val
            {
                newNode.next = l2;
                l2 = l2.next;
            }
            newNode = newNode.next;
        }
        //take care of the residue list
        if (l1 != null) {
            newNode.next = l1;
        } else if (l2 != null) {
            newNode.next = l2;
        }
        return result.next;
    }
}
