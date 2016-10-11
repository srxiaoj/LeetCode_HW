import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Administrator on 2016/10/10.
 */
public class SlidingWindowMinimum {
    public static void main(String[] args) {
        int[] a = {4, 2, 12, 11, -5};
        printArray(minSlidingWindow(a, 2));
    }

    public static int[] minSlidingWindow(int[] nums, int k) {
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
            while (!deque.isEmpty() && deque.peekLast() > nums[i]) {
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
