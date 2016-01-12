
public class ReverseLinkedList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode a = new ListNode(9);
        a.next = new ListNode(9);
        a.next.next = new ListNode(9);
        a.next.next.next = new ListNode(9);
        a.next.next.next.next = new ListNode(10);
        ListNode res = reverseList(a);
        printList(res);
    }
    public static ListNode reverseList(ListNode head) {
        /**iterate method*/
        
        ListNode pre = null;
        while(head != null){
            //tmp listnode to store the next value
            ListNode nex = head.next;
            head.next = pre;
            pre = head;
            head = nex;
        }
        /*
        //if current digit is higher than 10, then get the mod of current dig, add one to this node, if next node doesn't exist, creat new node
        ListNode start = pre;
        while (start != null) {
            if (start.val >= 10) {
                start.val = start.val%10;
                if (start.next != null) {
                    start.next.val++;
                   start = start.next;
                } else {
                    start.next = new ListNode(1);
                    start = start.next;
                }
            } else 
                start = start.next;
        }
        */
        return pre;
        
        
        /**recursive method*/
        //return reverse(head, null);
    }
    
    /**recursive method helper*/
    private static ListNode reverse(ListNode head, ListNode pre){
        if(head == null) return pre;//after the last node, just return the stored listNode pre
        ListNode nex = head.next;
        head.next = pre;
        pre = head;
        return reverse(nex, pre);
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
