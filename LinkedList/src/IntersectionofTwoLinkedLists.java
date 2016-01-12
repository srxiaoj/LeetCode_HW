import java.util.ArrayList;
import java.util.List;

public class IntersectionofTwoLinkedLists {
    private static List<Integer> list1 = new ArrayList<>();
    private static List<Integer> list2 = new ArrayList<>();
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /**
         *  a: 1 -> 2 -> 3 -> 5          1 -> 2 -> 3 -> 5 -> 4 -> 3 -> 5
         *  b: 4 -> 3 -> 5               4 -> 3 -> 5 -> 1 -> 2 -> 3 -> 5
         *                                                        | match point
         */
        ListNode c = new ListNode(3);
        c.next = new ListNode(5);
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = c;
        
        a.printListNode(a);
        System.out.println("");
        ListNode b = new ListNode(4);
        b.next = c;
        a.printListNode(b);
        System.out.println("");
        System.out.println("*********");
        ListNode res = getIntersectionNode(a, b);
        a.printListNode(res);
        System.out.println(list1);
        System.out.println(list2);
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        if (p1 == null || p2 == null) return null;

        while (p1 != null && p2 != null && p1 != p2) {
//            list1.add(p1.val);
//            list2.add(p2.val);
            p1 = p1.next;
            p2 = p2.next;
            
            //
            // Any time they collide or reach end together without colliding 
            // then return any one of the pointers.
            //
            if (p1 == p2) return p1;

            //
            // If one of them reaches the end earlier then reuse it 
            // by moving it to the beginning of other list.
            // Once both of them go through reassigning, 
            // they will be equidistant from the collision point.
            //
            if (p1 == null) p1 = headB;
            if (p2 == null) p2 = headA;
        }

        return p1;
    }
}
