import java.util.Stack;

/**
 * Created by thanksgiving on 8/6/16.
 */
public class LargestRectangleinHistogram {
    public static void main(String[] args) {
//        System.out.println(largestRectangleArea(new int[]{6, 2, 5, 4, 5, 1, 6}));
//        System.out.println(largestRectangleArea(new int[]{0, 2, 0}));
        System.out.println(largestRectangleArea(new int[]{1, 2, 3, 4, 5}));
//        System.out.println(largestRectangleArea(new int[]{1}));
//        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    public static int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int cur = (i == len) ? 0 : height[i];
            if (stack.isEmpty() || cur >= height[stack.peek()]) {
                stack.push(i);
            } else {
                int last = stack.pop();
                while (!stack.isEmpty() && height[stack.peek()] >= cur) {
                    maxArea = Math.max(maxArea, height[last] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                    last = stack.pop();
                }
                maxArea = Math.max(maxArea, height[last] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                stack.add(i);
            }
        }
        return maxArea;
      /*  int len = height.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int cur = (i == len ? 0 : height[i]);
            if (stack.isEmpty() || cur >= height[stack.peek()]) {
                stack.push(i);
            } else {
                int last = stack.pop();
                maxArea = Math.max(maxArea, height[last] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                i--;
            }
        }
        return maxArea;*/
    }
}
