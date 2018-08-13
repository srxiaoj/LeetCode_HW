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
        // ListNode methond1Res = obj.mergeKLists(lists);
        // ListNode.printListNode(methond1Res);

        // 方法2
        // ListNode method2Res = obj.mergeKLists(lists);
        // ListNode.printListNode(method2Res);

        // 方法3
        ListNode method3Res = obj.mergeKListsDivideAndConquer(lists);
        ListNode.printListNode(method3Res);
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
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    //  方法3 类似merge sort，每次将所有的list两两之间合并，直到所有list合并成一个。如果用迭代而非递归，则空间复杂度为O(1)。时间复杂度：
    // 2n * k/2 + 4n * k/4 + ... + (2^x)n * k/(2^x) = nk * x
    // k/(2^x) = 1 -> 2^x = k -> x = log2(k)
    // 所以时间复杂度为O(nk log(k))，与方法一相同。

    private ListNode mergeKListsDivideAndConquer(ListNode[] lists) {
        if(lists.length == 0) return null;
        int end = lists.length -1;
        while(end > 0) {
            int begin = 0;
            while(begin < end) {
                lists[begin] = mergeTwoLists(lists[begin],lists[end]);
                begin++;
                end--;
            }
        }
        return lists[0];
    }
}
