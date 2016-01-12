import java.util.ArrayDeque;
import java.util.Deque;

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
    private Deque<Integer> queue = new ArrayDeque<>();
    private Deque<Integer> copy = new ArrayDeque<>();
    // Push element x onto stack.
    public void push(int x) {
        queue.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while (!queue.isEmpty()) {
            copy.offer(queue.poll());
        }
        copy.pollLast();
        while (!copy.isEmpty()) {
            queue.offer(copy.poll());
        }
    }

    // Get the top element.
    public int top() {
        while (!queue.isEmpty()) {
            copy.offer(queue.poll());
        }
        int tmp = copy.getLast();
        while (!copy.isEmpty()) {
            queue.offer(copy.poll());
        }
        return tmp;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}