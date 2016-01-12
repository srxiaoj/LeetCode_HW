public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    
    public void printListNode(ListNode head) {
        StringBuilder sb = new StringBuilder();
        System.out.println("print the linked list");
        while (head != null) {
            sb.append(head.val).append("->");
//            System.out.print(root.val + "->");
            head = head.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb.toString());
    }
    
    public ListNode reverse(ListNode head) {
        ListNode pre = null, next = head;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}