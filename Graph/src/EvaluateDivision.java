import java.util.*;

/**
 * Created by thanksgiving on 9/16/16.
 */
public class EvaluateDivision {
    public static void main(String[] args) {
        String[][] equations = new String[][]{{"a", "b"}, {"b", "c"}};
        double[] values = new double[]{2.0, 3.0};
        String[][] queries = new String[][]{{"a", "c"}, {"b", "c"}, {"a", "e"}, {"a", "a"}, {"x", "x"}, {"c", "c"}};
        printArray(calcEquation(equations, values, queries));
    }

    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if (equations == null || equations.length == 0) return new double[0];
        int n = equations.length;
        double[] res = new double[queries.length];

        Map<String, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String a = equations[i][0];
            String b = equations[i][1];
            double val = values[i];
            List<Pair> list;
            if (!map.containsKey(a)) {
                list = new ArrayList<>();
            } else {
                list = map.get(a);
            }
            list.add(new Pair(b, val));
            map.put(a, list);

            if (!map.containsKey(b)) {
                list = new ArrayList<>();
            } else {
                list = map.get(b);
            }
            list.add(new Pair(a, (1.0 / val)));
            map.put(b, list);
        }

        for (int i = 0; i < queries.length; i++) {
            String a = queries[i][0];
            String b = queries[i][1];
            double[] temp = new double[1];
            temp[0] = -1.0;
            Set<String> visit = new HashSet<>();
            helper(temp, a, b, map, 1.0, visit);
            res[i] = temp[0];
        }
        return res;
    }

    private static void helper(double[] temp, String a, String b, Map<String, List<Pair>> map, double cur, Set<String> visit) {
        if (visit.contains(a)) return;
        if (!map.containsKey(a) || !map.containsKey(b)) {
            temp[0] = -1.0;
            return;
        }

        if (a.equals(b)) {
            temp[0] = 1.0;
            return;
        }

        visit.add(a);
        List<Pair> nexts = map.get(a);
        for (Pair next : nexts) {
            if (!visit.contains(b) && next.key.equals(b)) {
                temp[0] = cur * next.val;
                return;
            }
            helper(temp, next.key, b, map, cur * next.val, visit);
        }
        visit.remove(a);
    }

    static class Pair {
        double val;
        String key;

        public Pair(String key, double val) {
            this.key = key;
            this.val = val;
        }

        public String toString() {
            return "[" + key + "," + val + "]";
        }
    }

    //print array
    public static void printArray(double[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }

    /**
     * print 2D array.
     */
    public static void printArray(String[][] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print("[");
            for (int j = 0; j < A[i].length; j++) {
                if (j != A[i].length - 1) {
                    System.out.print(A[i][j] + ", ");
                } else
                    System.out.print(A[i][j]);

            }
            System.out.println("]");
        }
        System.out.println("");
    }
}
