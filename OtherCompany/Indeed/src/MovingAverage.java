import java.util.*;

/**
 * Created by Administrator on 2016/10/23.
 */
public class MovingAverage {
    public static void main(String[] args) {

    }

    class Solution {
        Queue<int[]> queue;
        int sum;
        List<Integer> list;
        public Solution() {
            this.queue = new LinkedList<>();
            this.sum = 0;
            this.list = new ArrayList<>();
        }

        public int getNow() {
            return  (int) System.currentTimeMillis();
        }

        public void updateQueue(int curTime) {
            while (!queue.isEmpty() && curTime - queue.peek()[0] > 300) {
                int[] last = queue.poll();
                sum -= last[1];
                list.remove((Integer) last[1]);
            }
        }


        public void record(int value) {
            int curTime = getNow();
            updateQueue(curTime);
            queue.offer(new int[] {curTime, value});
            list.add(value);
            sum += value;
        }

        // get average from last 300 s
        public double getAvg() {
            if (queue.isEmpty()) return 0;
            int curTime = getNow();
            updateQueue(curTime);
            return sum * 1.0 / queue.size();
        }

        // get medium from last 300 s
        public double getMedium() {
            if (queue.isEmpty()) return 0;
            int curTime = getNow();
            updateQueue(curTime);
            return quickSelect(list);
        }

        private double quickSelect(List<Integer> list) {
            int n = list.size();
            if (n % 2 != 0) {
                return findKthLargest(list, n / 2);
            } else {
                return (findKthLargest(list, n / 2) + findKthLargest(list, n / 2 + 1)) / 2.0;
            }
        }

        private int findKthLargest(List<Integer> list, int k) {
            int l = 0, r = list.size() - 1;
            while (true) {
                int p = partition(list, l, r);
                if (p == k - 1) {
                    return list.get(p);
                } else if (p > k - 1) {
                    r = p - 1;
                } else {
                    l = p + 1;
                }
            }
        }

        private int partition(List<Integer> list, int l, int r) {
            int p = l;
            int pivot = list.get(l);
            for (int i = l + 1; i <= r; i++) {
                if (list.get(i) > pivot) {
                    p++;
                    Collections.swap(list, i, p);
                }
            }
            Collections.swap(list, l, p);
            return p;
        }
    }
}
