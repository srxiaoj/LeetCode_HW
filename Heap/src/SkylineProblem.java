import java.util.*;

/**
 * Created by thanksgiving on 9/29/16.
 */
public class SkylineProblem {
    public static void main(String[] args) {
        printArray(getSkyline(new int[][]{
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}
        }));
    }

    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }

        Collections.sort(height, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        });
        System.out.println("height: ");
        printArray(height);
//        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.offer(0);
        int prev = 0;
        for (int[] h : height) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else { // if h[1] > 0, means this building is finished
                pq.remove(h[1]);
            }
            // get the current highest height from priorityqueue
            int curHighest = pq.peek();
            if (prev != curHighest) {
                res.add(new int[]{h[0], curHighest});
                prev = curHighest;
            }
        }
        return res;
    }

    //print array
    public static void printArray(List<int[]> A) {
        System.out.print("[");
        for (int i = 0; i < A.size(); i++) {
            if (i != A.size() - 1)
                System.out.print("[" + A.get(i)[0] + ", " + A.get(i)[1] + "]" + ", ");
            else
                System.out.print("[" + A.get(i)[0] + ", " + A.get(i)[1] + "]");
        }
        System.out.println("]");
    }
}
