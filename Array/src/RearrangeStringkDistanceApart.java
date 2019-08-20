import java.util.*;

/**
 * Created by thanksgiving on 7/7/16.
 */
public class RearrangeStringkDistanceApart {
    public static void main(String[] args) {
        System.out.println(rearrange("abb", 2));
        System.out.println(rearrange("aacbbc", 3));
        System.out.println(rearrange("geeksforgeeks", 3));
        System.out.println(rearrange("aaa", 3));
        System.out.println(rearrange("aabbcc", 2));
        System.out.println(rearrange("aaabc", 2));
        System.out.println(rearrange("aa", 2));
    }


    public static String rearrangeString(String s, int d) {
        if (d < 2) return s;
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        SortedSet<int[]> set = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0]);
            }
        });

        int maxtimes = 0, count = 0, maxlen = s.length() / d + ((s.length() % d == 0) ? 0 : 1);
        for (int i = 0; i < 26; i++) {
            if (chars[i] != 0) {
                set.add(new int[]{chars[i], i});
                if (chars[i] > maxtimes) {
                    maxtimes = chars[i];
                    count = 1;
                } else if (chars[i] == maxtimes) {
                    // number of chars has the same max times
                    count++;
                }
            }
        }

        if (maxtimes > maxlen || (maxtimes == maxlen && (maxtimes - 1) * d + count > s.length())) return "";
        int cycles = 0;
        int cur = cycles;
        Iterator<int[]> it = set.iterator();
        char[] res = new char[s.length()];
        while (it.hasNext()) {
            int[] e = it.next();
            for (int i = 0; i < e[0]; i++) {
                res[cur] = (char) ('a' + e[1]);
                cur += d;
                if (cur >= s.length()) {
                    cur = ++cycles;
                }
            }
        }
        return new String(res);
    }

    public static String rearrange(String s, int d) {
        if (d == 0) return s;
        Map<Character, Integer> charMap = new java.util.HashMap<>();
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
        int maxtimes = points[0].count;
        int count = 0;
        i = 0;
        while (i < points.length && points[i].count == maxtimes) {
            count++;
            i++;
        }
        int maxLen = s.length() / d + (s.length() % d == 0 ? 0 : 1);
        if (maxtimes > maxLen || (maxtimes == maxLen && (maxtimes - 1) * d + count > s.length())) return "";

        char[] res = new char[s.length()];
        int cur = 0;
        int cycle = 0;
        for (i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].count; j++) {
                res[cur] = points[i].val;
                cur += d;
                if (cur >= s.length()) {
                    cur = ++cycle;
                }
            }
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
