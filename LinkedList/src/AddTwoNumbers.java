
public class AddTwoNumbers {

  public static void main(String[] args) {
    ListNode a = ListNode.create(new int[]{2, 4, 3});
    ListNode b = ListNode.create(new int[]{5, 6, 4});
    printList(addTwoNumbers(a, b));

    ListNode l1 = ListNode.create(new int[]{1});
    ListNode l2 = ListNode.create(new int[]{9, 9});
    printList(addTwoNumbers(l1, l2));

    ListNode test1 = ListNode.create(new int[]{8, 9});
    ListNode test2 = ListNode.create(new int[]{1});
    printList(addTwoNumbers(test1, test2));

    ListNode r1 = ListNode.create(new int[]{8, 9, 9});
    ListNode r2 = ListNode.create(new int[]{2});

    printList(addTwoNumbers(r1, r2));

    ListNode r3 = ListNode.create(new int[]{5, 3});
    ListNode r4 = ListNode.create(new int[]{5, 6, 4});

    printList(addTwoNumbers(r3, r4));
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    int sum = 0;
    while (l1 != null || l2 != null) {
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      cur.next = new ListNode(sum % 10);
      cur = cur.next;
      sum /= 10;
    }
    if (sum > 0) {
      cur.next = new ListNode(1);
    }
    return dummy.next;

     /* ListNode dummy = new ListNode(0);
      ListNode cur = dummy;
      int sum = 0;
      while (l1 != null && l2 != null) {
          sum += l1.val + l2.val;
          cur.next = new ListNode(sum % 10);
          sum /= 10;
          cur = cur.next;
          l1 = l1.next;
          l2 = l2.next;
      }

      while (l1 != null) {
          sum += l1.val;
          cur.next = new ListNode(sum % 10);
          sum /= 10;
          cur = cur.next;
          l1 = l1.next;
      }
      while (l2 != null) {
          sum += l2.val;
          cur.next = new ListNode(sum % 10);
          sum /= 10;
          cur = cur.next;
          l2 = l2.next;
      }

      if (sum > 0) {
          cur.next = new ListNode(1);
      }
      return dummy.next; */

  }

  //get level of list
  private static int getLevelOfList(ListNode head) {
    ListNode res = head;
    int level = 0;
    while (res != null) {
      //System.out.println(res.val);
      res = res.next;
      level++;
    }
    //System.out.println("level is: " + level);
    return level;
  }

  //print out list
  private static void printList(ListNode res) {
    while (res != null) {
      System.out.print(res.val + " ");
      res = res.next;
    }
    System.out.println("");
  }

}
