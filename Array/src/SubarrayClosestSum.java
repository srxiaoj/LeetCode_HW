import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by thanksgiving on 7/7/16.
 */
public class SubarrayClosestSum {
    public static void main(String[] args) {
//        int[] a = {-3, 2, -1, 1, 5, -2};
//        System.out.println(subarraySumCloseToZero(a));

        int[] b = {-3, 2, 1, 1, 5, -3};
        System.out.println(subarraySumCloseToZero(b));
    }

    public static int subarraySumCloseToZero(int[] a) {
        Point[] sum = new Point[a.length + 1];
        sum[0] = new Point(0, -1);
        for (int i = 1; i <= a.length; i++) {
            sum[i] = new Point(sum[i - 1].val + a[i - 1], i - 1);
        }

        Arrays.sort(sum, new Point());
        int start = Math.min(sum[0].index, sum[1].index) + 1;
        int end = Math.max(sum[0].index, sum[1].index);
        int min = Math.abs(sum[1].val - sum[0].val);
        for (int i = 1; i < sum.length - 1; i++) {
            if (Math.abs(sum[i + 1].val - sum[i].val) < min) {
                min = Math.abs(sum[i + 1].val - sum[i].val);
                start = Math.min(sum[i].index, sum[i + 1].index) + 1;
                end = Math.max(sum[i].index, sum[i + 1].index);
            }
        }
        System.out.println(start + " " + end);
        return end - start + 1;

    }

    private static class Point implements Comparator<Point> {
        int val;
        int index;

        public Point() {

        }

        public Point(int val, int index) {
            this.val = val;
            this.index = index;
        }

        public int compare(Point a, Point b) {
            return a.val - b.val;
        }

        public String toString() {
            return "[" + index + "]: " + val;
        }
    }
}
