import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 12/21/15.
 */
public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);
        ListNode head = null;
        ConvertSortedListToBinarySearchTree obj = new ConvertSortedListToBinarySearchTree();
        TreeNode res = obj.sortedListToBST(head);
        TreeNode.printNode(res);
    }

    public TreeNode sortedListToBST(ListNode head) {
//        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        ListNode copy = head;
        while (copy != null) {
            list.add(copy.val);
            copy = copy.next;
        }
        TreeNode res = listToBST(list);
        return res;
    }

    private TreeNode listToBST(List<Integer> list) {
        int len = list.size();
        if (len == 0) return null;
        TreeNode root = new TreeNode(list.get(len / 2));
        root.left = listToBST(list.subList(0, len / 2));
        root.right = listToBST(list.subList(len / 2 + 1, len));
        return root;
    }
}
