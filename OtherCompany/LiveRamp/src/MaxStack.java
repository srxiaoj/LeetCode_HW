import java.util.Stack;

public class MaxStack {
    private Stack<Integer> stk = new Stack();
    private Stack<Integer> maxStack = new Stack();

    public void push(int x) {
        if (maxStack.empty() == true || x >= maxStack.peek()) {
            maxStack.push(x);
        } //if the input element is greater than or equal to maxStack.peek, then // put it into maxStack
        stk.push(x);
    }

    public void pop() {
        int result = stk.pop();
        if (result == maxStack.peek()) {
            maxStack.pop();
        }

    }

    public int top() {
        return stk.peek();
    }

    public int getMax() {
        return maxStack.peek();
    }
}