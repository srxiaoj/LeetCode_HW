import java.util.LinkedList;
import java.util.Queue;


public class RoundRobinScheduling {
    public static void main(String[] args) {

    }

    public float roundRobin(int[] arrtime, int[] exetime, int q) {
        if (arrtime == null || exetime == null || arrtime.length != exetime.length) return 0;
        int n = arrtime.length;
        Queue<process> queue = new LinkedList<process>();
        int curTime = 0, waitTime = 0;
        int index = 0;
        while (!queue.isEmpty() || index < n) {
            if (!queue.isEmpty()) {
                process cur = queue.poll();
                waitTime += curTime - cur.arrTime;
                curTime += Math.min(cur.exeTime, q);
                for (; index < n && arrtime[index] <= curTime; index++)
                    queue.offer(new process(arrtime[index], exetime[index]));
                if (cur.exeTime > q)
                    queue.offer(new process(curTime, cur.exeTime - q));
            } else {
                queue.offer(new process(arrtime[index], exetime[index]));
                curTime = arrtime[index++];
            }
        }
        return (float) waitTime / n;
    }
}


class process {
    int arrTime;
    int exeTime;

    process(int arr, int exe) {
        arrTime = arr;
        exeTime = exe;
    }
}