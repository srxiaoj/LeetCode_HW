import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class GraphValidTree {
    public static void main(String[] args) {
        GraphValidTree obj = new GraphValidTree();

        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int n = 5;
        System.out.println(obj.validTree(n, edges));
    }

    /**
     * method1: union find
     */
    public boolean validTreei1(int n, int[][] edges) {
        int[] root = new int[n];
        for(int i = 0; i < n; i++)
            root[i] = i;
        for(int i = 0; i < edges.length; i++) {
            int root1 = find(root, edges[i][0]);
            int root2 = find(root, edges[i][1]);
            if(root1 == root2)
                return false;
            root[root2] = root1;
        }
        return edges.length == n - 1;
    }

    private int find(int[] root, int e) {
        if(root[e] == e)
            return e;
        else
            return find(root, root[e]);
    }


    // method2: dfs
    private LinkedList<Integer> adj[];
    private void addEdge(int w, int v) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public boolean validTree(int n, int[][] edges) {
        // create adjacentList
        adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            addEdge(edges[i][0], edges[i][1]);
        }
        if (edges.length != n - 1) return false;
        if (isCyclic(n)) {
            return false;
        } else {
            return true;
        }
    }

    private Boolean isCyclic(int n) {
        Boolean visited[] = new Boolean[n];
        Arrays.fill(visited, false);

        for (int i = 0; i < n; i++) {
            if (!visited[i] && isCyclicUntil(i, visited, -1)) {
                return true;
            }
        }
        return false;
    }

    private Boolean isCyclicUntil(int v, Boolean visited[], int parent) {
        visited[v] = true;

        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            int i = it.next();
            if (!visited[i]) {
                if (isCyclicUntil(i, visited, v)) {
                    return true;
                }
            } else if (i != parent) {
                return true;
            }
        }
        return false;
    }
}
