/**
 * Created by thanksgiving on 2/25/16.
 */
public class ConvertSortedListtoBST {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
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

    /**
     * 找到中点为root，需要注意如果slow == root，则左边可能为null，需要单独判断一下
     */
    private TreeNode helper(ListNode node) {
        if (node == null) return null;
        if (node.next == null) return new TreeNode(node.val);

        ListNode slow = node;
        ListNode fast = node.next;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        ListNode second = slow.next;
        if (pre != null) {
            pre.next = null;
        }

        if (pre == null) {
            root.left = null;
        } else {
            root.left = helper(node);
        }
        root.right = helper(second);
        return root;
    }

    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int a) {
            this.val = a;
        }
    }
}
