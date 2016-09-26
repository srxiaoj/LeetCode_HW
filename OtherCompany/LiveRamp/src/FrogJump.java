import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by thanksgiving on 9/26/16.
 */
public class FrogJump {
    public static void main(String[] args) {
        System.out.println(frogJump(new int[] {1, 3, 1, 4, 2, 5}, 7, 3));
    }

    public static int frogJump(int[] array, int X, int D) {
        if (array == null || array.length == 0 || X <= D) return 0;

        int[] res = new int[X + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(X, 0);
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i]))
                // the earliest time reach *position* array[i] is *time* i
                map.put(array[i], i);
        }

        for (int pos = 1; pos <= X; pos++) {
            if (map.containsKey(pos)) {
                if (pos <= D) {
                    res[pos] = map.get(pos);
                } else {
                    for (int step = 1; step <= D; step++) {
                        if (map.get(pos) < res[pos - step]) {
                            res[pos] = Math.min(res[pos], res[pos - step]);
                        } else {
                            res[pos] = Math.min(res[pos], map.get(pos));
                        }
                    }
                }
            }
        }
        return res[X] == Integer.MAX_VALUE ? -1 : res[X];
    }


    public static int frogJump2(int[] arr, int X, int D) {

        class DisjointSet {
            private java.util.concurrent.ConcurrentSkipListMap<Integer, Integer> parent;

            public DisjointSet() {
                parent = new java.util.concurrent.ConcurrentSkipListMap<>();
            }

            public boolean check(int x, int y) {
                return findRoot(x) != -1 && findRoot(x) == findRoot(y);
            }

            public boolean addLeaf(int x) {
                if (parent.containsKey(x)) {
                    return false;
                }
                parent.put(x, x);
                if (0 < x && x < X) {
                    int other = parent.lowerKey(x);
                    if (x - other <= D) {
                        merge(x, other);
                    }
                    other = parent.higherKey(x);
                    if (other - x <= D) {
                        merge(x, other);
                    }
                }
                return true;
            }

            public int findRoot(int x) {
                if (parent.get(x) == null) {
                    return -1;
                }
                if (parent.get(x) == x) {
                    return x;
                }
                int ans = findRoot(parent.get(x));
                parent.put(x, ans);
                return ans;
            }

            public void merge(int x, int y) {
                int rx = findRoot(x);
                int ry = findRoot(y);
                parent.put(ry, rx);
            }
        }
        // end of disjoint set definition.

        if (X <= D) {
            return 0;
        }

        DisjointSet ds = new DisjointSet();
        ds.addLeaf(0);
        ds.addLeaf(X);

        for (int i = 0; i < arr.length; i++) {
            if (ds.addLeaf(arr[i]) && ds.check(0, X)) {
                return i;
            }
        }
        return -1;
    }
}
