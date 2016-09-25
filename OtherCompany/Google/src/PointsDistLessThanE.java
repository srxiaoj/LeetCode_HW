import java.util.*;

/**
 * Created by thanksgiving on 9/24/16.
 */
public class PointsDistLessThanE {
    public static void main(String[] args) {
        Point[] points = new Point[]{new Point(2, 3), new Point(6, 3), new Point(40, 50)
                , new Point(5, 1), new Point(6, 30), new Point(3, 4)};
        System.out.println(pointsDistanceLessThanE(points, 15));

//        List<Point> a = new ArrayList<>(Arrays.asList(new Point(1, 2), new Point(3, 4)));
//        List<Point> b = new ArrayList<>(Arrays.asList(new Point(1, 2), new Point(3, 4)));
//        System.out.println(a.equals(b));

    }

    public static Set<List<Point>> pointsDistanceLessThanE(Point[] points, double e) {
        Set<List<Point>> res = new HashSet<>();
        if (points == null || points.length == 0) return res;
        int n = points.length;
        Arrays.sort(points, new XComparator());
        helper(res, points, 0, n - 1, e);

        return res;
    }

    private static void helper(Set<List<Point>> res, Point[] p, int l, int r, double e) {
        if (r - l + 1 <= 3) {
            bruteforce(res, p, l, r, e);
            return;
        }
        int mid = l + (r - l) / 2;
        helper(res, p, l, mid, e);
        helper(res, p, mid + 1, r, e);

        List<Point> strip = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (Math.abs(p[i].x - p[mid].x) < e) {
                strip.add(p[i]);
            }
        }
        stripLessThanE(res, strip, e);
    }

    private static void stripLessThanE(Set<List<Point>> res, List<Point> strip, double e) {
        if (strip.size() < 2) return;
        Collections.sort(strip, new YComparator());
        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && dist(strip.get(i), strip.get(j)) < e; j++) {
                List<Point> list = Arrays.asList(new Point[]{strip.get(i), strip.get(j)});
                Collections.sort(list, new PointComparator());
                res.add(list);
            }
        }
    }

    static double dist(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    static void bruteforce(Set<List<Point>> res, Point[] p, int l, int r, double e) {
        for (int i = l; i <= r; i++) {
            for (int j = i + 1; j <= r && dist(p[i], p[j]) < e; j++) {
                List<Point> list = Arrays.asList(new Point[]{p[i], p[j]});
                Collections.sort(list, new PointComparator());
                res.add(list);
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            return o instanceof Point && ((Point) o).x == this.x && ((Point) o).y == this.y;
        }

        public int hashCode() {
            int hashCode = 1;
            hashCode = 31 * hashCode + x;
            hashCode = 31 * hashCode + y;
            return hashCode;
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

    static class PointComparator implements Comparator<Point> {
        public int compare(Point a, Point b) {
            if (a.x != b.x) return a.x - b.x;
            return a.y - b.y;
        }
    }
}
