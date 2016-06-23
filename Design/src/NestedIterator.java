import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by thanksgiving on 6/21/16.
 */
public class NestedIterator implements Iterator<Integer> {
    public static void main(String[] args) {
        List<NestedInteger> nestedList = new ArrayList<>();
        NestedIterator i = new NestedIterator(nestedList);
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    NestedInteger nextInt;
    Stack<Iterator<NestedInteger>> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<Iterator<NestedInteger>>();
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        if (nextInt != null) {
            return nextInt.getInteger();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (!stack.peek().hasNext()) {
                stack.pop();
            } else if ((nextInt = stack.peek().next()).isInteger()) {
                return true;
            } else {
                stack.push(nextInt.getList().iterator());
            }
        }
        return false;
    }

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();
        // @return the single integer that this NestedInteger holds, if it holds a single integer
        public Integer getInteger();
        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
