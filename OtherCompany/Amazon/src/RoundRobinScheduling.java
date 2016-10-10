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
        int i = 0;
        while (!queue.isEmpty() || i < n) {
            if (!queue.isEmpty()) {
                process node = queue.poll();
                waitTime += curTime - node.arrTime;
                curTime += Math.min(node.exeTime, q);
                while (i < n && arrtime[i] <= curTime) {
                    queue.offer(new process(arrtime[i], exetime[i]));
                    i++;
                }
                if (node.exeTime > q)
                    queue.offer(new process(curTime, node.exeTime - q));
            } else {
                queue.offer(new process(arrtime[i], exetime[i]));
                curTime = arrtime[i++];
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