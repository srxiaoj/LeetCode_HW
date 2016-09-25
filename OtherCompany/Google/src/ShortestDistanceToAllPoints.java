import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by thanksgiving on 9/21/16.
 */
public class ShortestDistanceToAllPoints {
    public static void main(String[] args) {
        int[][] points = {{-10, 2}, {-8, -4}, {-6, 7}, {-5, 3}, {-4, -1}, {5, 1}, {15, 9}};
        System.out.println(shortDist(points));
    }

    public static int shortDist(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int n = points.length;
        int[][] x = new int[n][2];
        int[][] y = new int[n][2];
        for (int i = 0; i < n; i++) {
            x[i] = new int[]{points[i][0], i};
            y[i] = new int[]{points[i][1], i};
        }
        // x axis
        Arrays.sort(x, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1];
            }
        });

        // y axis
        Arrays.sort(y, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1];
            }
        });

        int[] xRes = new int[n];
        int[] xReverse = new int[n];

        int[] yRes = new int[n];
        int[] yReverse = new int[n];
        for (int i = 1; i < n; i++) {
            xRes[i] = xRes[i - 1] + i * (x[i][0] - x[i - 1][0]);
            yRes[i] = yRes[i - 1] + i * (y[i][0] - y[i - 1][0]);
        }

        for (int i = n - 2; i >= 0; i--) {
            xReverse[i] = xReverse[i + 1] + (n - 1 - i) * (x[i + 1][0] - x[i][0]);
            xRes[i] += xReverse[i];
            yReverse[i] += yReverse[i + 1] + (n - 1 - i) * (y[i + 1][0] - y[i][0]);
            yRes[i] += xReverse[i];
        }
        printArray(xRes);
        printArray(yRes);

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[x[i][1]] += xRes[i];
        }

        int[] minPoint = new int[] {-1, -1};
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res[y[i][1]] += yRes[i];
            if (min > res[y[i][1]]) {
                min = res[y[i][1]];
                minPoint = points[y[i][1]];
            }
        }
        System.out.println("min point: [" + minPoint[0] + "," + minPoint[1] + "]");
        return min;
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
