import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by thanksgiving on 1/6/16.
 */
public class ImplementStackusingQueues {

  public static void main(String[] args) {
    MyStack stack = new MyStack();
    stack.push(1);
    stack.push(2);
    stack.pop();
    System.out.println(stack.top());
  }
}
class MyStack {

  private Queue<Integer> q1 = new LinkedList<>();
  private Queue<Integer> q2 = new LinkedList<>();
  private int top;

  /**
   * Initialize your data structure here.
   */
  public MyStack() {

  }

  /**
   * Push element x onto stack.
   */
  public void push(int x) {
    q2.add(x);
    top = x;
    while (!q1.isEmpty()) {
      q2.add(q1.remove());
    }
    q1 = q2;
    q2 = new LinkedList<>();
  }

  /**
   * Removes the element on top of the stack and returns that element.
   */
  public int pop() {
    int tmp = q1.remove();
    if (!q1.isEmpty()) {
      top = q1.peek();
    }
    return tmp;
  }

  /**
   * Get the top element.
   */
  public int top() {
    return top;
  }

  /**
   * Returns whether the stack is empty.
   */
  public boolean empty() {
    return q1.isEmpty();
  }
}
