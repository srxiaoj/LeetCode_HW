import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 8/30/16.
 */
public class NestedListWeightSumII {
    public static void main(String[] args) {

    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        return helper(nestedList, 0);
    }

    private int helper(List<NestedInteger> list, int prev) {
        int sum = prev;
        List<NestedInteger> part = new ArrayList<>();

        for (NestedInteger nest : list) {
            if (nest.isInteger()) {
                sum += nest.getInteger();
            } else {
                part.addAll(nest.getList());
            }
        }

        int listSum = part.isEmpty() ? 0 : helper(part, sum);

        return listSum + sum;
    }

    /*public int depthSumInverse(List<NestedInteger> nestedList) {
        Stack<Iterator<NestedInteger>> stack = new Stack<>();
        stack.add(nestedList.iterator());
        int res = 0;
        int level = 0;
        while (!stack.isEmpty()) {
            NestedInteger next;
            if (!stack.peek().hasNext()) {
                stack.pop();
            } else if ((next = stack.peek().next()).isInteger()) {

            } else {
                stack.push(next.getList().iterator());
                level = Math.max(level, stack.size());
            }
        }
        if (nestedList.size() > 0 && level == 0) {
            level = 1;
        }

        stack = new Stack<>();
        stack.add(nestedList.iterator());
        while (!stack.isEmpty()) {
            NestedInteger next;
            if (!stack.peek().hasNext()) {
                stack.pop();
            } else if ((next = stack.peek().next()).isInteger()) {
                res += (level + 1 - stack.size()) * next.getInteger();
            } else {
                stack.push(next.getList().iterator());
                level = Math.max(level, stack.size());
            }
        }

        return res;
    }*/

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
