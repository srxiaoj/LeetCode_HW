import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by thanksgiving on 6/9/16.
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
//        int[] a = {1, -1};
//        int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] a = {-7, -8, 7, 5, 7, 1, 6, 0};
        System.out.println(obj.maxSlidingWindow(a, 3));
        // printArray(obj.maxSlidingWindow2(a, 4));
    }

    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        int i = 0;

        for (int cur : nums) {
            i++;
            while ((!deque.isEmpty() && cur > deque.getLast())) {
                deque.pollLast();
            }
            deque.addLast(cur);
            // 如果被移除window的那个数是当前最大数，那么deque.pollFirst()
            if (i > k && deque.getFirst() == nums[i - k - 1])
                deque.pollFirst();
            if (i >= k) {
                ans.add(deque.getFirst());
            }
            System.out.println(deque);
        }
        return ans;
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        if (nums == null || n == 0) return res;

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                if (deque.peekFirst() == nums[i - k]) {
                    deque.pollFirst();
                }
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
            if (i >= k - 1) {
                res[i - k + 1] = deque.peek();
            }
            System.out.println(deque);
        }
        return res;
    }

    //print array
    public static void printArray(int[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }
}
