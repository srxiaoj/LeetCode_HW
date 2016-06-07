import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {
    private class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
        public String toString() { return String.valueOf(val); }
    }
    private class DoublyLinkedList {
        ListNode head;
        ListNode tail;
        public DoublyLinkedList() {
            head = null;
            tail = null;
        }

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
        // move node to the head of list
        public void promote(ListNode node) {
            if (node.prev == null) {
                return;
            }
            node.prev.next = node.next;
            if (node == tail) {
                tail.prev.next = null;
                tail = tail.prev;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            addFirst(node);
        }
    }
    private Map<Integer, ListNode> map;
    private DoublyLinkedList list;
    int capacity;
    public LRUCache2(int capacity) {
        this.map = new HashMap<>();
        this.list = new DoublyLinkedList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            ListNode node = map.get(key);
            list.promote(node);
            return node.val;
        }
    }

    public void set(int key, int value) {
        ListNode node = new ListNode(key, value);
        if (!map.containsKey(key)) {
            if (map.size() >= capacity) {
                ListNode removed = list.removeLast();
                map.remove(removed.key);
            }
            list.addFirst(node);
            map.put(key, node);
        } else {
            ListNode exist = map.get(key);
            exist.val = value;
            list.promote(exist);
            map.put(key, exist);
        }
    }

    public String toString() { return map.toString(); }

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
        System.out.println(obj.map);
    }
}