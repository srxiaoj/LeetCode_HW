import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by thanksgiving on 8/28/16.
 */
public class NestedListWeightSum {
    public static void main(String[] args) {

    }

    public int depthSum(List<NestedInteger> nestedList) {
        Stack<Iterator<NestedInteger>> stack = new Stack<>();
        stack.add(nestedList.iterator());
        int res = 0;
        while (!stack.isEmpty()) {
            NestedInteger next;
            if (!stack.peek().hasNext()) {
                stack.pop();
            } else if ((next = stack.peek().next()).isInteger()) {
                System.out.println(stack.size() + " " + next.getInteger());
                res += stack.size() * next.getInteger();
            } else {
                stack.push(next.getList().iterator());
            }
        }
        return res;

      /*  Stack<Iterator<NestedInteger>> stack = new Stack<>();
        if (nestedList == null || nestedList.size() == 0) return 0;
        stack.add(nestedList.iterator());

        int level = 1;
        int res = 0;
        while (!stack.isEmpty()) {
            Iterator<NestedInteger> it = stack.peek();
            NestedInteger next = null;
            if (!it.hasNext()) {
                stack.pop();
                level--;
            } else {
                if ((next = it.next()).isInteger()) {
                    System.out.println(next.getInteger());
                    res += (int) next.getInteger() * level;
                } else {
                    level++;
                    stack.add(next.getList().iterator());
                }

            }
            System.out.println("level " + level);
        }
        return res;*/
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
