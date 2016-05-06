import java.util.HashMap;
import java.util.Map;

class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;
    public ListNode(int k, int v) { key = k; val = v; }
    public String toString() { return String.valueOf(val); }
}

class DoublyLinkedList {
    private ListNode head = null;
    private ListNode tail = null;

    public void addFirst(ListNode node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        head.prev = node;
        node.next = head;
        node.prev = null;
        head = node;
    }

    public ListNode removeLast() {
        ListNode node = tail;
        if (tail.prev != null) {
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            head = null;
            tail = null;
        }
        return node;
    }

    /**
     * move current node to head position
     */
    public void promote(ListNode node) {
        if (node.prev == null) {
            return;
        }
        node.prev.next = node.next;
        if (node.next == null) {
            tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }

        head.prev = node;
        node.next = head;
        node.prev = null;
        head = node;
    }
}

public class LRUCache2 {
    private final Map<Integer, ListNode> cachedMap = new HashMap<>();
    private final DoublyLinkedList cachedList = new DoublyLinkedList();
    private final int capacity;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cachedMap.containsKey(key)) {
            return -1;
        }
        ListNode targetNode = cachedMap.get(key);
        cachedList.promote(targetNode);
        return targetNode.val;
    }

    public void set(int key, int value) {
        ListNode targetNode;
        if (cachedMap.containsKey(key)) {
            targetNode = cachedMap.get(key);
            targetNode.val = value;
            cachedList.promote(targetNode);
            return;
        }

        if (cachedMap.size() == capacity) {
            ListNode node = cachedList.removeLast();
            cachedMap.remove(node.key);
        }

        targetNode = new ListNode(key, value);
        cachedList.addFirst(targetNode);
        cachedMap.put(targetNode.key, targetNode);
    }

    public String toString() { return cachedMap.toString(); }

    public static void main(String[] args) {
        LRUCache2 obj = new LRUCache2(5);
        obj.set(2, 1);
        obj.get(2);
        obj.set(3, 2);
        obj.get(2);
        obj.get(3);
        obj.set(1, 10);
        obj.set(5, 3);
        obj.set(7, 0);
        obj.get(1);
        obj.set(10, 20);
        System.out.println(obj.cachedMap);
    }
}