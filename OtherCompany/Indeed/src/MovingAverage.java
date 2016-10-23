import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2016/10/23.
 */
public class MovingAverage {
    public static void main(String[] args) {

    }

    class Solution {
        Queue<int[]> queue;
        int sum;
        public Solution() {
            this.queue = new LinkedList<>();
            this.sum = 0;
        }

        public int getNow() {
            return  (int) System.currentTimeMillis();
        }

        public void record(int value) {
            int curTime = getNow();
            while (!queue.isEmpty() && curTime - queue.peek()[0] > 300) {
                int[] last = queue.poll();
                sum -= last[1];
            }
            queue.offer(new int[] {curTime, value});
            sum += value;
        }

        // get average from last 300 s
        public double getAvg() {
            if (queue.isEmpty()) return 0;
            int curTime = getNow();
            while (!queue.isEmpty() && curTime - queue.peek()[0] > 300) {
                int[] last = queue.poll();
                sum -= last[1];
            }
            return sum * 1.0 / queue.size();
        }
    }
}
