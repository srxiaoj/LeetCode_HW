
public class AddTwoNumbers {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode a = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);
        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);
        printList(addTwoNumbers(a, b));
        
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        printList(addTwoNumbers(l1,l2));
        
        ListNode test1 = new ListNode(9);
        test1.next = new ListNode(8);
        ListNode test2 = new ListNode(1);
        printList(addTwoNumbers(test1, test2));
        
        ListNode r1 = new ListNode(8);
        r1.next = new ListNode(9);
        r1.next.next = new ListNode(9);
        ListNode r2 = new ListNode(2);
        printList(addTwoNumbers(r1, r2));
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
        */
        
        ListNode res1 = reverseList(l1);
        ListNode res2 = reverseList(l2);
        System.out.println("Reversed List contents: ");
        printList(res1);
        printList(res2);
        ListNode start = new ListNode(0);
        ListNode res = start;
        int level1 = getLevelOfList(res1);
        int level2 = getLevelOfList(res2);
        int i = 0;
        //unequal length of list, parse the longer list first
        if (level1 > level2) {
            while (i < level1-level2) {
                start.next = new ListNode(res1.val);
                res1 = res1.next;
                start = start.next;
                i++;
            }
        } else {
            while (i < level2 - level1) {
                start.next = new ListNode(res2.val);
                res2 = res2.next;
                start = start.next;
                i++;
            }
        }
        //now two lists should have equal length
        while (res2 != null) {
            int tmp = res1.val + res2.val;
            start.next = new ListNode(tmp);
            res1 = res1.next;
            res2 = res2.next;
            start = start.next;
        }
        res = res.next;
        res = reverseList(res);
        return res;
        
    }
    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while(head != null){
            //tmp listnode to store the next value
            ListNode nex = head.next;
            head.next = pre;
            pre = head;
            head = nex;
        }
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
        return pre;
    }
    //get level of list
    private static int getLevelOfList(ListNode head) {
        ListNode res = head;
        int level = 0;
        while (res != null) {
            //System.out.println(res.val);
            res = res.next;
            level++;
        }
        //System.out.println("level is: " + level);
        return level;
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
