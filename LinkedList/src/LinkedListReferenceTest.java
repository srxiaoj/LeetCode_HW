/**
 * Created by thanksgiving on 2/17/16.
 */
public class LinkedListReferenceTest {
    public static void main(String[] args) {
        int[] test = {1, 2};
        ListNode testNode = ListNode.create(test);
        ListNode newNode = testNode.next.next;
        ListNode.printListNode(testNode);

        // reReference newNode to another node
        int[] test2 = {3, 4};
        ListNode testNode2 = ListNode.create(test2);
        newNode = testNode2;
        ListNode.printListNode(testNode);
        ListNode.printListNode(newNode);
    }

}
