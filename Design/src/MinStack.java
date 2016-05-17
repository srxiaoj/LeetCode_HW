import java.util.Stack;

/**
 * Created by thanksgiving on 5/17/16.
 */
public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());//--> Returns -3.
        minStack.pop();
        System.out.println(minStack.top());      //--> Returns 0.
        System.out.println(minStack.getMin());   //--> Returns -2.
    }

    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    /**
     * 关键点为在update min时候每次将上一个min存入stack, 如果当前pop的等于Min,那么再把上一个Min取出来
     */
    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.peek() == min) {
            stack.pop();
            min = stack.pop();
        } else stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
