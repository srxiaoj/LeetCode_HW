import java.util.*;

/**
 * Created by thanksgiving on 7/7/16.
 */
public class RearrangeSameCharMinDistance {
    public static void main(String[] args) {
        System.out.println(rearrange("abb", 2));
        System.out.println(rearrange("aacbbc", 3));
        System.out.println(rearrange("geeksforgeeks", 3));
        System.out.println(rearrange("aaa", 3));
    }

    public static String rearrange(String s, int d) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!charMap.containsKey(c)) {
                charMap.put(c, 1);
            } else {
                charMap.put(c, charMap.get(c) + 1);
            }
        }

        Point[] points = new Point[charMap.size()];
        int i = 0;
        for (Character c : charMap.keySet()) {
            points[i] = new Point(c, charMap.get(c));
            i++;
        }

        Arrays.sort(points, new Point());
        char[] res = new char[s.length()];
        int j = 0;
        for (i = 0; i < points.length; i++) {
            // find next filling point
            for (int k = i; k < res.length; k++) {
                if (!Character.isAlphabetic(res[k])) {
                    j = k;
                    break;
                }
            }
            while (j < res.length && points[i].count > 0) {
                res[j] = points[i].val;
                j += d;
                points[i].count--;
            }
            if (points[i].count != 0) return null;
        }
        return new String(res);
    }

    private static class Point implements Comparator<Point> {
        char val;
        int count;

        public Point() {

        }
        public Point(char val, int count) {
            this.val = val;
            this.count = count;
        }

        public int compare(Point a, Point b) {
            if (b.count == a.count) return a.val - b.val;
            return b.count - a.count;
        }

        public String toString() {
            return val + ":" + count;
        }
    }
}
