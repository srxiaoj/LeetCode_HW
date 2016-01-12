import java.util.*;

/**
 * Created by thanksgiving on 12/25/15.
 */
public class MergekSortedLists {
    public static void main(String[] args) {
        MergekSortedLists obj = new MergekSortedLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(7);
        l1.next.next.next = new ListNode(15);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(11);
        l2.next.next = new ListNode(12);
        l2.next.next.next = new ListNode(13);
        l2.next.next.next.next = new ListNode(15);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(7);
        l3.next.next.next = new ListNode(9);
        ListNode l4 = new ListNode(4);
        l4.next = new ListNode(5);
        l4.next.next = new ListNode(7);
        ListNode[] lists = new ListNode[4];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;
        lists[3] = l4;
        ListNode res = obj.mergeKLists(lists);
        ListNode.printListNode(res);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<ListNode> list = new ArrayList<ListNode>(Arrays.asList(lists));
        if (list == null || list.size() == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(list.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val)
                    return -1;
                else if (o1.val == o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists)
            if (node != null)
                queue.add(node);

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;

        /*
        ArrayList<ListNode> list = new ArrayList<ListNode>(Arrays.asList(lists));
//        List<ListNode> list = Arrays.asList(lists);
        return mergeKLists(list);
        */
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        int length = lists.size();

        if (length == 0)
            return null;
        if (length == 1) {
            return lists.get(0);
        }

        int mid = (length - 1) / 2;
        ListNode l1 = mergeKLists(lists.subList(0, mid + 1));
        ListNode l2 = mergeKLists(lists.subList(mid + 1, length));

        return mergeTowLists(l1, l2);

    }

    public ListNode mergeTowLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode list = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                list.next = l1;
                l1 = l1.next;
            } else {
                list.next = l2;
                l2 = l2.next;
            }
            list = list.next;
        }

        while (l1 != null) {
            list.next = l1;
            l1 = l1.next;
            list = list.next;
        }

        while (l2 != null) {
            list.next = l2;
            l2 = l2.next;
            list = list.next;
        }

        return result.next;
    }
}
