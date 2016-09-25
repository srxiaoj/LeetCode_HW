import java.util.*;

/**
 * Created by thanksgiving on 9/24/16.
 */
public class ClosestTwoPointsInSpace {
    public static void main(String[] args) {
        Point[] points = new Point[]{new Point(2, 3), new Point(12, 30), new Point(40, 50)
                , new Point(5, 1), new Point(12, 10), new Point(3, 4)};
        System.out.println(closestDist(points));
    }

    /**
     * http://www.geeksforgeeks.org/closest-pair-of-points/
     */
    public static double closestDist(Point[] points) {
        int n = points.length;
        Arrays.sort(points, new XComparator());
        return helper(points, 0, n - 1);
    }

    private static double helper(Point[] p, int l, int r) {
        if (r - l + 1 <= 3) {
            return bruteforce(p, l, r);
        }
        int mid = l + (r - l) / 2;
        Point midPoint = p[mid];

        double left = helper(p, l, mid);
        double right = helper(p, mid + 1, r);
        double d = Math.min(left, right);
        List<Point> strip = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (Math.abs(p[i].x - midPoint.x) < d) {
                strip.add(p[i]);
            }
        }
        return Math.min(d, stripClosest(strip, d));
    }

    /**
     * A utility function to find the distance beween the closest points of
     * strip of given size. All points in strip[] are sorted accordint to
     * y coordinate. They all have an upper bound on minimum distance as d.
     * Note that this method seems to be a O(n^2) method, but it's a O(n)
     * method as the inner loop runs at most 6 times
     */
    private static double stripClosest(List<Point> strip, double d) {
        if (strip.size() < 2) return d;
        Collections.sort(strip, new YComparator());
        double min = d;
        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && dist(strip.get(i), strip.get(j)) < min; j++) {
                min = dist(strip.get(i), strip.get(j));
            }
        }
        return min;
    }

    static double dist(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    static double bruteforce(Point[] p, int l, int r) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = l; i <= r; i++) {
            for (int j = i + 1; j <= r; j++) {
                if (dist(p[i], p[j]) < min) {
                    min = dist(p[i], p[j]);
                }
            }
        }
        return min;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    static class XComparator implements Comparator<Point> {
        public int compare(Point a, Point b) {
            return a.x - b.x;
        }
    }

    static class YComparator implements Comparator<Point> {
        public int compare(Point a, Point b) {
            return a.y - b.y;
        }
    }
}
