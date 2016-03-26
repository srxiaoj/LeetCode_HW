/**
 * Created by thanksgiving on 2/25/16.
 */
public class ConvertSortedListtoBST {
    public static void main(String[] args) {
        int[] a = {1, 2};
        ListNode test = ListNode.create(a);
        ConvertSortedListtoBST obj = new ConvertSortedListtoBST();
        TreeNode res = obj.sortedListToBST(test);
        System.out.println(res.val);
        System.out.println(res.right.val);
//        System.out.println(res.left.val);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return helper(head);
    }

    private TreeNode helper(ListNode node) {
        if (node == null) return null;
        if (node.next == null) return new TreeNode(node.val);
        ListNode pre = node;
        ListNode slow = node;
        ListNode fast = node;
        while (fast.next != null && fast.next.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        pre.next = null;
        ListNode first = node;
        TreeNode root = new TreeNode(slow.val);
        // if slow is the first element, then root.next = null
        if (slow == node) {
            root.left = null;
        } else {
            root.left = helper(first);
        }
        root.right = helper(second);
        return root;
    }

    private class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode (int a) {
            this.val = a;
        }
    }
}
