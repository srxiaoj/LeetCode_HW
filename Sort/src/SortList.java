
public class SortList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode a = new ListNode(9);
        a.next = new ListNode(4);
        a.next.next = new ListNode(6);
        a.next.next.next = new ListNode(0);
        a.next.next.next.next = new ListNode(10);
        a.next.next.next.next.next = new ListNode(18);
        printList(a);
        //ListNode res = swapList(a, 4, 5);
        ListNode res = sortList(a);
        printList(res);
    }
    public static ListNode sortList(ListNode head) {
        /*
        ListNode res = new ListNode(0);
        res.next = head;
        int level = getLevelOfList(head);
        quicksort(head, 0, level-1);
        return res.next;
        */
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
    private static void quicksort(ListNode head, int l, int r) {
        int pivot;
        if (r > l) {
            pivot = partition(head, l, r);
            //System.out.println("pivot is: " + pivot);
            quicksort(head, l, pivot-1);
            quicksort(head, pivot+1, r);
        }
    }
    private static int partition(ListNode head, int start, int end) {
        ListNode res = new ListNode(0);
        res.next = head;
        int k = 0;
        while (k < start) {
            res = res.next;
            k++;
        }
        int p = start;
        int pValue = head.val;
        for (int i = start+1; i <= end; i++) {
            if (res.val > pValue) {
                p++;
                swapList(head, i, p);
            }
            res = res.next;
        }
        swapList(head, p, start);
        return p;
    }
    //swap two node in listNode at position a and b
    private static ListNode swapList(ListNode head, int a, int b) {
        //algorithm is designed in the way a must smaller than b
        if (a > b) {
            int tmp = b;
            b = a;
            a = tmp;
        }
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode second = new ListNode(0);
        second.next = head;
        ListNode res = new ListNode(0);
        res.next = head;
        int i = 0;
        while (i < a) {
            i++;
            first = first.next;
        }
        ListNode preFirst = first;
        first = first.next;
        ListNode nexFirst = first.next;
        int j = 0;
        while (j < b) {
            j++;
            second = second.next;
        }
        ListNode preSecond = second;
        second = second.next;
        ListNode nexSecond = second.next;
        
        //swap two nodes
        if (Math.abs(a-b) == 1) {//swap adjacent elements
            first.next = nexSecond;
            second.next = first;
            preFirst.next = second;
        } else {
            first.next = nexSecond;
            preSecond.next = first;
            second.next = nexFirst;
            preFirst.next = second;
        }
        if (a == 0)//corner case
            return preFirst.next;
        return res.next;
        
    }
    //print out list
    private static void printList(ListNode res) {
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println("");
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
        System.out.println("level is: " + level);   
        return level;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}