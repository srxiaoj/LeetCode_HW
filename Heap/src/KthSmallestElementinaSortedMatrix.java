import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by thanksgiving on 8/17/16.
 */
public class KthSmallestElementinaSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        System.out.println(kthSmallest(matrix, 8));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new MyComparator());
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            pq.add(new int[] {matrix[i][0], i, 0});
        }

        while (k > 0 && !pq.isEmpty()) {
            k--;
            int[] cur = pq.poll();
            res.add(cur[0]);
            int row = cur[1];
            int col = cur[2];
            if (col == n - 1) continue;
            pq.add(new int[] {matrix[cur[1]][cur[2] + 1], cur[1], cur[2] + 1});
        }
        return res.get(res.size() - 1);
    }

    static class MyComparator implements Comparator<int[]> {
        public int compare(int[] a, int [] b) {
            return a[0] - b[0];
        }
    }
}
