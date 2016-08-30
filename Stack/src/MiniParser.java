import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by thanksgiving on 8/29/16.
 */
public class MiniParser {
    public static void main(String[] args) {
        NestedInteger a = new NestedInteger();
        NestedInteger b = new NestedInteger(123);
        NestedInteger c = new NestedInteger();
        NestedInteger d = new NestedInteger(456);
        c.add(d);
        a.add(b);
        a.add(c);
//        System.out.println(a);

        System.out.println(deserialize("[123,[456]]"));
        System.out.println(deserialize("324"));
        System.out.println(deserialize("[123,[456],789]"));
        System.out.println(deserialize("[-1,-2]"));
    }

    public static NestedInteger deserialize(String s) {
        Stack<NestedInteger> stack = new Stack<>();
        if (!s.contains("[")) {
            NestedInteger ni = new NestedInteger(Integer.parseInt(s));
            return ni;
        }

        int n = s.length();
        int i = 0;
        int num = 0;
        int sign = 1;
        boolean hasNum = false;
        while (i < n) {
            char c = s.charAt(i);

            if (c == '-') {
                sign = -1;
            } else if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
                hasNum = true;
            }

            if (c == ',') {
                NestedInteger inner = stack.peek();
                if (hasNum) {
                    NestedInteger numNest = new NestedInteger(sign * num);
                    inner.add(numNest);
                }
                num = 0;
                sign = 1;
                hasNum = false;
                i++;
                continue;
            } else if (c == ']' || i == n - 1) {
                NestedInteger inner = stack.pop();
                if (hasNum) {
                    NestedInteger numNest = new NestedInteger(sign * num);
                    inner.add(numNest);
                }
                if (stack.isEmpty()) return inner;
                NestedInteger outer = stack.peek();
                outer.add(inner);
                num = 0;
                sign = 1;
                hasNum = false;
            } else if (c == '[' || i == 0) {
                if (hasNum) {
                    NestedInteger numNest = new NestedInteger(sign * num);
                    if (!stack.isEmpty()) {
                        stack.peek().add(numNest);
                        num = 0;
                        sign = 1;
                        hasNum = false;
                    }
                }
                stack.add(new NestedInteger());
            }
            i++;
        }

        return null;


       /* if (!s.contains("[")) return new NestedInteger(Integer.valueOf(s));

        Stack<NestedInteger> stack = new Stack<>();
        stack.push(new NestedInteger());        // Create outmost one, so iterate string [1,len-1]

        NestedInteger cur = null;
        for (int i = 0, sign = 1; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            if (c == '[') {                     // '[': New list linked with stack top
                NestedInteger list = new NestedInteger();
                if (!stack.isEmpty()) {
                    stack.peek().add(list);
                }
                stack.push(list);
            } else if (c == '-') {
                sign = -1;
            } else if ('0' <= c && c <= '9') {  // '0~9': Update cur number
                if (cur == null) {
                    stack.peek().add(cur = new NestedInteger(0));
                }
                cur.setInteger(cur.getInteger() * 10 + sign * (c - '0'));
            } else {                            // ',' or ']': number and list ends
                if (c == ']') {
                    stack.pop();
                }
                cur = null;
                sign = 1;
            }
        }
        return stack.pop();*/
    }

    public static class NestedInteger {
        List<NestedInteger> list;
        Integer value = null;

        // Constructor initializes an empty nested list.
        public NestedInteger() {
            this.list = new ArrayList<>();
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            this.value = value;
            this.list = new ArrayList<>();
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer// Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return value;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            this.value = value;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            list.add(ni);
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return list;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (value != null) {
                return "" + value;
            } else {
                for (NestedInteger l : list) {
                    sb.append("[" + l.toString() + "]");
//                    sb.append(l.toString());
                }
                return sb.toString();
            }

        }
    }
}
