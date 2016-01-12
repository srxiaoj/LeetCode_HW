import java.util.Stack;

/**
 * Created by thanksgiving on 12/29/15.
 */
public class LargestRectangleinHistogram {
    public static void main(String[] args) {
        LargestRectangleinHistogram obj = new LargestRectangleinHistogram();
        int[] test = {2, 1, 5, 6, 2, 3, 2, 2, 4};
        System.out.println(obj.largestRectangleArea(test));
    }

    public int largestRectangleArea(int[] height) {
        if (height == null) return 0;//Should throw exception
        if (height.length == 0) return 0;

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            //Start calculate the max value
            while (stack.peek() > -1)
                if (height[stack.peek()] > height[i]) {
                    int top = stack.pop();
                    max = Math.max(max, height[top] * (i - 1 - stack.peek()));
                } else break;

            stack.push(i);
        }
        while (stack.peek() != -1) {
            int top = stack.pop();
            max = Math.max(max, height[top] * (height.length - 1 - stack.peek()));
        }
        return max;
    }
}
