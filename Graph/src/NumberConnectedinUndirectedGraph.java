/**
 * Created by thanksgiving on 4/23/16.
 */
public class NumberConnectedinUndirectedGraph {
    public static void main(String[] args) {
        NumberConnectedinUndirectedGraph obj = new NumberConnectedinUndirectedGraph();
        int[][] edges = {
                {0, 1},
                {1, 2},
                {3, 4}
        };
        System.out.println(obj.countComponents(5, edges));

    }

    public int countComponents(int n, int[][] edges) {
        if (n <= 1) return n;
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        for (int[] edge : edges) {
            int x = find(roots, edge[0]);
            int y = find(roots, edge[1]);
            if (x != y) {
                roots[x] = y;
                n--;
            }
        }
        return n;
    }

    public int find(int[] roots, int id) {
        int x = id;
        while (roots[id] != id) {
            id = roots[id];
        }
        while (roots[x] != id) {
            int fa = roots[x];
            roots[x] = id;
            x = fa;
        }
        return id;
    }
}
