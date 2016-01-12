public class DeleteNodeinaLinkedList {
    public static void main(String[] args) {
        ListNode test = new ListNode (1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(4);
        System.out.println(test.next.val);
    }
    public void deleteNode(ListNode node){
        if (node == null) return;
        node.val = node.next.val;//replace the value want to delete with the next val
        node.next = node.next.next;//relink the next to the next.next
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode (int x) {
        val = x;
    }
}