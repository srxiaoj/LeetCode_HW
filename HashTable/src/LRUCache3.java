import java.util.Map;
import java.util.HashMap;

public class LRUCache3 {

  class DLinkedNode {

    String key;
    int value;
    DLinkedNode pre;
    DLinkedNode next;
  }

  private Map<String, DLinkedNode> cache = new HashMap<>();
  private int count;
  private int capacity;
  private DLinkedNode head, tail;

  public LRUCache3(int capacity) {
    this.count = 0;
    this.capacity = capacity;

    head = new DLinkedNode();
    head.pre = null;

    tail = new DLinkedNode();
    tail.next = null;

    head.next = tail;
    tail.pre = head;
  }

  public int get(String key) {

    DLinkedNode node = cache.get(key);
    if (node == null) {
      return -1; // should raise exception here.
    }

    // move the accessed node to the head;
    this.moveToHead(node);

    return node.value;
  }


  public void set(String key, int value) {
    DLinkedNode node = cache.get(key);

    if (node == null) {

      DLinkedNode newNode = new DLinkedNode();
      newNode.key = key;
      newNode.value = value;

      this.cache.put(key, newNode);
      this.addNode(newNode);

      ++count;

      if (count > capacity) {
        // pop the tail
        DLinkedNode tail = this.popTail();
        this.cache.remove(tail.key);
        --count;
      }
    } else {
      // update the value.
      node.value = value;
      this.moveToHead(node);
    }
  }

  /**
   * Always add the new node right after head;
   */
  private void addNode(DLinkedNode node) {
    node.pre = head;
    node.next = head.next;

    head.next.pre = node;
    head.next = node;
  }

  /**
   * Remove an existing node from the linked list.
   */
  private void removeNode(DLinkedNode node) {
    DLinkedNode pre = node.pre;
    DLinkedNode next = node.next;

    pre.next = next;
    next.pre = pre;
  }

  /**
   * Move certain node in between to the head.
   */
  private void moveToHead(DLinkedNode node) {
    this.removeNode(node);
    this.addNode(node);
  }

  // pop the current tail.
  private DLinkedNode popTail() {
    DLinkedNode res = tail.pre;
    this.removeNode(res);
    return res;
  }
}
