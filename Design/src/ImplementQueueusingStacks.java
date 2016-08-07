import java.util.Stack;

/**
 * Created by thanksgiving on 1/6/16.
 */
public class ImplementQueueusingStacks {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        queue.push(3);
        queue.pop();
        System.out.println(queue.peek());
        queue.pop();
        queue.pop();
        queue.push(4);
        System.out.println(queue.peek());
    }
}

/**
 * peek 和 pop时将元素从stack转移到rev
 * push时反过来
 */
class MyQueue {
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> stackRev = new Stack<Integer>();

    public void push(int x) {
        while (!stackRev.isEmpty()) {
            stack.push(stackRev.pop());
        }
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (this.empty()) return;
        while (!stack.isEmpty()) {
            stackRev.push(stack.pop());
        }
        stackRev.pop();
    }

    // Get the front element.
    public int peek() {
        if (this.empty()) return 0;
        while (!stack.isEmpty()) {
            stackRev.push(stack.pop());
        }
        return stackRev.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stackRev.isEmpty() && stack.isEmpty();
    }
}