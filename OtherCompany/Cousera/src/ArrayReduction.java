import java.util.PriorityQueue;

/**
 * Created by thanksgiving on 9/9/16.
 */
public class ArrayReduction {
    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        System.out.println(reductionCost(num));
    }

    public static int reductionCost(int[] num) {
        if (num == null || num.length == 0) return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int total = 0;
        for (int i = 0; i < num.length; i++) {
            pq.offer(num[i]);
        }

        while (pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            total += num1 + num2;
            pq.offer(num1 + num2);
        }
        return total;
    }
}
