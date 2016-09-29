import java.util.*;

public class MergekSortedLists {
    public static void main(String[] args) {
        MergekSortedLists obj = new MergekSortedLists();
        ListNode l1 = ListNode.create(new int[]{1, 3, 7, 15});
        ListNode l2 = ListNode.create(new int[]{9, 11, 12, 13, 15});
        ListNode l3 = ListNode.create(new int[]{2, 3, 7, 9});
        ListNode l4 = ListNode.create(new int[]{4, 5, 7});
        ListNode[] lists = new ListNode[4];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;
        lists[3] = l4;
        ListNode res = obj.mergeKLists(lists);
        ListNode.printListNode(res);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // 方法1
        ArrayList<ListNode> list = new ArrayList<ListNode>(Arrays.asList(lists));
        if (list == null || list.size() == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(list.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (ListNode node : lists)
            if (node != null)
                queue.add(node);

        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;

            if (cur.next != null)
                queue.add(cur.next);
        }
        return dummy.next;

        /*
        // 方法2
        ArrayList<ListNode> list = new ArrayList<ListNode>(Arrays.asList(lists));
        return mergeKLists(list);
        */
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        int length = lists.size();
        if (length == 0) return null;
        if (length == 1) return lists.get(0);

        int mid = (length - 1) / 2;
        ListNode l1 = mergeKLists(lists.subList(0, mid + 1));
        ListNode l2 = mergeKLists(lists.subList(mid + 1, length));
        return mergeTowLists(l1, l2);
    }

    public ListNode mergeTowLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        while (l1 != null) {
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }

        while (l2 != null) {
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
