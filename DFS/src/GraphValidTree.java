import java.util.Iterator;
import java.util.LinkedList;

public class GraphValidTree {
    private int V;
    private LinkedList<Integer> adj[];
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int n = 5;
        GraphValidTree obj = new GraphValidTree();

        System.out.println(obj.validTree(n, edges));
    }
    public void initGraphValidTree(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }
    private void addEdge(int w, int v) {
        adj[v].add(w);
        adj[w].add(v);
    }
    public boolean validTree(int n, int[][] edges) {
        initGraphValidTree(n);
        for (int i = 0; i < edges.length; i++) {
            addEdge(edges[i][0], edges[i][1]);
        }
        if (edges.length != n - 1) return false;
        if (isCyclic()) {
            return false;
        } else {
            return true;
        }
    }

    private Boolean isCyclic() {
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        for (int u = 0; u < V; u++) {
            if (!visited[u] && isCyclicUntil(u, visited, -1)) {
                return true;
            }
        }
        return false;
    }

    private Boolean isCyclicUntil(int v, Boolean visited[], int parent) {
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();
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
