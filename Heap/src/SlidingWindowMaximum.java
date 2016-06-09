import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by thanksgiving on 6/9/16.
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
//        int[] a = {1, -1};
        int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
        ArrayList<Integer> res = obj.maxSlidingWindow(a, 3);
        System.out.println(res);
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
            deque.offer(cur);
            // 如果被移除window的那个数是当前最大数，那么deque.pollFirst()
            if (i > k && deque.getFirst() == nums[i - k - 1])
                deque.pollFirst();
            if (i >= k) {
                ans.add(deque.getFirst());
            }
        }
        return ans;
    }
}
