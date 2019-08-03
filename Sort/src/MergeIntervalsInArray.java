import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervalsInArray {

  public static void main(String[] args) {
    int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    print2dArray(merge(intervals));
  }

  public static int[][] merge(int[][] intervals) {
    PriorityQueue<int[]> pq = new PriorityQueue(new IntervalComparator());
    for (int[] a : intervals) {
      pq.offer(a);
    }

    List<int[]> res = new ArrayList<>();
    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      while (!pq.isEmpty() && pq.peek()[0] <= cur[1]) {
        cur[1] = Math.max(pq.peek()[1], cur[1]);
        pq.poll();
      }
      res.add(cur);
    }

    int[][] output = new int[res.size()][2];
    for (int i = 0; i < res.size(); i++) {
      output[i] = res.get(i);
    }
    return output;
  }

  static class IntervalComparator implements Comparator<int[]> {

    public int compare(int[] a, int[] b) {
      return a[0] - b[0];
    }
  }

  private static void print2dArray(int[][] A) {
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[i].length; j++) {
        if (j != A[i].length - 1) {
          System.out.print(A[i][j] + ", ");
        } else {
          System.out.print(A[i][j]);
        }

      }
      System.out.println("");
    }
    System.out.println("");
  }
}
