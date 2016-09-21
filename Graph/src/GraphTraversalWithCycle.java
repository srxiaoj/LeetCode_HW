import java.util.LinkedList;
import java.util.List;

/**
 * Created by thanksgiving on 9/20/16.
 */
public class GraphTraversalWithCycle {
    public static void main(String args[]) {
        GraphTraversalWithCycle g = new GraphTraversalWithCycle(5);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 0);

        System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

        g.traversal();
    }

    private int V;
    private LinkedList<Integer> adj[];

    public GraphTraversalWithCycle(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    private void dfs(int v, boolean[] visited) {
        if (visited[v]) return;
        visited[v] = true;
        System.out.print(v + " ");

        List<Integer> nexts = adj[v];
        for (int next : nexts) {
            dfs(next, visited);
        }
    }

    // The function to do traversal traversal. It uses recursive dfs()
    public void traversal() {
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            dfs(i, visited);
        }
    }
}
