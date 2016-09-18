public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    
    public static void printListNode(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        System.out.println("print the linked list");
        while (head != null) {
            sb.append(head.val).append("->");
            head = head.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb.toString());
    }

    public static ListNode create(int[] nums) {
        ListNode res = new ListNode(0);
        ListNode copy = res;
        int n = nums.length;
        int i = 0;
        while (i < n) {
            copy.next = new ListNode(nums[i]);
            copy = copy.next;
            i++;
        }
        copy.next = null;
        return res.next;
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null, next = head;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public String toString() {
        ListNode copy = new ListNode(val);
        copy.next = next;
        return listNodeToStringHelper(copy);
    }

    public static String listNodeToStringHelper(ListNode head) {
        if (head == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append("->");
            head = head.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}